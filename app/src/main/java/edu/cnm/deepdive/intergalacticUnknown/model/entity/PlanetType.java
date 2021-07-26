package edu.cnm.deepdive.intergalacticUnknown.model.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.EnumMap;
public enum PlanetType {
// baseDamage, resource
  LUSH(2, 2),
  RADIATION(-2, 1),
  SCORCHED(-1, 4),
  FROZEN(-1, 3),


  VOLCANIC(-1, 5),
  MARSH(1, 4);

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "planet_type_id")
  private long id;
  private static final Gson gson = new Gson();
  private final int baseDamage;

  private final int resourceAvailable;

  PlanetType(int baseDamage, int resource) {
    this.baseDamage = baseDamage;
    this.resourceAvailable = resource;
  }

  public int getBaseDamage() {
    return baseDamage;
  }

  public int getResourceAvailable() {
    return resourceAvailable;
  }

  @TypeConverter
  public static Integer planetTypeToInteger(PlanetType value) {
    return (value != null) ? value.ordinal() : null;
  }
  @TypeConverter
  public static PlanetType integerToPlanetType(Integer value) {
    return (value != null) ? PlanetType.values()[value] : null;
  }

  @TypeConverter
  public static String planetTypeIntegerMapToString(EnumMap<PlanetType, Integer> value) {
    return (value != null)
        ? gson.toJson(value)
        : null;
  }

  @TypeConverter
  public static EnumMap<PlanetType, Integer> stringToPlanetTypeIntegerMap(String value) {
    EnumMap<PlanetType, Integer> result;
    if (value != null) {
      Type exampleMap = new TypeToken<EnumMap<PlanetType, Integer>>() {}.getType();
      result = gson.fromJson(value, exampleMap);
    } else {
      result = null;
    }
    return result;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public static Gson getGson() {
    return gson;
  }

  // public boolean isRandomEventOccurs() {
  //   return randomEventOccurs;
  // }
}
