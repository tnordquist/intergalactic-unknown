package edu.cnm.deepdive.intergalacticUnknown.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.DeltaDao;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Delta;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.ResourceSummary;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class DeltaRepository {

  private final Context context;

  private final DeltaDao deltaDao;

  public DeltaRepository(Context context) {
    this.context = context;
    IntergalacticUnknownDatabase database = IntergalacticUnknownDatabase.getInstance();
    deltaDao = database.getDeltaDao();
  }

  public Single<Delta> save(Delta delta) {
    return (
        (delta.getId() > 0)
        ? deltaDao
        .update(delta)
            .map((ignored) -> delta)
            : deltaDao
        .insert(delta)
        .map((id) -> {
          delta.setId(id);
          return delta;
        })
    )
        .subscribeOn(Schedulers.io());
  }




  LiveData<List<ResourceSummary>> getResourceSummary(long tripId){

    return deltaDao.getResourceSummaryLiveData(tripId);
  }

}
