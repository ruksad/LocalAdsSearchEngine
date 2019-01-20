package com.yellowpages.service.implementations;

import com.yellowpages.exception.RequestFaultException;
import com.yellowpages.exception.YellowPagesApiException;
import com.yellowpages.log.annotation.Trace;
import com.yellowpages.log.eventtype.LogEventType;
import com.yellowpages.model.ObjectEntity;
import com.yellowpages.model.ObjectTypeEntity;
import com.yellowpages.model.ParametersEntity;
import com.yellowpages.model.dto.*;
import com.yellowpages.model.enums.categories.RegistrationIds;
import com.yellowpages.service.FederatedService;
import com.yellowpages.service.ObjectService;
import com.yellowpages.service.ObjectTypeService;
import com.yellowpages.service.PostAdRulesService;
import com.yellowpages.utils.AppConstants;
import com.yellowpages.utils.CommonUtils;
import com.yellowpages.utils.ErrorCode;
import com.yellowpages.utils.GenericValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;



/**
 * Created by Ruksad siddiqui on 31/1/18
 */
@Slf4j
@Service
public class FederatedServiceImpl implements FederatedService {

    private final ObjectTypeService objectTypeService;
    private final ObjectService objectService;
    private final PostAdRulesService postAdRuleService;

    @Autowired
    public FederatedServiceImpl(ObjectTypeService objectTypeService, ObjectService objectService, PostAdRulesService postAdRuleService) {
        this.objectTypeService = objectTypeService;
        this.objectService = objectService;
        this.postAdRuleService = postAdRuleService;
    }

    @Override
    @Trace(type = LogEventType.SERVICE)
    public Set<String> findObjectNamesByObjectTypeName(String objectTypeName) {
        ObjectTypeEntity objectTypeEntity = this.objectTypeService.findByName(objectTypeName);
        Set<String> objectsName = new HashSet<>(5);
        objectTypeEntity.getObjects().forEach(x -> {
            objectsName.add(x.getName().trim().toLowerCase());
        });
        return objectsName;
    }

    @Override
    @Trace(type = LogEventType.SERVICE)
    public Set<ObjectEntity> findObjectNameByParameterValue(String parametervalue) {
        Set set = new HashSet<>(10);
        set.addAll(this.objectService.findByParameterValue(parametervalue));
        return set;
    }

    @Override
    @Trace(type = LogEventType.SERVICE)
    public StatesAndCities getPreRequisitePrepared() {
        StatesAndCities statesAndCities = new StatesAndCities();
        statesAndCities.setStates(collectStatesAndCities());
        statesAndCities.setPopularCities(this.objectService.findByParameterAndAttribute(AppConstants.POPULAR_CITY, AppConstants.POPULAR).stream().map(x -> x.getName()).collect(
                Collectors.toSet()));
        return statesAndCities;
    }


