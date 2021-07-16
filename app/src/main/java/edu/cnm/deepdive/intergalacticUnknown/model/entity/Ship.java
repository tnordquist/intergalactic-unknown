package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.EnumMap;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = RandomEvent.class,
            childColumns = {"random_event_ship"},
            parentColumns = {"random_event_id"},
            onDelete = ForeignKey.CASCADE
        ),
    },
    indices = {
    @Index(value = {"random_event_ship"}, unique = true)
}
)
public class Ship {

  @PrimaryKey (autoGenerate = true)
  @ColumnInfo (name = "ship_id")
  private long id;

  @ColumnInfo (name = "ship_status", defaultValue = "false")
  @NonNull
  private boolean shipStatus;

  @ColumnInfo (name = "ship_health")
  @NonNull
  private int health;

  @ColumnInfo (name = "ship_fuel")
  @NonNull
  private int fuel;

  @ColumnInfo (name = "ship_damage_buffer", defaultValue = "false")
  @NonNull
  private boolean shipDamageBuffer;

  @ColumnInfo (name = "random_event_protection", defaultValue = "false")
  @NonNull
  private boolean randomEventProtection;

  private EnumMap <PlanetType, Integer> planetDamage;

  @ColumnInfo (name = "random_event_ship")
  @NonNull //here
  private boolean randomEventShip;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public boolean isShipStatus() {
    return shipStatus;
  }

  public void setShipStatus(boolean shipStatus) {
    this.shipStatus = shipStatus;
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

  public boolean isShipDamageBuffer() {
    return shipDamageBuffer;
  }

  public void setShipDamageBuffer(boolean shipDamageBuffer) {
    this.shipDamageBuffer = shipDamageBuffer;
  }

  public boolean isRandomEventProtection() {
    return randomEventProtection;
  }

  public void setRandomEventProtection(boolean randomEventProtection) {
    this.randomEventProtection = randomEventProtection;
  }

  public EnumMap<PlanetType, Integer> getPlanetDamage() {
    return planetDamage;
  }

  public void setPlanetDamage(
      EnumMap<PlanetType, Integer> planetDamage) {
    this.planetDamage = planetDamage;
  }

  public boolean isRandomEventShip() {
    return randomEventShip;
  }

  public void setRandomEventShip(boolean randomEventShip) {
    this.randomEventShip = randomEventShip;
  }
}
