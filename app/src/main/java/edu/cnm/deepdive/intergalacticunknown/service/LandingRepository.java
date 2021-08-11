package edu.cnm.deepdive.intergalacticunknown.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.intergalacticunknown.model.dao.LandingDao;
import edu.cnm.deepdive.intergalacticunknown.model.entity.Landing;
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
         landingDao
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

