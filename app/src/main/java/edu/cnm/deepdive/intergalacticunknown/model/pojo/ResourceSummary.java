package edu.cnm.deepdive.intergalacticunknown.model.pojo;

import androidx.room.ColumnInfo;
import edu.cnm.deepdive.intergalacticunknown.model.types.ResourceType;

public class ResourceSummary {

  @ColumnInfo(name = "resource_type")
  private ResourceType resourceType;

  private int amount;

  public ResourceType getResourceType() {
    return resourceType;
  }

  public void setResourceType(ResourceType resourceType) {
    this.resourceType = resourceType;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
