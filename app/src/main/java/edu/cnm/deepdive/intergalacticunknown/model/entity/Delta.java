package edu.cnm.deepdive.intergalacticunknown.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.intergalacticunknown.model.types.ResourceType;

@SuppressWarnings("NotNullFieldNotInitialized")
@Entity(
    tableName = "delta",
    foreignKeys = {
        @ForeignKey(
            entity = Trip.class,
            parentColumns = "trip_id",
            childColumns = "trip_id",
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
            entity = Landing.class,
            parentColumns = "landing_id",
            childColumns = "landing_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Delta {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "delta_id")
  private long id;

  @ColumnInfo(name = "trip_id", index = true)
  private Long tripId;

  @ColumnInfo(name = "landing_id", index = true)
  private Long landingId;

  @NonNull
  @ColumnInfo(name = "resource_type", index = true)
  private ResourceType resourceType;
  private int amount;

  private boolean mining;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Long getTripId() {
    return tripId;
  }

  public void setTripId(Long tripId) {
    this.tripId = tripId;
  }

  public Long getLandingId() {
    return landingId;
  }

  public void setLandingId(Long landingId) {
    this.landingId = landingId;
  }

  @NonNull
  public ResourceType getResourceType() {
    return resourceType;
  }

  public void setResourceType(@NonNull ResourceType resourceType) {
    this.resourceType = resourceType;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public boolean isMining() {
    return mining;
  }

  public void setMining(boolean mining) {
    this.mining = mining;
  }
}
