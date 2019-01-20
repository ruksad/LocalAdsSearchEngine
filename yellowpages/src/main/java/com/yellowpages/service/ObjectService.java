package com.yellowpages.service;

import com.yellowpages.model.ObjectEntity;
import com.yellowpages.model.dto.FlattenedObjectEntityDto;
import com.yellowpages.model.dto.ObjectEntityDto;
import com.yellowpages.model.dto.PostAdDto;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 30/1/18
 */
public interface ObjectService {
  List<ObjectEntity> findById(long id);
  List<ObjectEntity> findByParameterValue(String parameterValue);
  List<ObjectEntity> getByObjectTypeName(String objectTypeName);
  List<ObjectEntity> findByParameterAndAttribute(String parameter,String attribute);
  List<ObjectEntity> findByObjectIdAndParentId(long id,long parentId);
  List<ObjectEntity> getByIdAndParentId(List<Long> objectNames,long parentId);
  List<ObjectEntity> getNameAndDescriptionByObjectTypeIdAndParentId(List<Long> objectNames, long parentId);
  FlattenedObjectEntityDto findObjectByObjectIdAndParentId(long objectId,long parentId);
  List<FlattenedObjectEntityDto> finObjectsByObjectIdAndAttributeIds(Long parentId);
  ObjectEntity postAnAd(PostAdDto postAdDto) throws Exception;
  ObjectEntity registerNewUser(PostAdDto postAdDto);

List<FlattenedObjectEntityDto> verifyUser(String mobileNumberOrEmail);}
