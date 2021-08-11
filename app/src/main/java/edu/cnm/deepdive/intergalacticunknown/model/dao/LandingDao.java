package edu.cnm.deepdive.intergalacticunknown.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticunknown.model.entity.Landing;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface LandingDao {


  @Insert
  Single<Long> insert(Landing landing);

  @Insert
  Single<List<Long>> insert(Landing... Landings);

  @Insert
  Single<List<Long>> insert(Collection<? extends Landing> Landings);

  @Update
  Single<Integer> update(Landing landing);

  @Update
  Single<Integer> update(Landing... Landings);

  @Update
  Single<Integer> update(Collection<? extends Landing> Landings);

  @Delete
  Single<Integer> delete(Landing landing);

  @Delete
  Single<Integer> delete(Landing... Landings);

  @Delete
  Single<Integer> delete(Collection<? extends Landing> Landings);

  @Transaction
  @Query("SELECT * FROM landing WHERE landing_id = :landingId ")
  LiveData<Landing> select(long landingId);

  @Transaction
  @Query("SELECT l.* "
      + "FROM landing AS l "
      + "WHERE l.trip_id = :tripId "
      + "ORDER BY l.created ASC")
  LiveData<List<Landing>> landingOrder(long tripId);
}
