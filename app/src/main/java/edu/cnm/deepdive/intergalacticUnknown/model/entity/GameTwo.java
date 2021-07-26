package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = ShipTwo.class,
            childColumns = {"ship_id"},
            parentColumns = {"ship_id"},
            onDelete = ForeignKey.CASCADE
        ),
         @ForeignKey(
            entity = SpaceStation.class,
            childColumns = {"space_station_id"},
            parentColumns = {"space_station_id"},
            onDelete = ForeignKey.CASCADE
        ),
         @ForeignKey(
            entity = UserTwo.class,
            childColumns = {"user_id"},
            parentColumns = {"user_id"},
            onDelete = ForeignKey.CASCADE
        ),

    },
    indices = {
        @Index(value = {"ship_id"}, unique = true),
        @Index(value = {"space_station_id"}, unique = true),
        @Index(value = {"user_id"}, unique = true),

    }
)
public class GameTwo {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long id;

  @ColumnInfo(name = "ship_id")
  @NonNull
  private long ship;

  @ColumnInfo(name = "first_planet")
  @NonNull
  private int firstPlanet;

  @ColumnInfo(name = "second_planet")
  @NonNull
  private int secondPlanet;

  @ColumnInfo(name = "third_planet")
  @NonNull
  private int thirdPlanet;

  @ColumnInfo(name = "space_station_id")
  @NonNull
  private long spaceStation;

  @ColumnInfo(name = "user_id")
  @NonNull
  private long user_id;

  @ColumnInfo(defaultValue = "0", name = "planets_visited")
  @NonNull
  private int planetsVisited;

  @ColumnInfo(defaultValue = "false", name = "planet_one_mine")
  @NonNull
  private boolean planetOneMine;

  @ColumnInfo(defaultValue = "false", name = "planet_two_mine")
  @NonNull
  private boolean planetTwoMine;

  @ColumnInfo(defaultValue = "false", name = "planet_three_mine")
  @NonNull
  private boolean planetThreeMine;

}
