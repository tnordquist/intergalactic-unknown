package edu.cnm.deepdive.intergalacticunknown.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticunknown.model.entity.Delta;
import edu.cnm.deepdive.intergalacticunknown.model.pojo.ResourceSummary;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface DeltaDao {

  @Insert
  Single<Long> insert(Delta delta);

  @Insert
  Single<List<Long>> insert(Delta... deltas);

  @Insert
  Single<List<Long>> insert(Collection<? extends Delta> deltas);

  @Update
  Single<Integer> update(Delta delta);

  @Update
  Single<Integer> update(Delta... deltas);

  @Update
  Single<Integer> update(Collection<? extends Delta> deltas);

  @Delete
  Single<Integer> delete(Delta delta);

  @Delete
  Single<Integer> delete(Delta... deltas);

  @Delete
  Single<Integer> delete(Collection<? extends Delta> deltas);

  @Transaction
  @Query("select d.resource_type, sum(d.amount) as amount "
      + "from trip as t "
      + "left join landing as ln on ln.trip_id = t.trip_id "
      + "left join delta as d on d.trip_id = t.trip_id or d.landing_id = ln.landing_id "
      + "where t.trip_id = :tripId "
      + "group by d.resource_type")
  Single<List<ResourceSummary>> getResourceSummary(long tripId);

  //todo everything below is new

  @Transaction
  @Query("select d.resource_type, sum(d.amount) as amount "
      + "from trip as t "
      + "left join landing as ln on ln.trip_id = t.trip_id "
      + "left join delta as d on d.trip_id = t.trip_id or d.landing_id = ln.landing_id "
      + "where t.trip_id = :tripId "
      + "group by d.resource_type")
  LiveData<List<ResourceSummary>> getResourceSummaryLiveData(long tripId);





  //originally single

  //add two more queries, one that returns a list of deltas for given trip (live data), one that returns a list of deltas for a given landing. delta has trip id and landing id.

}
