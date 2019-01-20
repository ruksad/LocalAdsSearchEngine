package com.yellowpages.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ruksad siddiqui on 5/2/18
 */
@Getter
@Setter
public class FindObjectsByCriterion {
  private Long stateId;
  private Long selectedCityId;
  private Long categoryId;
  private Long localityId;
}
