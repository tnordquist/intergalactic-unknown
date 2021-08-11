package edu.cnm.deepdive.intergalacticunknown.service;

import android.content.Context;
import edu.cnm.deepdive.intergalacticunknown.model.dao.UserDao;
import edu.cnm.deepdive.intergalacticunknown.model.entity.User;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class UserRepository {

  private final Context context;
  private final UserDao userDao;

  public UserRepository(Context context) {
    this.context = context;
    userDao = IntergalacticUnknownDatabase.getInstance().getUserDao();
  }

  public Single<User> insertUser(String oauthKey) {
    return userDao
        .selectByOauthKey(oauthKey)
        .switchIfEmpty(
            userDao
                .selectByOauthKey(oauthKey)
                .switchIfEmpty(
                    Single
                        .just(new User())
                        .map((user) -> {
                          user.setOauthKey(oauthKey);
                          return user;
                        })
                        .flatMap((user) -> userDao.insert(user)
                            .map((id) -> {
                              user.setId(id);
                              return user;
                            })
                        )
                )
                .subscribeOn(Schedulers.io()));
  }
}
