package edu.cnm.deepdive.intergalacticUnknown.model.types;

import androidx.room.TypeConverter;

public enum PlanetType {

  FROZEN(ResourceType.HEAT, ResourceType.WATER),
  SCORCHED(ResourceType.WATER, ResourceType.CEMENT),
  VOLCANIC(ResourceType.CEMENT, ResourceType.HEAT);

  private final ResourceType consumes;

  private final ResourceType produces;

  PlanetType(ResourceType consumes,
      ResourceType produces) {
    this.consumes = consumes;
    this.produces = produces;
  }

  public ResourceType getConsumes() {
    return consumes;
  }

  public ResourceType getProduces() {
    return produces;
  }

  @TypeConverter
  public static Integer toInteger(PlanetType value){

    return (value != null) ? value.ordinal() : null;
  }

  @TypeConverter
  public static PlanetType from(Integer value){

    return (value != null) ? values()[value] : null;
  }

}
