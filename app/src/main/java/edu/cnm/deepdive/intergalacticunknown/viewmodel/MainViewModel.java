package edu.cnm.deepdive.intergalacticunknown.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.intergalacticunknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticunknown.model.pojo.ResourceSummary;
import edu.cnm.deepdive.intergalacticunknown.model.pojo.TripWithLandings;
import edu.cnm.deepdive.intergalacticunknown.model.types.PlanetType;
import edu.cnm.deepdive.intergalacticunknown.model.types.ResourceType;
import edu.cnm.deepdive.intergalacticunknown.service.DeltaRepository;
import edu.cnm.deepdive.intergalacticunknown.service.GoogleSignInService;
import edu.cnm.deepdive.intergalacticunknown.service.TripRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Random;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final DeltaRepository deltaRepository;
  private final TripRepository tripRepository;

  //private final LiveData<List<ResourceSummary>> resourceSummaryList;
  private final MutableLiveData<Long> tripId;
  private final MutableLiveData<TripWithLandings> trip;
  private final MutableLiveData<Landing> landing;
  private final MutableLiveData<ResourceSummary> resourceSummary;
  private final MutableLiveData<Boolean> randomEventAcknowledged;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;
  private final GoogleSignInService service;
  private final MutableLiveData<PlanetType> randomPlanetType;
  private final Random random;


  private final MutableLiveData<Boolean> mineAttempt;


  public MainViewModel(@NonNull Application application) {   // no params beyond application.
    super(application);
    random = new Random();
    deltaRepository = new DeltaRepository(application);
    tripRepository = new TripRepository(application, random);
    tripId = new MutableLiveData<>();
    trip = new MutableLiveData<>(null);
    landing = new MutableLiveData<>();
    resourceSummary = new MutableLiveData<>();
    randomEventAcknowledged = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
    mineAttempt = new MutableLiveData<>();
    service = GoogleSignInService.getInstance();
    randomPlanetType = new MutableLiveData<>();

    //trying to add planet type into planet fragment, should use landing/

  }


  public LiveData<TripWithLandings> getTrip() {
    return trip;
  }

  public void setTripId(long id) {
    tripId.setValue(id);
  }

  public void startTrip(ResourceType freeResource, PlanetType initialPlanet) {

    throwable.setValue(null);
    pending.add(
        tripRepository
            .start(freeResource, initialPlanet)
            .subscribe(
                trip::postValue,
                this::setThrowable
            )
    );

  }

  public void continueTrip(ResourceType freeResource, PlanetType initialPlanet) {

    throwable.setValue(null);
    pending.add(
        tripRepository
            .continueTrip(trip.getValue(), freeResource, initialPlanet)
            .subscribe(
                trip::postValue,
                this::setThrowable
            )
    );

  }


  public void land(PlanetType planetType) {
    throwable.setValue(null);
    pending.add(
        tripRepository
            .land(trip.getValue(), planetType)
            .subscribe(
                trip::postValue,
                this::setThrowable
            )
    );

  }

  public void generateRandomPlanetType() {
    this.randomPlanetType.setValue(PlanetType.values()[random.nextInt(PlanetType.values().length)]);
  }

  public LiveData<Landing> getLanding() {

    return landing;
  }

  public LiveData<PlanetType> getRandomPlanetType() {
    return randomPlanetType;
  }

  public LiveData<ResourceSummary> getResourceSummary() {
    return resourceSummary;
  }

  public LiveData<Boolean> getRandomEventAcknowledged() {
    return randomEventAcknowledged;
  }

  public void acknowledgeRandomEvent() {
    randomEventAcknowledged.setValue(true);
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }


  private void setThrowable(Throwable throwable) {
    Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
    this.throwable.postValue(throwable);
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }


  public MutableLiveData<Boolean> getMineAttempt() {

    return mineAttempt;
  }


}
