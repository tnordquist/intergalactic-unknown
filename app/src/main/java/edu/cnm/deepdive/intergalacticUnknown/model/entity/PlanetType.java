package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class PlanetType {

  @PrimaryKey
  private long planetTypeId;

  @ColumnInfo
  private int planetType;

  @ColumnInfo
  private int baseDamage;

  @ColumnInfo
  private boolean randomEventPlanetType;

  @ColumnInfo
  private int resourceAvailable;

  public long getPlanetTypeId() {
    return planetTypeId;
  }

  public void setPlanetTypeId(long planetTypeId) {
    this.planetTypeId = planetTypeId;
  }

  public int getPlanetType() {
    return planetType;
  }

  public void setPlanetType(int planetType) {
    this.planetType = planetType;
  }

  public int getBaseDamage() {
    return baseDamage;
  }

  public void setBaseDamage(int baseDamage) {
    this.baseDamage = baseDamage;
  }

  public boolean isRandomEventPlanetType() {
    return randomEventPlanetType;
  }

  public void setRandomEventPlanetType(boolean randomEventPlanetType) {
    this.randomEventPlanetType = randomEventPlanetType;
  }

  public int getResourceAvailable() {
    return resourceAvailable;
  }

  public void setResourceAvailable(int resourceAvailable) {
    this.resourceAvailable = resourceAvailable;
  }
}
