package edu.cnm.deepdive.intergalacticUnknown.service;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.intergalacticUnknown.R;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.DeltaDao;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.LandingDao;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.TripDao;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.UserDao;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Delta;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.User;
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
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class TripRepository {


  private final Context context;
  private final TripDao tripDao;
  private final LandingDao landingDao;
  private final DeltaDao deltaDao;
  private final Random random;

  private final IntergalacticUnknownProxy webService;

  private final GoogleSignInService signInService;
  private final UserDao userDao;
  private final Map<PlanetType, String[]> planetNames;
  private final int randomEventUniverse;

  public TripRepository(Context context) {
    this.context = context;
    IntergalacticUnknownDatabase database = IntergalacticUnknownDatabase.getInstance();
    tripDao = database.getTripDao();
    landingDao = database.getLandingDao();
    deltaDao = database.getDeltaDao();
    this.random = new Random();
    webService = IntergalacticUnknownProxy.getInstance();
    signInService = GoogleSignInService.getInstance();
    userDao = database.getUserDao();
    Resources resources = context.getResources();
    planetNames = new EnumMap<>(PlanetType.class);
    for (PlanetType planetType : PlanetType.values()) {
      int id = resources.getIdentifier(planetType.toString().toLowerCase() + "_names", "array",
          context.getPackageName());
      String[] names = resources.getStringArray(id);
      planetNames.put(planetType, names);
    }
    randomEventUniverse = resources.getInteger(R.integer.random_event_universe);
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
    if (random.nextInt(randomEventUniverse) == 0) {
      trip.setRandomEvent(true);
      trip.setPreferredDestination(PlanetType.values()[random.nextInt(PlanetType.values().length)]);
      trip.setAugmentedResource(
          ResourceType.values()[random.nextInt(ResourceType.values().length)]);
    } else {
      trip.setAugmentedResource(freeResource);
      trip.setPreferredDestination(initialPlanet);
    }
    return signInService
        .refreshUser()
        .map((user) -> {
          trip.setUserId(user.getId());
          return trip;
        })
        .flatMap(this::insertTrip)
        .flatMap(this::insertInitialDeltas)
        .flatMap(this::insertInitialLanding)
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

  public Single<User> insertUser(String oauthKey) {
    return userDao
        .selectByOauthKey(oauthKey)
        .switchIfEmpty(
            userDao
                .selectByOauthKey(oauthKey)
                .switchIfEmpty(
                    Single
                        .just(new User())
                        .map((user) -> {
                          user.setOauthKey(oauthKey);
                          return user;
                        })
                        .flatMap((user) -> userDao.insert(user)
                            .map((id) -> {
                              user.setId(id);
                              return user;
                            })
                        )
                )
                .subscribeOn(Schedulers.io()));
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
    landing.setPlanetType(updatedTrip.getPreferredDestination());
    String[] names = planetNames.get(updatedTrip.getPreferredDestination());
    //noinspection ConstantConditions
    String planetName = names[random.nextInt(names.length)];
    landing.setPlanetName(planetName);
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
  private Single<TripWithLandings> insertInitialDeltas(TripWithLandings updatedTrip) {
    List<Delta> deltas = Arrays
        .stream(ResourceType.values())
        .map((resourceType) -> {
          Delta delta = new Delta();
          delta.setTripId(updatedTrip.getId());
          delta.setResourceType(resourceType);
          delta.setAmount(resourceType.getInitialLevel());
          if (resourceType == updatedTrip.getAugmentedResource()) {
            delta.setAmount(delta.getAmount() + 1);
          }
          return delta;
        })
        .collect(Collectors.toList());
    return deltaDao
        .insert(deltas) //Single<List<Long>>
        .map((ids) -> {
          Iterator<Delta> deltaIterator = deltas.iterator();
          Iterator<Long> idIterator = ids.iterator();
          while (deltaIterator.hasNext() && idIterator.hasNext()) {
            deltaIterator.next().setId(idIterator.next());
          }
          updatedTrip.getDeltas().addAll(deltas);
          return updatedTrip;
        });
  }

  private Map<ResourceType, Integer> getResourceLevels(List<ResourceSummary> resources) {
    Map<ResourceType, Integer> map = new EnumMap<>(ResourceType.class);
    for (ResourceSummary summary : resources) {
      map.put(summary.getResourceType(), summary.getAmount());
    }
    return map;
  }

  public Single<User> getUserProfile() {
    return signInService.refresh()
        .observeOn(Schedulers.io())
        .flatMap((account) -> webService.getProfile(getBearerToken(account.getIdToken())))
        .subscribeOn(Schedulers.io());
  }

  private String getBearerToken(String idToken) {
    return String.format("Bearer %s", idToken);
  }

}

