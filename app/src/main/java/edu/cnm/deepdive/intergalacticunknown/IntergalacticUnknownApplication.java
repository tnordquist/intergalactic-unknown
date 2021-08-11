package edu.cnm.deepdive.intergalacticunknown;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.intergalacticunknown.service.GoogleSignInService;
import edu.cnm.deepdive.intergalacticunknown.service.IntergalacticUnknownDatabase;
import io.reactivex.schedulers.Schedulers;


public class IntergalacticUnknownApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    IntergalacticUnknownDatabase.setContext(this);
    IntergalacticUnknownDatabase
        .getInstance()
        .getUserDao()
        .delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
    GoogleSignInService.setContext(this);
    Stetho.initializeWithDefaults(this);
  }

}