    @Override
    @Trace(type = LogEventType.SERVICE)
    public List<FlattenedObjectEntityDto> getCriteriaMatchingObjects(FindObjectsByCriterion appPrerequisiteResponseDto) {
        GenericValidator.validateAppPrerequisiteResponseDto(appPrerequisiteResponseDto);
        List<ObjectEntity> state = getByObjectId(appPrerequisiteResponseDto.getStateId());
        if (state.isEmpty())
            throw new RequestFaultException(ErrorCode.REQUEST_NOT_SERVED_FOR_STATE);
        List<ObjectEntity> city = getObjectByIdAndParentId(appPrerequisiteResponseDto.getSelectedCityId(), state.get(0).getObjectId());
        if (city.isEmpty())
            throw new RequestFaultException(ErrorCode.REQUEST_NOT_SERVED_FOR_CITY);
        if (Objects.nonNull(appPrerequisiteResponseDto.getLocalityId())) {
            //locality search if present
            city = getObjectByIdAndParentId(appPrerequisiteResponseDto.getLocalityId(), city.get(0).getObjectId());
        }
        List<ObjectTypeHierarchyMapping> objectsTypesHierarchyMapping = Collections.EMPTY_LIST;

        List<Long> objectsToFindFor = new ArrayList<>(10);
        List<Long> objectsToFindForId = new ArrayList<>(10);
        List<ObjectEntity> objectsOfCategory = null;

        try {
            objectsTypesHierarchyMapping = this.objectTypeService.getObjectTypeHierarchyForLevel2(AppConstants.CATEGORIES_ID, appPrerequisiteResponseDto.getCategoryId());
        } catch (YellowPagesApiException e) {
            try {
                objectsTypesHierarchyMapping = this.objectTypeService.getObjectTypeHierarchyForLevel3(AppConstants.CATEGORIES_ID, appPrerequisiteResponseDto.getCategoryId());
            } catch (YellowPagesApiException e1) {
                log.info("not able to fetch categories and objects {}", e1.getMessage());
                objectsToFindFor.add(appPrerequisiteResponseDto.getCategoryId());
                objectsOfCategory = getByObjectsIdAndParentId(objectsToFindFor, city.get(0).getObjectId());
            }
        }

        if (!objectsTypesHierarchyMapping.isEmpty()) {
            objectsTypesHierarchyMapping.forEach(x -> {
                if (Objects.nonNull(x.getObjectTypeNameFourId())) {
                    objectsToFindForId.add(x.getObjectTypeNameFourId());
                } else if (Objects.nonNull(x.getObjectTypeNameThreeId())) {
                    objectsToFindForId.add(x.getObjectTypeNameThreeId());
                }
            });
            objectsOfCategory = getObjectsNameAndDescriptionByObjectTypeIdAndParentId(objectsToFindForId, city.get(0).getObjectId());
        }

        if (objectsOfCategory.isEmpty())
            throw new RequestFaultException(ErrorCode.REQUEST_NOT_SERVED_FOR_CITY_STATE_CATEGORY);


        return CommonUtils.getFlattenedObjectEntityDtos(objectsOfCategory);
    }

    @Override
    public List<FlattenedObjectEntityDto> getAllFeaturedCardsById(long id) {
        return this.objectService.finObjectsByObjectIdAndAttributeIds(id);
    }

    @Override
    public PostAdDto getUserRegistrationTemplate() {
        PostAdDto postAdDto = this.postAdRuleService.getUserRegistrationTemplate();
        postAdDto.setObjectTypeId(RegistrationIds.USER_OBJECT_TYPE.getDisplayValue());
        postAdDto.setCityId(RegistrationIds.ALL_USERS_ID.getDisplayValue());
        return postAdDto;
    }

    @Override
    public PostAdDto getPostAdDto(Long parentId,Long objectLevel3Id,String objectTypeName,Long objectLevel4Id) {
        PostAdDto postAdDto;
        if (Objects.nonNull(parentId)) {
            if (parentId.equals(AppConstants.VEHICLES_CATEGORY_ID)) {

                postAdDto= this.postAdRuleService.postAddRuleForVehicle(parentId);
                if(Objects.nonNull(objectLevel4Id)) {
                    Optional<AttributeDTO> modelIsPresent =
                            postAdDto.getAttributeDTOList().stream().filter(x -> x.getAttributeId() == AppConstants.MODEL_ATTRIBUTE_ID).findFirst();
                    if (modelIsPresent.isPresent() && objectLevel3Id.equals(AppConstants.CARS_ID)) {
                        List<Long> parentIds = new ArrayList<>();
                        parentIds.add(objectLevel4Id);
                        List<ObjectTypeDTO> objectTypeDTOList = objectTypeService.findByParentId(parentIds);

                        modelIsPresent.get().getOthers().put(modelIsPresent.get().getAttributeName(), objectTypeDTOList);
                    }
                }else{
                    throw new RequestFaultException(ErrorCode.LEAF_NODE_CATEGORY_ID_MISSING);
                }

            } else if(parentId.equals(AppConstants.PROPERTIES_CATEGORY_ID)) {
                postAdDto = this.postAdRuleService.postAddRuleForProperties(parentId);

            }else{
                postAdDto = this.postAdRuleService.postAddRuleForCategory(parentId);

            }
            postAdDto.setObjectTypeName(objectTypeName);
            return postAdDto;
        }
        throw new RequestFaultException(ErrorCode.OBJECTID_OR_PARENTID_IS_MISSING);
    }


