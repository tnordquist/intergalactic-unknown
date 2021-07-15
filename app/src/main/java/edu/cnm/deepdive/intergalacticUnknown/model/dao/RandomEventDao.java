package edu.cnm.deepdive.intergalacticUnknown.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.RandomEvent;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface RandomEventDao {

  @Insert
  Single<Long> insert(RandomEvent randomEvent);

  @Insert
  Single<List<Long>> insert(RandomEvent... randomEvents);

  @Insert
  Single<List<Long>> insert(Collection<? extends RandomEvent> randomEvents);

  @Update
  Single<Integer> update(RandomEvent randomEvent);

  @Update
  Single<Integer> update(RandomEvent... randomEvents);

  @Update
  Single<Integer> update(Collection<? extends RandomEvent> randomEvents);

  @Delete
  Single<Integer> delete(RandomEvent randomEvent);

  @Delete
  Single<Integer> delete(RandomEvent... randomEvents);

  @Delete
  Single<Integer> delete(Collection<? extends RandomEvent> randomEvents);

}
