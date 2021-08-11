package edu.cnm.deepdive.intergalacticunknown.model.types;

import androidx.annotation.NonNull;
import androidx.room.TypeConverter;

public enum ResourceType {

  HEALTH(10),
  WATER(3),
  HEAT(3),
  CEMENT(3);

  private final int initialLevel;

  ResourceType(int initialLevel) {
    this.initialLevel = initialLevel;
  }

  public int getInitialLevel() {
    return initialLevel;
  }

  @TypeConverter
  public static Integer toInteger(ResourceType value){

    return (value != null) ? value.ordinal() : null;

  }

  @TypeConverter
  public static ResourceType from(Integer value){

    return (value != null) ? values()[value] : null;
  }

  @NonNull
  @Override
  public String toString() {
    return super.toString().toLowerCase();
  }
}
