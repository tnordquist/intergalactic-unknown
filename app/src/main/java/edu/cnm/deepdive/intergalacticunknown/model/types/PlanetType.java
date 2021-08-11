package edu.cnm.deepdive.intergalacticunknown.model.types;

import androidx.annotation.NonNull;
import androidx.room.TypeConverter;

public enum PlanetType {

  FROZEN(ResourceType.HEAT, ResourceType.WATER, 1),
  SCORCHED(ResourceType.WATER, ResourceType.CEMENT, 1),
  VOLCANIC(ResourceType.CEMENT, ResourceType.HEAT, 1);

  private final ResourceType consumes;
  private final ResourceType produces;
  private final int amountConsumed;

  PlanetType(ResourceType consumes,
      ResourceType produces, int amountConsumed) {
    this.consumes = consumes;
    this.produces = produces;
    this.amountConsumed = amountConsumed;
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

  @NonNull
  @Override
  public String toString() {
    return super.toString().toLowerCase();
  }
}
