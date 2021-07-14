package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ship {

  @PrimaryKey (autoGenerate = true)
  @ColumnInfo (name = "ship_id")
  private long id;

  @ColumnInfo (name = "ship_health")
  private int health;

  @ColumnInfo (name = "ship_fuel")
  private int fuel;

  @ColumnInfo (name = "ship_damage_buffer")
  @Nullable
  private int damageBuffer;

  @ColumnInfo (name = "random_event_protection")
  @Nullable
  private int[] eventProtection;

  @ColumnInfo (name = "planet_damage")
  private int planetDamage;

  @ColumnInfo (name = "game_id")
  private long gameId;

  @ColumnInfo (name = "random_event_ship")
  private boolean randomEventShip;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getFuel() {
    return fuel;
  }

  public void setFuel(int fuel) {
    this.fuel = fuel;
  }

  public int getDamageBuffer() {
    return damageBuffer;
  }

  public void setDamageBuffer(int damageBuffer) {
    this.damageBuffer = damageBuffer;
  }

  @Nullable
  public int[] getEventProtection() {
    return eventProtection;
  }

  public void setEventProtection(@Nullable int[] eventProtection) {
    this.eventProtection = eventProtection;
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
