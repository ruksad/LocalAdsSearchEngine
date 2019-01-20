package com.yellowpages.service.implementations;

import com.yellowpages.exception.YellowPagesApiException;
import com.yellowpages.log.annotation.Trace;
import com.yellowpages.log.eventtype.LogEventType;
import com.yellowpages.model.ObjectTypeEntity;
import com.yellowpages.model.dto.ObjectTypeDTO;
import com.yellowpages.model.dto.ObjectTypeHierarchyMapping;
import com.yellowpages.model.dto.PostAdDto;
import com.yellowpages.repository.ObjectTypeEntityRepository;
import com.yellowpages.service.ObjectTypeService;
import com.yellowpages.utils.AppConstants;
import javassist.bytecode.SignatureAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Ruksad siddiqui on 28/1/18
 */
@Service
public class ObjectTypeServiceImpl implements ObjectTypeService {

  private final ObjectTypeEntityRepository objectTypeEntityRepository;

  @Autowired
  public ObjectTypeServiceImpl(ObjectTypeEntityRepository objectTypeEntityRepository){
    this.objectTypeEntityRepository=objectTypeEntityRepository;
  }

  @Override
  @Trace(type = LogEventType.SERVICE)
  public ObjectTypeEntity findById(Long id) {
    if(Objects.nonNull(id)){
      Optional<ObjectTypeEntity> objectTypeEntity=objectTypeEntityRepository.findOneByObjectTypeId(id);
      if(objectTypeEntity.isPresent()){
        return objectTypeEntity.get();
      }
      throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"object type is not present for the given Id: "+String.valueOf(id));
    }
    return null;
  }

  @Override
  @Trace(type = LogEventType.SERVICE)
  public ObjectTypeEntity findByName(String objectTypeName) {
    if(Objects.nonNull(objectTypeName)){
      Optional<Object> objectTypeEntity=objectTypeEntityRepository.findOneByName(objectTypeName);
      if(objectTypeEntity.isPresent()){
        return (ObjectTypeEntity)objectTypeEntity.get();
      }
      throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"object type is not present for the name: "+objectTypeName);
    }
    return null;
  }

  @Override
  @Trace(type = LogEventType.SERVICE)
  public List<ObjectTypeEntity> findByParentId(long id){
    if(Objects.nonNull(id)){
      List<ObjectTypeEntity> objectTypeEntities=objectTypeEntityRepository.findAllByParentId(id);
      if(!objectTypeEntities.isEmpty()){
        return objectTypeEntities;
      }
      throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"object type is not present for the Id: "+String.valueOf(id));
    }
    return null;
  }


  @Override
  @Trace(type = LogEventType.SERVICE)
  public List<ObjectTypeHierarchyMapping> getObjectTypeHierarchyForLevel2(long category,long subCategory){
    if(Objects.nonNull(category) && Objects.nonNull(subCategory)) {
      List<ObjectTypeHierarchyMapping> objectTypeHierarchyMappings = new ArrayList<>(10);
      List<Object[]> objectTypesHierarchy = this.objectTypeEntityRepository.getHierarchyForLevel2(category, subCategory);
      if(!objectTypesHierarchy.isEmpty()) {
        objectTypesHierarchy.stream().forEach((record) -> {
          ObjectTypeHierarchyMapping hierarchyMapping = new ObjectTypeHierarchyMapping();
          hierarchyMapping.setObjectTypeNameOne(String.valueOf(record[0]));
          hierarchyMapping.setObjectTypeNameOneId(Objects.nonNull(record[1])?((Integer) record[1]).longValue():null);
          hierarchyMapping.setObjectTypeNameTwo(String.valueOf(record[2]));
          hierarchyMapping.setObjectTypeNameTwoId(Objects.nonNull(record[3])?((Integer) record[3]).longValue():null);
          hierarchyMapping.setObjectTypeNameThree(String.valueOf(record[4]));
          hierarchyMapping.setObjectTypeNameThreeId(Objects.nonNull(record[5])?((Integer) record[5]).longValue():null);
          hierarchyMapping.setObjectTypeNameFour(String.valueOf(record[6]));
          hierarchyMapping.setObjectTypeNameFourId(Objects.nonNull(record[7])?((Integer) record[7]).longValue():null);
          objectTypeHierarchyMappings.add(hierarchyMapping);
        });
        return objectTypeHierarchyMappings;
      }
      throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"Object type hierarchy for category: "+category +" and for sub category: "+ subCategory +"is not present");
    }
    return null;
  }

  @Override
  @Trace(type = LogEventType.SERVICE)
  public List<ObjectTypeHierarchyMapping> getObjectTypeHierarchyForLevel3(long category,long subCategory){
    if(Objects.nonNull(category) && Objects.nonNull(subCategory)) {
      List<ObjectTypeHierarchyMapping> objectTypeHierarchyMappings = new ArrayList<>(10);
      List<Object[]> objectTypesHierarchy = this.objectTypeEntityRepository.getHierarchyForLevel3(category, subCategory);
      if(!objectTypesHierarchy.isEmpty()) {
        objectTypesHierarchy.stream().forEach((record) -> {
          ObjectTypeHierarchyMapping hierarchyMapping = new ObjectTypeHierarchyMapping();
          hierarchyMapping.setObjectTypeNameOne(String.valueOf(record[0]));
          hierarchyMapping.setObjectTypeNameOneId(Objects.nonNull(record[1])?((Integer) record[1]).longValue():null);
          hierarchyMapping.setObjectTypeNameTwo(String.valueOf(record[2]));
          hierarchyMapping.setObjectTypeNameTwoId(Objects.nonNull(record[3])?((Integer) record[3]).longValue():null);
          hierarchyMapping.setObjectTypeNameThree(String.valueOf(record[4]));
          hierarchyMapping.setObjectTypeNameThreeId(Objects.nonNull(record[5])?((Integer) record[5]).longValue():null);
          hierarchyMapping.setObjectTypeNameFour(String.valueOf(record[6]));
          hierarchyMapping.setObjectTypeNameFourId(Objects.nonNull(record[7])?((Integer) record[7]).longValue():null);
          objectTypeHierarchyMappings.add(hierarchyMapping);
        });
        return objectTypeHierarchyMappings;
      }
      throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"Object type hierarchy for category: "+category +" and for sub category: "+ subCategory +" is not present");
    }
    return null;
  }

  @Override
  @Trace(type = LogEventType.SERVICE)
  public List<ObjectTypeDTO> collectCategories() {
    ObjectTypeEntity objectTypeEntity = findByName(AppConstants.CATEGORIES);
    List<ObjectTypeDTO> objectTypeDTOList=new ArrayList<>(10);
    List<ObjectTypeEntity> objectTypeEntities = getObjectTypeEntitiesByParentEntity(objectTypeEntity);
    objectTypeEntities.forEach(
            x -> {
              ObjectTypeDTO objectTypeDTO=new ObjectTypeDTO();
              List<ObjectTypeDTO> objectTypeDTOList1=new ArrayList<>(10);
              List<ObjectTypeEntity> objectTypeEntities1 = getObjectTypeEntitiesByParentEntity(x);
              objectTypeEntities1.forEach(
                      x2 -> {
                        ObjectTypeDTO objectTypeDTO1=new ObjectTypeDTO();
                        List<ObjectTypeEntity> objectTypeEntities2 = getObjectTypeEntitiesByParentEntity(x2);
                        if (!objectTypeEntities2.isEmpty()) {
                          objectTypeDTO1.setObjectTypename(x2.getName());
                          objectTypeDTO1.setObjectTypeId(x2.getObjectTypeId());
                          objectTypeDTO1.setObjectTypeParentId(x2.getParentId());
                          objectTypeDTO1.setChildObjectTypes(objectTypeEntities2.stream().map(x3 -> {
                            ObjectTypeDTO objectTypeDTO3=new ObjectTypeDTO();
                            objectTypeDTO3.setObjectTypeParentId(x3.getParentId());
                            objectTypeDTO3.setObjectTypeId(x3.getObjectTypeId());
                            objectTypeDTO3.setObjectTypename(x3.getName());
                            return objectTypeDTO3;
                          }).collect(Collectors.toList()));
                        }
                        else {
                          objectTypeDTO1.setObjectTypename(x2.getName());
                          objectTypeDTO1.setObjectTypeId(x2.getObjectTypeId());
                          objectTypeDTO1.setObjectTypeParentId(x2.getParentId());
                          objectTypeDTO1.setChildObjectTypes(Collections.EMPTY_LIST);
                        }
                        objectTypeDTOList1.add(objectTypeDTO1);
                      }
              );
              objectTypeDTO.setObjectTypeId(x.getObjectTypeId());
              objectTypeDTO.setObjectTypename(x.getName());
              objectTypeDTO.setObjectTypeParentId(x.getParentId());
              objectTypeDTO.setChildObjectTypes(objectTypeDTOList1);
              objectTypeDTOList.add(objectTypeDTO);
            }
    );
    return objectTypeDTOList;
  }

  @Override
  public List<ObjectTypeDTO> findByParentId(List<Long> ids) {
    if(Objects.nonNull(ids) && !ids.isEmpty()){
      List<Object[]> objectTypes=objectTypeEntityRepository.findByParentIdsIn(ids);
      if(!objectTypes.isEmpty()) {
        List<ObjectTypeDTO> objectTypeDTOList=new ArrayList<>(5);
        objectTypes.stream().forEach((record) -> {
          ObjectTypeDTO objectTypeDTO = new ObjectTypeDTO();
          objectTypeDTO.setObjectTypeId(Objects.nonNull(record[0])?((Long) record[0]).longValue():null);
          objectTypeDTO.setObjectTypename(String.valueOf(record[1]));
          objectTypeDTO.setObjectTypeDescription(String.valueOf(record[2]));
          objectTypeDTOList.add(objectTypeDTO);
        });
        return objectTypeDTOList;
      }
      throw new YellowPagesApiException(HttpStatus.NOT_FOUND,"object type is not present for the given parent Id: "+ids);
    }
    return null;
  }



  private List<ObjectTypeEntity> getObjectTypeEntitiesByParentEntity(ObjectTypeEntity x2) {
    List<ObjectTypeEntity> list;
    try {
      list =findByParentId(x2.getObjectTypeId());
    } catch (YellowPagesApiException e) {
      list = Collections.EMPTY_LIST;
    }
    return list;
  }
}
