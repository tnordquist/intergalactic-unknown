package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RandomEvent {

  @PrimaryKey
  private long random_event_id;

  @ColumnInfo
  private String randomEventName;

  @ColumnInfo
  private boolean randomEventShip;

  @ColumnInfo
  private boolean randomEventPlanetType;

  public long getRandom_event_id() {
    return random_event_id;
  }

  public void setRandom_event_id(long random_event_id) {
    this.random_event_id = random_event_id;
  }

  public String getRandomEventName() {
    return randomEventName;
  }

  public void setRandomEventName(String randomEventName) {
    this.randomEventName = randomEventName;
  }

  public boolean isRandomEventShip() {
    return randomEventShip;
  }

  public void setRandomEventShip(boolean randomEventShip) {
    this.randomEventShip = randomEventShip;
  }

  public boolean isRandomEventPlanetType() {
    return randomEventPlanetType;
  }

  public void setRandomEventPlanetType(boolean randomEventPlanetType) {
    this.randomEventPlanetType = randomEventPlanetType;
  }
}
