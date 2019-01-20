package com.yellowpages.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Ruksad siddiqui on 28/1/18
 */
@Entity
@Table(name = "OBJECT_TYPE")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class ObjectTypeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OBJECT_TYPE_ID", unique = true)
    private long objectTypeId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "PARENT_ID")
    private long parentId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "objectType")
    private List<ObjectEntity> objects;

    public boolean addObject(ObjectEntity objectEntity) {
        return this.objects.add(objectEntity);
    }
}
