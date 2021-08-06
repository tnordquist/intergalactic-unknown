package edu.cnm.deepdive.intergalacticUnknown.service;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.DeltaDao;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.LandingDao;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.TripDao;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Delta;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.LandingWithDeltas;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.ResourceSummary;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.TripWithLandings;
import edu.cnm.deepdive.intergalacticUnknown.model.types.PlanetType;
import edu.cnm.deepdive.intergalacticUnknown.model.types.ResourceType;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class TripRepository {


  private final Context context;
  private final TripDao tripDao;
  private final LandingDao landingDao;
  private final DeltaDao deltaDao;
  private final Random random;


  public TripRepository(Context context, Random random) {
    this.context = context;
    IntergalacticUnknownDatabase database = IntergalacticUnknownDatabase.getInstance();
    tripDao = database.getTripDao();
    landingDao = database.getLandingDao();
    deltaDao = database.getDeltaDao();
    this.random = random;
  }

  public Single<Trip> save(Trip trip) {
    return (
        tripDao
            .insert(trip)
            .map((id) -> {
              trip.setId(id);
              return trip;
            })
    )
        .subscribeOn(Schedulers.io());
  }

  LiveData<TripWithLandings> getTrip(long tripId) {
    return tripDao.select(tripId);

  }

  public Single<TripWithLandings> start(ResourceType freeResource, PlanetType initialPlanet) {
    TripWithLandings trip = new TripWithLandings();
    trip.setAugmentedResource(freeResource);
    trip.setPreferredDestination(initialPlanet);
    return insertTrip(trip)
        //top
        .flatMap((updatedTrip) -> insertInitialDeltas(freeResource, updatedTrip))
        //bottom
        .flatMap(this::insertInitialLanding)//started here
        .flatMap((updatedLanding) -> insertLandingDelta(trip, updatedLanding))
        .subscribeOn(Schedulers.io());
  }

  @NonNull
  private Single<TripWithLandings> insertTrip(TripWithLandings trip) {
    return tripDao
        .insert(trip)
        .map((id) -> {
          trip.setId(id);
          return trip;
        });
  }

  @NonNull
  private Single<TripWithLandings> insertLandingDelta(TripWithLandings trip,
      Landing updatedLanding) {
    return deltaDao
        .getResourceSummary(updatedLanding.getTripId())
        .map(this::getResourceLevels)
        .flatMap((resourceLevels) -> {
          Delta delta = new Delta();
          delta.setTripId(updatedLanding.getTripId());
          delta.setLandingId(updatedLanding.getId());
          ResourceType consumed = updatedLanding.getPlanetType().getConsumes();
          if (resourceLevels.get(consumed) >= 1) {
            delta.setResourceType(consumed);
            delta.setAmount(-1);
          } else {
            delta.setResourceType(ResourceType.HEALTH);
            delta.setAmount(-1);
          }
          return deltaDao
              .insert(delta);
        })
        .map((id) -> trip);
  }


  @NonNull
  private Single<Landing> insertInitialLanding(TripWithLandings updatedTrip) {
    LandingWithDeltas landing = new LandingWithDeltas();
    landing.setTripId(updatedTrip.getId());
    return landingDao
        .insert(landing)
        .map((id) -> {
          landing.setId(id);
          updatedTrip.getLandings().add(landing);
          return landing;
        });
  }

  @NonNull
  private Single<TripWithLandings> insertInitialDeltas(ResourceType freeResource,
      TripWithLandings updatedTrip) {
    List<Delta> deltas = Arrays
        .stream(ResourceType.values())
        .map((resourceType) -> {
          Delta delta = new Delta();
          delta.setTripId(updatedTrip.getId());
          delta.setResourceType(resourceType);
          delta.setAmount(resourceType.getInitialLevel());
          if (resourceType == freeResource) {
            delta.setAmount(delta.getAmount() + 1);
          }
          return delta;
        })
        .collect(Collectors.toList());
    return deltaDao
        .insert(deltas) //Single<List<Long>>
        .map((ids) -> updatedTrip);
  }

  private Map<ResourceType, Integer> getResourceLevels(List<ResourceSummary> resources) {
    Map<ResourceType, Integer> map = new EnumMap<>(ResourceType.class);
    for (ResourceSummary summary : resources) {
      map.put(summary.getResourceType(), summary.getAmount());
    }
    return map;
  }

}

