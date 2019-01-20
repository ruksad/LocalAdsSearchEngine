package com.yellowpages.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ruksad siddiqui on 13/2/18
 * class used to map 4 level of inner join on parentId
 */
@Getter
@Setter
@EqualsAndHashCode
public class ObjectTypeHierarchyMapping {
    private String objectTypeNameOne;
    private Long objectTypeNameOneId;
    private String objectTypeNameTwo;
    private Long objectTypeNameTwoId;
    private String objectTypeNameThree;
    private Long objectTypeNameThreeId;
    private String objectTypeNameFour;
    private Long objectTypeNameFourId;
}
