package com.yellowpages.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 5/2/18
 */
@Getter
@Setter
public class City {

  private String cityName;
  private String isPopular;
  private Long cityId;
  private List<Locality> localityList;
}
