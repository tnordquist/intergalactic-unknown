package edu.cnm.deepdive.intergalacticUnknown.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.PlanetData;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface PlanetDataDao {

  @Insert
  Single<Long> insert(PlanetData planetData);

  @Insert
  Single<List<Long>> insert(PlanetData... planetData);  //datas?

  @Insert
  Single<List<Long>> insert(Collection<? extends PlanetData> planetData);

  @Update
  Single<Integer> update(PlanetData planetData);

  @Update
  Single<Integer> update(PlanetData... planetData);

  @Update
  Single<Integer> update(Collection<? extends PlanetData> planetData);

  @Delete
  Single<Integer> delete(PlanetData planetData);

  @Delete
  Single<Integer> delete(PlanetData... planetData);

  @Delete
  Single<Integer> delete(Collection<? extends PlanetData> planetData);

  @Query("SELECT * FROM planetdata WHERE planet_data_id = :attemptId")
  LiveData<PlanetData> select(long attemptId);

}
