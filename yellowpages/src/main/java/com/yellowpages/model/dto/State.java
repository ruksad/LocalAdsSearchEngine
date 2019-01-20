package com.yellowpages.model.dto;

import io.swagger.annotations.ApiModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Created by Ruksad siddiqui on 3/2/18
 */
@Setter
@Getter
@ApiModel("state")
@EqualsAndHashCode
public class State {
  private String name;
  private Set<City> cities;
  private Long stateId;
}
