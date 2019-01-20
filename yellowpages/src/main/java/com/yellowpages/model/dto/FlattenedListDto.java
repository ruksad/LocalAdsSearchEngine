package com.yellowpages.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 22/2/18
 */
@Getter
@Setter
public class FlattenedListDto {

    private Long listId;
    private Long attributeId;
    private String attributeName;
    private String attributeDescription;
    List<String> listValues;
}
