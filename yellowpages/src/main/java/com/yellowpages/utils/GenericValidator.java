package com.yellowpages.utils;

import com.yellowpages.exception.RequestFaultException;
import com.yellowpages.model.dto.AttributeDTO;
import com.yellowpages.model.dto.FindObjectsByCriterion;
import com.yellowpages.model.dto.PostAdDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.concurrent.CompletableFuture.anyOf;

/**
 * Created by Ruksad siddiqui on 10/2/18
 */
@Slf4j
public class GenericValidator {

    static Predicate<Object> isNull= Objects::isNull;
    static Predicate<String> isNullOrEmptyString= StringUtils::isEmpty;
    static Predicate<Collection> isEmpty= Collection::isEmpty;


    public static void validateAppPrerequisiteResponseDto(FindObjectsByCriterion appPrerequisiteResponseDto){
        checkIfValueIsNull(appPrerequisiteResponseDto.getStateId(),ErrorCode.STATE_IS_MISSING);
        checkIfValueIsNull(appPrerequisiteResponseDto.getSelectedCityId(), ErrorCode.CITY_IS_MISSING);
       if(Objects.nonNull(appPrerequisiteResponseDto.getLocalityId())) {
           try {
               checkIfValueIsNull(appPrerequisiteResponseDto.getLocalityId(), ErrorCode.LOCALITY_IS_MISSING);
           } catch (RequestFaultException e) {

           }
       }
        checkIfValueIsNull(appPrerequisiteResponseDto.getCategoryId(),ErrorCode.CATEGORY_IS_MISSING);
    }

    public static void checkIfValueIsNull(Long value, ErrorCode errorCode) {
        if (isNull.test(value)) {
            throwRequestFaultException(errorCode);
        }
    }

    public static void checkIfCollectionIsEmpty(Collection c,ErrorCode errorCode){
        if(isEmpty.test(c)){
            throwRequestFaultException(errorCode);
        }
    }

    public static void checkIfStringEmptyOrNull(String value, ErrorCode errorCode) {
        if (isNullOrEmptyString.test(value)) {
            throwRequestFaultException(errorCode);
        }
    }
    public static void validateGenericPostAd(PostAdDto postAdDto){
        checkIfValueIsNull(postAdDto.getObjectTypeLevel2CategoryId(),ErrorCode.LEVEL_2_CATEGORY_ID_MISSING);
        checkIfValueIsNull(postAdDto.getObjectTypeId(),ErrorCode.LEAF_NODE_CATEGORY_ID_MISSING);
        checkIfValueIsNull(postAdDto.getCityId(),ErrorCode.CITY_IS_MISSING);
        checkIfStringEmptyOrNull(postAdDto.getName(),ErrorCode.OBJECT_NAME_OR_DESCRIPTION_IS_MISSING);
        checkIfStringEmptyOrNull(postAdDto.getObjectDescription(),ErrorCode.OBJECT_NAME_OR_DESCRIPTION_IS_MISSING);
        List<AttributeDTO> attributeDTOs=postAdDto.getAttributeDTOList();
        checkIfCollectionIsEmpty(attributeDTOs,ErrorCode.ATTRIBUTES_ARE_MISSING);

    }

    public static void validateUserRegistration(PostAdDto postAdDto){
        checkIfStringEmptyOrNull(postAdDto.getName(),ErrorCode.USER_NAME_IS_MISSING);
        checkIfValueIsNull(postAdDto.getCityId(),ErrorCode.REGISTRATION_TYPE_IS_MISSING);
        checkIfValueIsNull(postAdDto.getObjectTypeId(),ErrorCode.REGISTRATION_GROUP_IS_MISSING);
        List<AttributeDTO> attributeDTOs=postAdDto.getAttributeDTOList();
        checkIfCollectionIsEmpty(attributeDTOs,ErrorCode.ATTRIBUTES_ARE_MISSING);
    }

    public static void validatePostAdForAttributesId(PostAdDto postAdDto, List<Long> attributeIds){
        List<Long> collect = postAdDto.getAttributeDTOList().stream().map(attribute -> attribute.getAttributeId()).collect(Collectors.toList());
        boolean b = attributeIds.removeAll(collect);
        if(b && attributeIds.size()==0)
            return;
        throw new RuntimeException(attributeIds +" Attributes are missing");
    }

    public static void throwRequestFaultException(ErrorCode errorCode) {
        throw new RequestFaultException(errorCode);
    }
}
