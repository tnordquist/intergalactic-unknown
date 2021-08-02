package edu.cnm.deepdive.intergalacticUnknown.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import edu.cnm.deepdive.intergalacticUnknown.model.pojo.ResourceSummary;
import java.util.List;

@Dao
public interface DeltaDao {
//TODO build dao

  @Query("select d.resource_type, sum(d.amount) as amount "
      + "from trip as t "
      + "left join landing as ln on ln.trip_id = t.trip_id "
      + "left join delta as d on d.trip_id = t.trip_id or d.landing_id = ln.landing_id "
      + "where t.trip_id = :tripId "
      + "group by d.resource_type")
  LiveData<List<ResourceSummary>> getResourceSummary(long tripId);

}
