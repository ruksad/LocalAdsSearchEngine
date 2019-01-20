package com.yellowpages.service;

import com.yellowpages.model.ObjectEntity;
import com.yellowpages.model.dto.*;

import java.util.List;
import java.util.Set;

/**
 * Created by Ruksad siddiqui on 31/1/18
 */
public interface FederatedService {
  Set<String> findObjectNamesByObjectTypeName(String objectTypeName);
  Set<ObjectEntity> findObjectNameByParameterValue(String parameterValue);
  StatesAndCities getPreRequisitePrepared();
  List<FlattenedObjectEntityDto> getCriteriaMatchingObjects(FindObjectsByCriterion appPrerequisiteResponseDto);
  List<FlattenedObjectEntityDto> getAllFeaturedCardsById(long id);
  PostAdDto getPostAdDto(Long parentId,Long objectLevel3Id,String objectTypeName,Long objectLevel4Id);
  PostAdDto getUserRegistrationTemplate();
}
