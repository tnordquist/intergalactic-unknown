package edu.cnm.deepdive.intergalacticUnknown.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.ResourceSummary;
import edu.cnm.deepdive.intergalacticUnknown.service.DeltaRepository;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class MainViewModel extends AndroidViewModel {

  private final DeltaRepository deltaRepository;

  //private final LiveData<List<ResourceSummary>> resourceSummaryList;
  private final MutableLiveData<Long> tripId;
  private final MutableLiveData<Trip> trip;
  private final MutableLiveData<Landing> landing;




  public MainViewModel(
      @NonNull Application application) {
    super(application);
    deltaRepository = new DeltaRepository(application);
    tripId = new MutableLiveData<>();
    trip = new MutableLiveData<>();
    landing = new MutableLiveData<>();
  }

  public LiveData<Trip> getTrip(){
    return trip;
  }

  public void setTripId(long id) {
    tripId.setValue(id);
  }

  public MutableLiveData<Landing> getLanding() {
    return landing;
  }

  // setting up methods so we can go into main activity (controller) field notes on todd github.

}
