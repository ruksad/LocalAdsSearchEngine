package com.yellowpages.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 26/2/18
 */
@Getter
@Setter
public class ObjectTypeDTO {
    private Long objectTypeId;
    private String objectTypename;
    private Long objectTypeParentId;
    private List<ObjectTypeDTO> childObjectTypes;
    private String objectTypeDescription;
}
