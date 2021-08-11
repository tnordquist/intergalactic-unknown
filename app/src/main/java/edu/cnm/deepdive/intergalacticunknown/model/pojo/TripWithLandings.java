package edu.cnm.deepdive.intergalacticunknown.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.Relation;
import edu.cnm.deepdive.intergalacticunknown.model.entity.Delta;
import edu.cnm.deepdive.intergalacticunknown.model.entity.Landing;
import edu.cnm.deepdive.intergalacticunknown.model.entity.Trip;
import java.util.LinkedList;
import java.util.List;

public class TripWithLandings extends Trip {

  @NonNull
  @Relation(
      entity = Landing.class,
      parentColumn = "trip_id",
      entityColumn = "trip_id"
  )
  private List<LandingWithDeltas> landings = new LinkedList<>();

  @NonNull
  @Relation(
      entity = Delta.class,
      parentColumn = "trip_id",
      entityColumn = "trip_id"
  )
  private List<Delta> deltas = new LinkedList<>();
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
