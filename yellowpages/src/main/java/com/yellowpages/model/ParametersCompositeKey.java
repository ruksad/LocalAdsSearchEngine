package com.yellowpages.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Ruksad siddiqui on 7/2/18
 */
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
public class ParametersCompositeKey implements Serializable {
  private long objectId;
  private long attributeId;

  public ParametersCompositeKey(long objectId, long attributeId) {
    this.objectId = objectId;
    this.attributeId = attributeId;
  }

  public long getObjectId() {
    return objectId;
  }

  public void setObjectId(long objectId) {
    this.objectId = objectId;
  }

  public long getAttributeId() {
    return attributeId;
  }

  public void setAttributeId(long attributeId) {
    this.attributeId = attributeId;
  }
}
