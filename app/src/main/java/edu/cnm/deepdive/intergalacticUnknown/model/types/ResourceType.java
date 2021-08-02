package edu.cnm.deepdive.intergalacticUnknown.model.types;

import androidx.room.TypeConverter;

public enum ResourceType {

  HEALTH, WATER, HEAT, CEMENT;

  @TypeConverter
  public static Integer toInteger(ResourceType value){

    return (value != null) ? value.ordinal() : null;

  }

  @TypeConverter
  public static ResourceType from(Integer value){

    return (value != null) ? values()[value] : null;
  }

}
