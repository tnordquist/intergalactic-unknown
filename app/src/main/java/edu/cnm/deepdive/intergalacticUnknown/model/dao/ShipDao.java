package edu.cnm.deepdive.intergalacticUnknown.model.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Ship;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

public interface ShipDao {

  @Insert
  Single<Long> insert(Ship ship);

  @Insert
  Single<List<Long>> insert(Ship... ships);

  @Insert
  Single<List<Long>> insert(Collection<? extends Ship> ships);

  @Update
  Single<Integer> update(Ship ship);

  @Update
  Single<Integer> update(Ship... ships);

  @Update
  Single<Integer> update(Collection<? extends Ship> ships);

  @Delete
  Single<Integer> delete(Ship ship);

  @Delete
  Single<Integer> delete(Ship... ships);

  @Delete
  Single<Integer> delete(Collection<? extends Ship> ships);

}
