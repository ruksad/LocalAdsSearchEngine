package com.yellowpages.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 20/2/18
 */
@Getter
@Setter
public class FlattenedAttributeDto {
    private String name;
    private String description;
    private Long attributeId;
    List<String> parameterValues;
}
