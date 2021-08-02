package edu.cnm.deepdive.intergalacticUnknown.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

public interface TripDao {


  @Insert
  Single<Long> insert(Trip trip);

  @Insert
  Single<List<Long>> insert(Trip... Trips);

  @Insert
  Single<List<Long>> insert(Collection<? extends Trip> Trips);

  @Update
  Single<Integer> update(Trip trip);

  @Update
  Single<Integer> update(Trip... Trips);

  @Update
  Single<Integer> update(Collection<? extends Trip> Trips);

  @Delete
  Single<Integer> delete(Trip trip);

  @Delete
  Single<Integer> delete(Trip... Trips);

  @Delete
  Single<Integer> delete(Collection<? extends Trip> Trips);

  @Query("SELECT * FROM trip WHERE trip_id = :tripId ")
  LiveData<Trip> select(long tripId);

}
