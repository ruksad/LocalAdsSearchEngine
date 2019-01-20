package com.yellowpages.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Ruksad siddiqui on 10/3/18
 */
@Getter
@Setter
public class AttributeDTO {
    private Long attributeId;
    private String attributeName;
    private String attributeDescription;
    private List<ListDto> listValues=new LinkedList<>();
    /** either parameter value will be present or the selected listDTO value **/
    private String parameterValue;
    private ListDto selectedListValue;
    /** attribute is drop down or text for UI**/
    private String attributeType;
    private List<MultipartFile> files;
    /**
     * all the values not comming from parameters and list entity
     */
    private Map<String,List<ObjectTypeDTO>> others=new HashMap<>(5);
}
