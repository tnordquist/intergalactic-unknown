package edu.cnm.deepdive.intergalacticunknown.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.intergalacticunknown.model.entity.Delta;
import edu.cnm.deepdive.intergalacticunknown.model.entity.Landing;
import java.util.List;

public class LandingWithDeltas extends Landing {

  @Relation(
      entity = Delta.class,
      entityColumn = "landing_id",
      parentColumn = "landing_id"
  )
  private List<Delta> deltas;

  public List<Delta> getDeltas() {
    return deltas;
  }

  public void setDeltas(List<Delta> deltas) {
    this.deltas = deltas;
  }
}
