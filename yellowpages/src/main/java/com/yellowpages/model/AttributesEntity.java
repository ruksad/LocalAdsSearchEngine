package com.yellowpages.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Ruksad siddiqui on 28/1/18
 */
@Entity
@Table(name = "ATTRIBUTES")
@Getter
@Setter
@NoArgsConstructor
public class AttributesEntity implements Serializable {

    @Id
    @Column(name = "ATTRIBUTE_ID", unique = true)
    private long attributeId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributesEntity that = (AttributesEntity) o;
        return attributeId == that.attributeId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(attributeId);
    }
}
