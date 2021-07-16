package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RandomEvent {



  @PrimaryKey (autoGenerate = true)
  @ColumnInfo (name = "random_event_id")
  private long id;

  @ColumnInfo (name = "name")
  @NonNull
  private String name;

  @ColumnInfo (name = "ship", defaultValue = "false")
  @NonNull
  private boolean ship;

  @ColumnInfo (name = "planet_type", defaultValue = "false")
  @NonNull
  private boolean planetType;




  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isShip() {
    return ship;
  }

  public void setShip(boolean ship) {
    this.ship = ship;
  }

  public boolean isPlanetType() {
    return planetType;
  }

  public void setPlanetType(boolean planetType) {
    this.planetType = planetType;
  }
}
