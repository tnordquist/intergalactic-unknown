package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ship {

  @PrimaryKey
  private long shipID;

  @ColumnInfo
  private int shipHealth;

  @ColumnInfo
  private int shipFuel;

  @ColumnInfo
  @Nullable
  private int shipDamageBuffer;

  @ColumnInfo
  @Nullable
  private int[] randomEventProtection;

  @ColumnInfo
  private int planetDamage;

  @ColumnInfo
  private long gameId;

  @ColumnInfo
  private boolean randomEventShip;

  public long getShipID() {
    return shipID;
  }

  public void setShipID(long shipID) {
    this.shipID = shipID;
  }

  public int getShipHealth() {
    return shipHealth;
  }

  public void setShipHealth(int shipHealth) {
    this.shipHealth = shipHealth;
  }

  public int getShipFuel() {
    return shipFuel;
  }

  public void setShipFuel(int shipFuel) {
    this.shipFuel = shipFuel;
  }

  public int getShipDamageBuffer() {
    return shipDamageBuffer;
  }

  public void setShipDamageBuffer(int shipDamageBuffer) {
    this.shipDamageBuffer = shipDamageBuffer;
  }

  @Nullable
  public int[] getRandomEventProtection() {
    return randomEventProtection;
  }

  public void setRandomEventProtection(@Nullable int[] randomEventProtection) {
    this.randomEventProtection = randomEventProtection;
  }

  public int getPlanetDamage() {
    return planetDamage;
  }

  public void setPlanetDamage(int planetDamage) {
    this.planetDamage = planetDamage;
  }

  public long getGameId() {
    return gameId;
  }

  public void setGameId(long gameId) {
    this.gameId = gameId;
  }

  public boolean isRandomEventShip() {
    return randomEventShip;
  }

  public void setRandomEventShip(boolean randomEventShip) {
    this.randomEventShip = randomEventShip;
  }
}
