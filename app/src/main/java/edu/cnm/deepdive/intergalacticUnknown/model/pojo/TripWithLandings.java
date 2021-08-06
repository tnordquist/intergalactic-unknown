package edu.cnm.deepdive.intergalacticUnknown.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.Relation;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Delta;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticUnknown.model.entity.Trip;
import java.util.List;

public class TripWithLandings extends Trip {

  @NonNull
  @Relation(
      entity = Landing.class,
      parentColumn = "trip_id",
      entityColumn = "trip_id"
  )
  private List<LandingWithDeltas> landings;

  @NonNull
  @Relation(
      entity = Delta.class,
      parentColumn = "trip_id",
      entityColumn = "trip_id"
  )
  private List<Delta> deltas;
  @NonNull
  public List<LandingWithDeltas> getLandings() {
    return landings;
  }

  public void setLandings(
      @NonNull List<LandingWithDeltas> landings) {
    this.landings = landings;
  }

  @NonNull
  public List<Delta> getDeltas() {
    return deltas;
  }

  public void setDeltas(@NonNull List<Delta> deltas) {
    this.deltas = deltas;
  }
}
