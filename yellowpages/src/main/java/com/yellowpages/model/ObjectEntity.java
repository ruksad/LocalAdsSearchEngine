package com.yellowpages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yellowpages.model.dto.PostAdDto;
import com.yellowpages.model.enums.categories.PostAddRuleAttributes;
import com.yellowpages.model.enums.categories.UserRegistrationAttributes;
import com.yellowpages.utils.CommonUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Ruksad siddiqui on 28/1/18
 */
@Entity
@Table(name = "OBJECT")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ObjectEntity implements Serializable {

    @Id
    @GenericGenerator(name = "custom_objectId_generator", strategy = "com.yellowpages.generator.ObjectIdGenerator")
    @GeneratedValue(generator = "custom_objectId_generator")
    @Column(name = "OBJECT_ID")
    protected long objectId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = ObjectTypeEntity.class)
    @JoinColumn(name = "OBJECT_TYPE_ID")
    @JsonIgnore
    private ObjectTypeEntity objectType;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "object")
    private List<ParametersEntity> parameters = new ArrayList<>(10);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private ObjectEntity objectEntity;

    @OneToMany(mappedBy = "objectEntity")
    private List<ObjectEntity> objectEntities;


    public void addParameters(ParametersEntity parametersEntity, AttributesEntity attributesEntity, ListEntity listEntity) {
        addParameters(parametersEntity, attributesEntity, listEntity, true);
    }

    public void addParameters(ParametersEntity parametersEntity, AttributesEntity attributesEntity, ListEntity listEntity, boolean set) {
        if (Objects.nonNull(parametersEntity)) {
            getParameters().add(parametersEntity);
            if (set) {
                parametersEntity.setObject(this, false);
                parametersEntity.setAttribute(attributesEntity);
                parametersEntity.setListEntity(listEntity);
            }
        }
    }

    public static ObjectEntity from(PostAdDto postAdDto) {
        ObjectEntity objectEntity = new ObjectEntity();
        ObjectEntity objectEntity1 = new ObjectEntity();
        objectEntity1.setObjectId(postAdDto.getCityId().longValue());

        objectEntity.setObjectEntity(objectEntity1);
        objectEntity.setName(postAdDto.getName());
        objectEntity.setDescription(postAdDto.getObjectDescription());
        objectEntity.setName(postAdDto.getName());

        postAdDto.getAttributeDTOList().forEach(attributeDTO -> {
            ParametersEntity parametersEntity = new ParametersEntity();

            ListEntity listEntity = null;
            AttributesEntity attributesEntity = new AttributesEntity();
            attributesEntity.setAttributeId(attributeDTO.getAttributeId());
            attributesEntity.setName(attributeDTO.getAttributeName());
            attributesEntity.setDescription(attributeDTO.getAttributeDescription());

            ParametersCompositeKey parametersCompositeKey = new ParametersCompositeKey(objectEntity.getObjectId(), attributesEntity.getAttributeId());
            parametersEntity.setId(parametersCompositeKey);

            if(attributeDTO.getAttributeId().equals(PostAddRuleAttributes.POSTED_DATE.getDisplayValue())||
                    attributeDTO.getAttributeId().equals(UserRegistrationAttributes.REGISTRATION_SINCE.getDisplayValue())){

                parametersEntity.setValue(CommonUtils.currentDateInUTCInString());
            }else if (Objects.nonNull(attributeDTO.getParameterValue())) {

                parametersEntity.setValue(attributeDTO.getParameterValue());
            } else if (Objects.nonNull(attributeDTO.getSelectedListValue())) {

                listEntity = new ListEntity();
                listEntity.setListId(attributeDTO.getSelectedListValue().getListId());
                listEntity.setValue(attributeDTO.getSelectedListValue().getListValue());
            }
            objectEntity.addParameters(parametersEntity, attributesEntity, listEntity);
        });

        return objectEntity;
    }

}
