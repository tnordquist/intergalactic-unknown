package edu.cnm.deepdive.intergalacticunknown.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticunknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticunknown.model.pojo.TripWithLandings;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
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

  @Transaction
  @Query("SELECT t.* "
      + "FROM trip AS t "
      + "WHERE t.trip_id = :tripId")
  LiveData<TripWithLandings> select(long tripId);

}
