package edu.cnm.deepdive.intergalacticUnknown.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

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

  @Query("SELECT * FROM landing WHERE landing_id = :landingID ")
  LiveData<Landing> select(long landingID);

}
