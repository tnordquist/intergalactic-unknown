package edu.cnm.deepdive.intergalacticUnknown.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.LandingDao;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.ResourceSummary;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class LandingRepository {

  private final Context context;

  private final LandingDao landingDao;

  public LandingRepository(Context context) {
    this.context = context;
    IntergalacticUnknownDatabase database = IntergalacticUnknownDatabase.getInstance();
    landingDao = database.getLandingDao();
  }
  public Single<Landing> save(Landing landing) {
    return (
        (landing.getId() > 0)
        ? landingDao
            .update(landing)
            .map((ignored) -> landing)
            : landingDao
        .insert(landing)
        .map((id) -> {
          landing.setId(id);
          return landing;
        })
        )
        .subscribeOn(Schedulers.io());
  }
  LiveData<List<Landing>> getLandingOrder(long tripId){
    return landingDao.landingOrder(tripId);
  }
}

