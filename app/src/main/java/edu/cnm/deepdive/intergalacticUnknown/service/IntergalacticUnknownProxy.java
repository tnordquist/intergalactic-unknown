package edu.cnm.deepdive.intergalacticUnknown.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.intergalacticUnknown.BuildConfig;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.User;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface IntergalacticUnknownProxy {

  static IntergalacticUnknownProxy getInstance() {
    return InstanceHolder.INSTANCE;
  }

  @GET()
  Single<User> getProfile(@Header("Authorization") String bearerToken);

  class InstanceHolder {

    private static final Gson GSON;
    private static final IntergalacticUnknownProxy INSTANCE;

    static {

      GSON = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
          .create();
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(BuildConfig.DEBUG ? Level.BODY : Level.NONE);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl("https://ddc-java.services/codebreaker/")
          .addConverterFactory(GsonConverterFactory.create(GSON))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(client)
          .build();
      INSTANCE = retrofit.create(IntergalacticUnknownProxy.class);
    }

  }

}
