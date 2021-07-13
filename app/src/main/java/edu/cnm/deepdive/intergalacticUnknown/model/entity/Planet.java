package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Planet {

  @PrimaryKey
  private long planetId;

  @ColumnInfo
  private long gameId;

  @ColumnInfo
  private int planetDamage;

  @ColumnInfo
  private String planetName;

  public long getPlanetId() {
    return planetId;
  }

  public void setPlanetId(long planetId) {
    this.planetId = planetId;
  }

  public long getGameId() {
    return gameId;
  }

  public void setGameId(long gameId) {
    this.gameId = gameId;
  }

  public int getPlanetDamage() {
    return planetDamage;
  }

  public void setPlanetDamage(int planetDamage) {
    this.planetDamage = planetDamage;
  }

  public String getPlanetName() {
    return planetName;
  }

  public void setPlanetName(String planetName) {
    this.planetName = planetName;
  }
}
