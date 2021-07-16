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
            entity = User.class,
            childColumns = {"user_id"},
            parentColumns = {"user_id"},
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
            entity = Ship.class,
            childColumns = {"ship_id"},
            parentColumns = {"ship_id"}
        )
    },
    indices = {
    @Index(value = {"user_id"}, unique = true),
    @Index(value = {"ship_id"}, unique = true)    //check these
    }



)
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long id;

  @ColumnInfo(name = "user_id")
  @NonNull
  private long userId;

  @ColumnInfo(name = "ship_id")
  @NonNull
  private long shipId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public long getShipId() {
    return shipId;
  }

  public void setShipId(long shipId) {
    this.shipId = shipId;
  }
}

