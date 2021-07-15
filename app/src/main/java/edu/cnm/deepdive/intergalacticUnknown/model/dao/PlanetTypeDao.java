package edu.cnm.deepdive.intergalacticUnknown.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.PlanetType;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface PlanetTypeDao {

  @Insert
  Single<Long> insert(PlanetType planetType);

  @Insert
  Single<List<Long>> insert(PlanetType... planetTypes);

  @Insert
  Single<List<Long>> insert(Collection<? extends PlanetType> planetTypes);

  @Update
  Single<Integer> update(PlanetType planetType);

  @Update
  Single<Integer> update(PlanetType... games);

  @Update
  Single<Integer> update(Collection<? extends PlanetType> planetTypes);

  @Delete
  Single<Integer> delete(PlanetType planetType);

  @Delete
  Single<Integer> delete(PlanetType... planetTypes);

  @Delete
  Single<Integer> delete(Collection<? extends PlanetType> planetTypes);

}
