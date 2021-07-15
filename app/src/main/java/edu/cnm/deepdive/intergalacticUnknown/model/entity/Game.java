package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
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
            childColumns = {"ship_status"},
            parentColumns = {"ship_id"}
        )
    }
)
public class Game {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_id")
  private long id;

  private String pool;

  @ColumnInfo(name = "user_name")
  private long userId;

  @ColumnInfo(name = "ship_status", defaultValue = "false")
  private boolean shipStatus;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPool() {
    return pool;
  }

  public void setPool(String pool) {
    this.pool = pool;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public boolean isShipStatus() {
    return shipStatus;
  }

  public void setShipStatus(boolean shipStatus) {
    this.shipStatus = shipStatus;
  }
}
