package edu.cnm.deepdive.intergalacticUnknown;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.intergalacticUnknown.service.IntergalacticUnknownDatabase;
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
    Stetho.initializeWithDefaults(this);
  }

}
