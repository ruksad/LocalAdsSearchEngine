package com.yellowpages.service;

import com.yellowpages.model.ObjectTypeEntity;
import com.yellowpages.model.dto.ObjectTypeDTO;
import com.yellowpages.model.dto.ObjectTypeHierarchyMapping;
import com.yellowpages.model.dto.PostAdDto;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 28/1/18
 */
public interface ObjectTypeService {
  ObjectTypeEntity findById(Long id);
  ObjectTypeEntity findByName(String objectTypeName);
  List<ObjectTypeEntity> findByParentId(long id);
  List<ObjectTypeHierarchyMapping> getObjectTypeHierarchyForLevel2(long category, long subCategory);
  List<ObjectTypeHierarchyMapping> getObjectTypeHierarchyForLevel3(long category,long subCategory);
  List<ObjectTypeDTO> collectCategories();
  List<ObjectTypeDTO> findByParentId(List<Long> ids);
}
