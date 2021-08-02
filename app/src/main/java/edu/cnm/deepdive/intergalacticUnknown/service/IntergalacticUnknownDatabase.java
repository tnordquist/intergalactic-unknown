package edu.cnm.deepdive.intergalacticUnknown.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.UserDao;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Delta;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Trip;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.User;
import edu.cnm.deepdive.intergalacticUnknown.model.types.PlanetType;
import edu.cnm.deepdive.intergalacticUnknown.model.types.ResourceType;
import edu.cnm.deepdive.intergalacticUnknown.service.IntergalacticUnknownDatabase.Converters;
import java.util.Date;

@Database(
    entities = {Trip.class, Landing.class, Delta.class, User.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class, ResourceType.class, PlanetType.class})
public abstract class IntergalacticUnknownDatabase extends RoomDatabase {

  private static final String DATABASE_NAME = "Intergalactic-Unknown-db";

  private static Application context;

  public static void setContext(Application context) {
    IntergalacticUnknownDatabase.context = context;
  }

  public static IntergalacticUnknownDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }



  public abstract UserDao getUserDao();
  private static class InstanceHolder {

    private static final IntergalacticUnknownDatabase INSTANCE =
        Room.databaseBuilder(context, IntergalacticUnknownDatabase.class, DATABASE_NAME)
        .build();

  }

  public static class Converters{
    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }
}
