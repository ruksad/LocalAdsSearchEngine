package com.yellowpages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Ruksad siddiqui on 28/1/18
 */
@Entity
@Table(name = "PARAMETERS")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ParametersEntity implements Serializable {

    @EmbeddedId
    @JsonIgnore
    private ParametersCompositeKey id;

    @Column(name = "VALUE")
    private String value;

    @MapsId("objectId")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "OBJECT_ID",referencedColumnName ="OBJECT_ID")
    @JsonIgnore
    private ObjectEntity object;


    @MapsId("attributeId")
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "ATTRIBUTE_ID",referencedColumnName ="ATTRIBUTE_ID" )
    private AttributesEntity attribute;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "LIST_ID")
    private ListEntity listEntity;

    public void setObject(ObjectEntity object) {
        setObject(object, true);
    }

    public void setObject(ObjectEntity object, boolean add) {
        this.object = object;
    }

    public void setAttribute(AttributesEntity attribute){
        if (Objects.nonNull(attribute)) {
            this.attribute = attribute;
        }
    }

    public void setListEntity(ListEntity listEntity){
        setListEntity(listEntity, true);
    }

    public void setListEntity(ListEntity listEntity,boolean add){
        this.listEntity = listEntity;
        if (Objects.nonNull(listEntity) && add) {
            listEntity.setAttributesEntity(this.attribute);
        }
    }
}
