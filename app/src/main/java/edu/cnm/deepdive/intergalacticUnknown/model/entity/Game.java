package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class Game {

  @ColumnInfo
  private String userName;

  @ColumnInfo
  private long planetID;

  @ColumnInfo
  private boolean shipStatus;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public long getPlanetID() {
    return planetID;
  }

  public void setPlanetID(long planetID) {
    this.planetID = planetID;
  }

  public boolean isShipStatus() {
    return shipStatus;
  }

  public void setShipStatus(boolean shipStatus) {
    this.shipStatus = shipStatus;
  }
}
