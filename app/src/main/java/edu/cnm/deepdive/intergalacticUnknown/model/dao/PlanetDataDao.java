package edu.cnm.deepdive.intergalacticUnknown.model.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.PlanetData;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

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

}