    private Set<State> collectStatesAndCities() {
        try {
            List<ObjectEntity> states = getByObjectTypeName(AppConstants.STATE);
            List<ObjectEntity> cities = getByObjectTypeName(AppConstants.CITY);
            Set<State> statesWithMappedCities = new HashSet<>(12);
            states.forEach(x -> {
                long objectId = x.getObjectId();
                State state = new State();
                state.setName(x.getName());
                state.setStateId(objectId);
                state.setCities(collectCities(cities, objectId));
                statesWithMappedCities.add(state);
            });
            return statesWithMappedCities;
        } catch (Exception e) {
            throw new YellowPagesApiException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    private Set<City> collectCities(List<ObjectEntity> cities, long stateId) {
        List<ObjectEntity> localities = getByObjectTypeName(AppConstants.LOCALITY);
        return cities.stream().filter(city -> city.getObjectEntity().getObjectId() == stateId)
                .map(x2 -> {
                    City city = new City();
                    city.setCityId(x2.getObjectId());
                    city.setCityName(x2.getName());
                    Optional<ParametersEntity> isCityPopular =
                            x2.getParameters().stream().filter(x3 ->
                                    (x3.getValue().equals(AppConstants.POPULAR_CITY))).findFirst();
                    city.setIsPopular(isCityPopular.isPresent() ? AppConstants.YES : AppConstants.NO);

                    city.setLocalityList(localities.stream().filter(locality -> locality.getObjectEntity().getObjectId() == x2.getObjectId()).map(x4 -> {
                        Locality locality = new Locality();
                        locality.setLocalityId(x4.getObjectId());
                        locality.setLocalityName(x4.getName());
                        return locality;
                    }).collect(Collectors.toList()));


                    return city;
                }).collect(Collectors.toSet());
    }


    private List<ObjectEntity> getByObjectTypeName(String objectTypeName) {
        List<ObjectEntity> list;
        if (Objects.nonNull(objectTypeName)) {
            try {
                list = this.objectService.getByObjectTypeName(objectTypeName);
            } catch (YellowPagesApiException e) {
                list = Collections.EMPTY_LIST;
            }
            if (Objects.isNull(list))
                return Collections.EMPTY_LIST;

            return list;
        }
        return null;
    }

    private List<ObjectEntity> getObjectByIdAndParentId(long id, long parentId) {
        List<ObjectEntity> list;
        try {
            list = this.objectService.findByObjectIdAndParentId(id, parentId);
        } catch (YellowPagesApiException e) {
            list = Collections.EMPTY_LIST;
        }

        if (Objects.isNull(list))
            return Collections.EMPTY_LIST;

        return list;
    }

    private List<ObjectEntity> getByObjectId(long id) {
        List<ObjectEntity> list;
        try {
            list = this.objectService.findById(id);
        } catch (YellowPagesApiException e) {
            list = Collections.EMPTY_LIST;
        }

        if (Objects.isNull(list))
            return Collections.EMPTY_LIST;
        return list;
    }


    private List<ObjectEntity> getByObjectsIdAndParentId(List<Long> objectids, long parentId) {
        List<ObjectEntity> list;
        try {
            list = this.objectService.getByIdAndParentId(objectids, parentId);

        } catch (YellowPagesApiException e) {
            list = Collections.EMPTY_LIST;
        }
        if (Objects.isNull(list))
            return Collections.EMPTY_LIST;

        return list;
    }

    private List<ObjectEntity> getObjectsNameAndDescriptionByObjectTypeIdAndParentId(List<Long> objectIds, long parentId) {
        List<ObjectEntity> list;
        try {
            list = this.objectService.getNameAndDescriptionByObjectTypeIdAndParentId(objectIds, parentId);
        } catch (YellowPagesApiException e) {
            list = Collections.EMPTY_LIST;
        }

        if (Objects.isNull(list))
            return Collections.EMPTY_LIST;
        return list;
    }

}
