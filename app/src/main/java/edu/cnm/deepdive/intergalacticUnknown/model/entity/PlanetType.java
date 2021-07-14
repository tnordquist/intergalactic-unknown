package edu.cnm.deepdive.intergalacticUnknown.model.entity;


import androidx.room.TypeConverter;

public enum PlanetType {

  LUSH(2, true),
  RADIATION(-2, true),
  SCORCHED(-1, false),
  FROZEN(-1, false),
  VOLCANIC(-1, false),
  MARSH(1, false);

  private final int baseDamage;
  private final boolean randomEventOccurs;

  PlanetType(int baseDamage, boolean randomEventOccurs) {
    this.baseDamage = baseDamage;
    this.randomEventOccurs = randomEventOccurs;
  }

  public int getBaseDamage() {
    return baseDamage;
  }

  public boolean isRandomEventOccurs() {
    return randomEventOccurs;
  }

  @TypeConverter
  public static Integer planetTypeToInteger(PlanetType value) {
    return (value != null) ? value.ordinal() : null;
  }
  @TypeConverter
  public static PlanetType integerToPlanetType(Integer value) {
    return (value != null) ? PlanetType.values()[value] : null;
  }
}
