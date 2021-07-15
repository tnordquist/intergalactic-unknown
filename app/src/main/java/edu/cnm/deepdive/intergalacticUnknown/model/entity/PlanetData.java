package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity()
public class PlanetData {

  @ColumnInfo (name = "visited", defaultValue = "0")
  private int visitedCount;

  public int getVisitedCount() {
    return visitedCount;
  }

  public void setVisitedCount(int visitedCount) {
    this.visitedCount = visitedCount;
  }
}

