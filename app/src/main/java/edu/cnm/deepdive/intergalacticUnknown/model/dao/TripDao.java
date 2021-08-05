package edu.cnm.deepdive.intergalacticUnknown.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.User;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.TripWithLandings;
import edu.cnm.deepdive.intergalacticUnknown.model.types.PlanetType;
import edu.cnm.deepdive.intergalacticUnknown.model.types.ResourceType;
import io.reactivex.Single;
import java.util.Collection;
import java.util.Date;
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
