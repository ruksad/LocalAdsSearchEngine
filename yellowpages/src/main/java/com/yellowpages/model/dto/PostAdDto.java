package com.yellowpages.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ruksad siddiqui on 10/3/18
 */
@Getter
@Setter
public class PostAdDto {
    private Long objectTypeLevel2CategoryId;
    private Long objectTypeId;
    private String objectTypeName;
    private Long cityId;
    private Long localityId;
    private List<AttributeDTO> attributeDTOList=new LinkedList<>();
    private String objectDescription;
    private String name;
}
