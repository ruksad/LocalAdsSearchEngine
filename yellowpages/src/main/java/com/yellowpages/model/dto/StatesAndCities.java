package com.yellowpages.model.dto;

import io.swagger.annotations.ApiModel;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ruksad siddiqui on 3/2/18
 */
@ApiModel("appPrerequisiteRequestDto")
@Getter
@Setter
public class StatesAndCities {
  Set<String> popularCities;
  Set<State> states;
}
