package edu.cnm.deepdive.intergalacticunknown.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.intergalacticunknown.model.entity.User;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface UserDao {

  @Insert
  Single<Long> insert(User user);

  @Insert
  Single<List<Long>> insert(User... Users);

  @Insert
  Single<List<Long>> insert(Collection<? extends User> Users);

  @Update
  Single<Integer> update(User user);

  @Update
  Single<Integer> update(User... Users);

  @Update
  Single<Integer> update(Collection<? extends User> Users);

  @Delete
  Single<Integer> delete(User user);

  @Delete
  Single<Integer> delete(User... Users);

  @Delete
  Single<Integer> delete(Collection<? extends User> Users);

  @Query("SELECT * FROM user WHERE user_id = :userId")
  LiveData<User> select(long userId);

  @Query("SELECT * FROM user WHERE oauth_key = :oauthKey")
  Maybe<User> selectByOauthKey(String oauthKey);

}
