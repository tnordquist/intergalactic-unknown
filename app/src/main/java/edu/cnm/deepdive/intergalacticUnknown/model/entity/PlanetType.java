package edu.cnm.deepdive.intergalacticUnknown.model.entity;


import androidx.room.TypeConverter;

public enum PlanetType {

  LUSH(2, 1),
  RADIATION(-2, 1),
  SCORCHED(-1, 3),
  FROZEN(-1, 2),
  VOLCANIC(-1, 5),
  MARSH(1, 4);

  private final int baseDamage;
 // private final boolean randomEventOccurs;

  private String Name;

  private int resourceAvailable;

  PlanetType(int baseDamage, int resource) {
    this.baseDamage = baseDamage;
    this.resourceAvailable = resource;
  }

  public int getBaseDamage() {
    return baseDamage;
  }

 // public boolean isRandomEventOccurs() {
 //   return randomEventOccurs;
 // }

  @TypeConverter
  public static Integer planetTypeToInteger(PlanetType value) {
    return (value != null) ? value.ordinal() : null;
  }
  @TypeConverter
  public static PlanetType integerToPlanetType(Integer value) {
    return (value != null) ? PlanetType.values()[value] : null;
  }
}
