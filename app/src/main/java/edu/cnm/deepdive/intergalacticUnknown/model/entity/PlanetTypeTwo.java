package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import java.security.PublicKey;

public enum PlanetTypeTwo {

  SCORCHED(1, 2, "Scorched"), //I want to make the names randomized from the nasa api I found
  FROZEN(3, 1, "Frozen"),
  VOLCANIC(2, 3, "Volcanic");

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "planet_type_id")

  private long id;

  private final int resourceProvided;

  private final int resourceDependent;

  private final String name;

  PlanetTypeTwo(int resourceProvided, int resourceDependent, String name) {
    this.resourceProvided = resourceProvided;
    this.resourceDependent = resourceDependent;
    this.name = name;
  }

  @TypeConverter
  public static Integer planetTypeToInteger(PlanetTypeTwo value) {
    return (value != null) ? value.ordinal() : null;
  }
  @TypeConverter
  public static PlanetType integerToPlanetType(Integer value) {
    return (value != null) ? PlanetType.values()[value] : null;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getResourceProvided() {
    return resourceProvided;
  }

  public int getResourceDependent() {
    return resourceDependent;
  }

  public String getName() {
    return name;
  }
}
