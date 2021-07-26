package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    indices = {
        @Index(value = {"space_station_id"}, unique = true)
    }
)
public class SpaceStation {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "space_station_id")
  @NonNull
  private long id;

  @ColumnInfo(defaultValue = "false", name = "choose_one_resource")
  @NonNull
  private boolean chooseOneResource;

  @ColumnInfo(defaultValue = "false", name = "lose_one_resource")
  @NonNull
  private boolean loseOneResource;

  @ColumnInfo(name = "first_planet")
  @NonNull
  private int firstPlanet;

  @ColumnInfo(name = "free_resource")
  @NonNull
  private int freeResource;

  @ColumnInfo(name = "change_planet_and_resource", defaultValue = "false")
  @NonNull
  private boolean changePlanetAndResource;

}
