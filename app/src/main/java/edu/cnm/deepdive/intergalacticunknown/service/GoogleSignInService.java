package edu.cnm.deepdive.intergalacticunknown.service;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import edu.cnm.deepdive.intergalacticunknown.model.entity.User;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class GoogleSignInService {

  private static final String BEARER_TOKEN_FORMAT = "Bearer %s";

  private static Application context;

  private final GoogleSignInClient client;

  private GoogleSignInAccount account;
  private final UserRepository userRepository;



  private GoogleSignInService() {
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
        .build();
    client = GoogleSignIn.getClient(context, options);
    userRepository = new UserRepository(context);
  }

  public static void setContext(Application context) {
    GoogleSignInService.context = context;
  }

  public static GoogleSignInService getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public GoogleSignInAccount getAccount() {
    return account;
  }

  public Single<GoogleSignInAccount> refresh() {
    return Single.create((emitter) ->
        client.silentSignIn()
            .addOnSuccessListener(this::setAccount)
            .addOnSuccessListener(emitter::onSuccess)
            .addOnFailureListener(emitter::onError)
    );
  }

  public void startSignIn(Activity activity, int requestCode) {
    account = null;
    Intent intent = client.getSignInIntent();
    activity.startActivityForResult(intent, requestCode);
  }

  public Task<GoogleSignInAccount> completeSignIn(Intent data) {
    Task<GoogleSignInAccount> task = null;
    try {
      task = GoogleSignIn.getSignedInAccountFromIntent(data);
      setAccount(task.getResult(ApiException.class));
    } catch (ApiException e) {
      // Exception will be passed automatically to onFailureListener.
    }
    return task;
  }
  public Single<User> refreshUser() {
    return refresh()
        .observeOn(Schedulers.io())
        .flatMap((account) ->
            userRepository.insertUser(account.getId()));
  }

  public Task<Void> signOut() {
    return client.signOut()
        .addOnCompleteListener((ignored) -> setAccount(null));
  }

  private void setAccount(GoogleSignInAccount account) {
    this.account = account;
    if(account != null) {
    //  Log.d("Google Sign In Service", account.getIdToken());
    }
  }


  private static class InstanceHolder {

    private static final GoogleSignInService INSTANCE = new GoogleSignInService();

  }

}
