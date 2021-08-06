package edu.cnm.deepdive.intergalacticUnknown.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.DeltaDao;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.LandingDao;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.TripDao;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Delta;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.ResourceSummary;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.TripWithLandings;
import edu.cnm.deepdive.intergalacticUnknown.model.types.PlanetType;
import edu.cnm.deepdive.intergalacticUnknown.model.types.ResourceType;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
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
    return tripDao
        .insert(trip)
        .map((id) -> {
          trip.setId(id);
          return trip;
        })
        //top
        .flatMap((updatedTrip) -> {
          List<Delta> deltas = Arrays
              .stream(ResourceType.values())
              .map((resourceType) -> {
                Delta delta = new Delta();
                delta.setTripId(updatedTrip.getId());
                delta.setResourceType(resourceType);
                delta.setAmount(resourceType.getInitialLevel());
                if(resourceType == freeResource){
                  delta.setAmount(delta.getAmount() + 1);}
                return delta;
              })
              .collect(Collectors.toList());
          return deltaDao
              .insert(deltas) //Single<List<Long>>
              .map((ids) -> updatedTrip);
        })
        //bottom
        .flatMap((updatedTrip) -> {
          Landing landing = new Landing();
          landing.setTripId(updatedTrip.getId());
          return landingDao
              .insert(landing)
              .map((id) -> {
                landing.setId(id);
                updatedTrip.getLandings().add(landing);
                return landing;
              });
        })//started here
        .flatMap((updatedLanding) -> {
          List<Delta> deltas = Arrays
              .stream(PlanetType.values())
              .map((valueType) -> {
                Delta delta = new Delta();
                delta.setLandingId(updatedLanding.getId());
                delta.setResourceType(PlanetType.FROZEN.getProduces());
                delta.setId(updatedLanding.getId());
                delta.setTripId(updatedLanding.getTripId());
                if(updatedLanding.getPlanetType() == initialPlanet){
                  delta.setAmount(delta.getAmount() -1 );}
                return delta;
              })
              .collect(Collectors.toList());
          return deltaDao
              .insert(deltas)
              .map((ids) -> updatedLanding);
        })
        //TODO Completed - confirm with nick - use flat map to create and insert deltas for this landing, similar to lines 69 - 85, deltas are based on consumption amount change to negative when chance.
        .map((landing) -> trip)
        .subscribeOn(Schedulers.io());

  }

}

