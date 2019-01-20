package com.yellowpages.model;

import com.yellowpages.model.dto.AttributeDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Ruksad siddiqui on 19/2/18
 */
@Entity
@Table(name = "LIST")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ListEntity implements Serializable {

    @Id
    @Column(name = "LIST_ID", unique = true)
    private long listId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ATTRIBUTE_ID", referencedColumnName = "ATTRIBUTE_ID")
    private AttributesEntity attributesEntity;

    @Column(name = "VALUE")
    private String value;


    public static ListEntity from(AttributeDTO attributeDTO, AttributesEntity attributesEntity) {
        ListEntity listEntity = new ListEntity();
        listEntity.setListId(attributeDTO.getSelectedListValue().getListId());
        listEntity.setValue(attributeDTO.getSelectedListValue().getListValue());
        listEntity.setAttributesEntity(attributesEntity);
        return listEntity;
    }
}
