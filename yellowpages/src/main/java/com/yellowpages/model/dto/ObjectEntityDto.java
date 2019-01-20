package com.yellowpages.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ruksad siddiqui on 19/2/18
 */
@Getter
@Setter
public class ObjectEntityDto {
    private String name;
    private String description;
    private String parentCity;
    private Long price;
    private Long objectId;
    private Long parentId;
}
