package edu.cnm.deepdive.intergalacticUnknown;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.intergalacticUnknown.service.IntergalacticUnknownDatabase;
import io.reactivex.schedulers.Schedulers;

/**
 * Initializes (in the {@link #onCreate()} method) application-level resources. This class
 * <strong>must</strong> be referenced in {@code AndroidManifest.xml}, or it will not be loaded and
 * used by the Android system.
 */
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
