package edu.cnm.deepdive.intergalacticUnknown.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.TripDao;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.ResourceSummary;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

public class TripRepository {


  private final Context context;
  private final TripDao tripDao;


  public TripRepository(Context context) {
    this.context = context;
    IntergalacticUnknownDatabase database = IntergalacticUnknownDatabase.getInstance();
    tripDao = database.getTripDao();

  }

  public Single<Trip> save(Trip trip) {
    return (
        (trip.getId() > 0)
            ? tripDao
            .update(trip)
            .map((ignored) -> trip)
            : tripDao
                .insert(trip)
                .map((id) -> {
                  trip.setId(id);
                  return trip;
                })
    )
        .subscribeOn(Schedulers.io());
  }

  LiveData<Trip> getTrip(long tripId) {
    return tripDao.select(tripId);

  }
}

