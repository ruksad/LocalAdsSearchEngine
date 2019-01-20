package com.yellowpages.model.dto;

import com.yellowpages.model.ObjectEntity;
import com.yellowpages.model.ParametersEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Ruksad siddiqui on 20/2/18
 */
@Getter
@Setter
public class FlattenedObjectEntityDto {
    private String name;
    private String description;
    private Long objectId;
    private Long parentId;
    //GroupByAttributeIdInParameters
    private List<FlattenedAttributeDto> parametersForAttribute;
    //GroupByAttributeIdInList
    private List<FlattenedListDto> listForAttribute;
    //GroupByListIdInParameters
    private List<FlattenedParametersDto> parametersForList;

    public static FlattenedObjectEntityDto from(ObjectEntity objectEntity) {
        FlattenedObjectEntityDto flattenedObjectEntityDto = new FlattenedObjectEntityDto();
        flattenedObjectEntityDto.setDescription(objectEntity.getDescription());
        flattenedObjectEntityDto.setName(objectEntity.getName());
        flattenedObjectEntityDto.setObjectId(objectEntity.getObjectId());
        flattenedObjectEntityDto.setParentId(objectEntity.getObjectEntity().getObjectId());
        Map<Optional<Long>, List<ParametersEntity>> groupByAttributeIdInParametersMap =
                objectEntity.getParameters().stream().collect(Collectors.groupingBy(x -> Optional.ofNullable(x.getAttribute().getAttributeId())));
        Map<Optional<Long>, List<ParametersEntity>> groupByAttributeIdInListMap =
                objectEntity.getParameters().stream().filter(x -> Objects.nonNull(x.getListEntity())).collect(Collectors.groupingBy(x -> Optional.ofNullable(x.getListEntity().getAttributesEntity().getAttributeId())));
        Map<Optional<Long>, List<ParametersEntity>> groupByListIdInParametersMap =
                objectEntity.getParameters().stream().filter(x -> Objects.nonNull(x.getListEntity())).collect(Collectors.groupingBy(x -> Optional.ofNullable(x.getListEntity().getListId())));

        List<FlattenedAttributeDto> groupByAttributeIdInParameters = new ArrayList<>(5);
        groupByAttributeIdInParametersMap.forEach((key, value) -> {
            if (key.isPresent()) {
                FlattenedAttributeDto flattenedAttributeDto = new FlattenedAttributeDto();
                flattenedAttributeDto.setAttributeId(value.get(0).getAttribute().getAttributeId());
                flattenedAttributeDto.setDescription(value.get(0).getAttribute().getDescription());
                flattenedAttributeDto.setName(value.get(0).getAttribute().getName());
                flattenedAttributeDto.setParameterValues(value.stream().map(parameterValue -> parameterValue.getValue()).collect(Collectors.toList()));
                groupByAttributeIdInParameters.add(flattenedAttributeDto);
            }
        });
        flattenedObjectEntityDto.setParametersForAttribute(groupByAttributeIdInParameters);


        List<FlattenedListDto> groupByAttributeIdInList = new ArrayList<>(5);
        groupByAttributeIdInListMap.forEach((key, value) -> {
            if (key.isPresent()) {
                FlattenedListDto flattenedListDto = new FlattenedListDto();
                flattenedListDto.setAttributeDescription(value.get(0).getListEntity().getAttributesEntity().getDescription());
                flattenedListDto.setAttributeId(value.get(0).getListEntity().getAttributesEntity().getAttributeId());
                flattenedListDto.setAttributeName(value.get(0).getListEntity().getAttributesEntity().getName());
                flattenedListDto.setListId(value.get(0).getListEntity().getListId());
                flattenedListDto.setListValues(value.stream().map(listValue -> listValue.getListEntity().getValue()).collect(Collectors.toList()));
                groupByAttributeIdInList.add(flattenedListDto);
            }
        });
        flattenedObjectEntityDto.setListForAttribute(groupByAttributeIdInList);


        List<FlattenedParametersDto> groupByListIdInParameters = new ArrayList<>(5);
        groupByListIdInParametersMap.forEach((key, value) -> {
            if (key.isPresent()) {
                FlattenedParametersDto flattenedParametersDto = new FlattenedParametersDto();
                flattenedParametersDto.setAttributeDescription(value.get(0).getListEntity().getAttributesEntity().getDescription());
                flattenedParametersDto.setAttributeId(value.get(0).getListEntity().getAttributesEntity().getAttributeId());
                flattenedParametersDto.setAttributeName(value.get(0).getListEntity().getAttributesEntity().getName());
                flattenedParametersDto.setListId(value.get(0).getListEntity().getListId());
                flattenedParametersDto.setListValue(value.get(0).getListEntity().getValue());
                flattenedParametersDto.setParameterValues(value.stream().map(parameterValue -> parameterValue.getValue()).collect(Collectors.toList()));
                groupByListIdInParameters.add(flattenedParametersDto);
            }
        });
        flattenedObjectEntityDto.setParametersForList(groupByListIdInParameters);

        return flattenedObjectEntityDto;
    }
}
