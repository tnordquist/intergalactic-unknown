package edu.cnm.deepdive.intergalacticUnknown.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.GameDao;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.PlanetDataDao;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.RandomEventDao;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.ShipDao;
import edu.cnm.deepdive.intergalacticUnknown.model.dao.UserDao;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Game;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.PlanetData;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.PlanetType;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.RandomEvent;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Ship;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.User;

@Database(
    entities = {Game.class, PlanetData.class, RandomEvent.class, Ship.class, User.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({PlanetType.class})
public abstract class IntergalacticUnknownDatabase extends RoomDatabase {

  private static final String DATABASE_NAME = "Intergalactic-Unknown-db";

  private static Application context;

  public static void setContext(Application context) {
    IntergalacticUnknownDatabase.context = context;
  }

  public static IntergalacticUnknownDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract GameDao getGameDao();

  public abstract PlanetDataDao getPlanetDataDao();


  public abstract RandomEventDao getRandomEventDao();

  public abstract ShipDao getShipDao();

  public abstract UserDao getUserDao();
  private static class InstanceHolder {

    private static final IntergalacticUnknownDatabase INSTANCE =
        Room.databaseBuilder(context, IntergalacticUnknownDatabase.class, DATABASE_NAME)
        .build();

  }

}
