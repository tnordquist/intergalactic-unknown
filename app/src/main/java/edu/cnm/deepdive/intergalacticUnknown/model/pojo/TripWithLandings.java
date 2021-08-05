package edu.cnm.deepdive.intergalacticUnknown.model.pojo;

import androidx.annotation.NonNull;
import androidx.room.Relation;
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
  private List<Landing> landings;

  @NonNull
  public List<Landing> getLandings() {
    return landings;
  }

  public void setLandings(
      @NonNull List<Landing> landings) {
    this.landings = landings;
  }
}
