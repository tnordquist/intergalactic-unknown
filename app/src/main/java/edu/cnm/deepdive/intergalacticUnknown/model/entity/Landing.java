package edu.cnm.deepdive.intergalacticUnknown.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.intergalacticUnknown.model.types.PlanetType;

@SuppressWarnings("NotNullFieldNotInitialized")
@Entity(
    tableName = "landing",
    indices = {
        @Index(value = {"trip_id", "landing_order"}, unique = true)
    },
    foreignKeys = {
        @ForeignKey(
            entity = Trip.class,
            parentColumns = "trip_id",
            childColumns = "trip_id",
            onDelete = ForeignKey.CASCADE
        )
    }

)
public class Landing {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "landing_id")
  private long id;

  @ColumnInfo(name = "landing_order")
  private int order;

  @NonNull
  @ColumnInfo(name = "planet_type", index = true)
  private PlanetType planetType;

  @NonNull
  @ColumnInfo(name = "planet_name")
  private String planetName;

  @ColumnInfo(name = "trip_id", index = true)
  private long tripId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  @NonNull
  public PlanetType getPlanetType() {
    return planetType;
  }

  public void setPlanetType(@NonNull PlanetType planetType) {
    this.planetType = planetType;
  }

  @NonNull
  public String getPlanetName() {
    return planetName;
  }

  public void setPlanetName(@NonNull String planetName) {
    this.planetName = planetName;
  }

  public long getTripId() {
    return tripId;
  }

  public void setTripId(long tripId) {
    this.tripId = tripId;
  }
}
