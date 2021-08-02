package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.intergalacticUnknown.model.types.PlanetType;
import edu.cnm.deepdive.intergalacticUnknown.model.types.ResourceType;
import java.util.Date;

@SuppressWarnings("NotNullFieldNotInitialized")
@Entity(
    tableName = "trip"
)
public class Trip {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "trip_id")
  private long id;

  @NonNull
  @ColumnInfo(index = true)
  private Date started = new Date();

  @NonNull
  @ColumnInfo(name = "preferred_destination", index = true)
  private PlanetType preferredDestination;

  @NonNull
  @ColumnInfo(name = "augmented_resource", index = true)
  private ResourceType augmentedResource;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Date getStarted() {
    return started;
  }

  public void setStarted(@NonNull Date started) {
    this.started = started;
  }

  @NonNull
  public PlanetType getPreferredDestination() {
    return preferredDestination;
  }

  public void setPreferredDestination(
      @NonNull PlanetType preferredDestination) {
    this.preferredDestination = preferredDestination;
  }

  @NonNull
  public ResourceType getAugmentedResource() {
    return augmentedResource;
  }

  public void setAugmentedResource(
      @NonNull ResourceType augmentedResource) {
    this.augmentedResource = augmentedResource;
  }
}
