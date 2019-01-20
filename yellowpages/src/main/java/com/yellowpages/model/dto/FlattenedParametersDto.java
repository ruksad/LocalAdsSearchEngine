package com.yellowpages.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 22/2/18
 */
@Getter
@Setter
@EqualsAndHashCode
public class FlattenedParametersDto {
    private Long listId;
    private Long attributeId;
    private String attributeName;
    private String attributeDescription;
    private String listValue;
    private List<String> parameterValues;
}
