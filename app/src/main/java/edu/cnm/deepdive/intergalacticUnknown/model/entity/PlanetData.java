package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity()
public class PlanetData {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "planet_data_id")
  private long id;

  @ColumnInfo (name = "visited", defaultValue = "0")
  @NonNull
  private int visitedCount;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getVisitedCount() {
    return visitedCount;
  }

  public void setVisitedCount(int visitedCount) {
    this.visitedCount = visitedCount;
  }
}

