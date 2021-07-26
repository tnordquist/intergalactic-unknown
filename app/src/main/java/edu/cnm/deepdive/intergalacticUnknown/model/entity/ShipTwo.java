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
            entity = SpaceStation.class,
            childColumns = {"space_station_id"},
            parentColumns = {"space_station_id"},
            onDelete = ForeignKey.CASCADE
        ),
    },
    indices = {
        @Index(value = {"ship_id"}, unique = true),
        @Index(value = {"space_station_id"}, unique = true)
    }
)
public class ShipTwo {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "ship_id")
  @NonNull
  private long id;

  @ColumnInfo(defaultValue = "9", name = "health")
  @NonNull
  private int health;

  @ColumnInfo(defaultValue = "1", name = "resource_one")
  @NonNull
  private int resourceOne;

  @ColumnInfo(defaultValue = "1", name = "resource_two")
  @NonNull
  private int resourceTwo;

  @ColumnInfo(defaultValue = "1", name = "resource_three")
  @NonNull
  private int resourceThree;

  @ColumnInfo(name = "space_station_id")
  @NonNull
  private long spaceStationId;

}
