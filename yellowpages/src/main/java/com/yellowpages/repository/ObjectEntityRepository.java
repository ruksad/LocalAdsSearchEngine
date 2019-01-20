package com.yellowpages.repository;

import com.yellowpages.model.ObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 28/1/18
 */
public interface ObjectEntityRepository extends JpaRepository<ObjectEntity, Long> {

    List<ObjectEntity> findByParametersValue(String parameterValue);

    List<ObjectEntity> findByObjectTypeNameIgnoreCase(String objectTypeName);

    List<ObjectEntity> findByParametersValueIgnoreCaseAndParametersAttributeNameIgnoreCase(String parameterValue, String attributeName);

    List<ObjectEntity> findByObjectId(long name1);

    List<ObjectEntity> findByNameIgnoreCase(String objectName);

    List<ObjectEntity> findByObjectIdAndObjectEntityObjectId(long id, long parentId);

    List<ObjectEntity> findByObjectTypeNameIgnoreCaseAndObjectEntityObjectId(String objectName, long parentId);

    List<ObjectEntity> findAllByObjectTypeNameIgnoreCaseInAndObjectEntityObjectId(List<String> objectName, long parentId);

    //@Query(value=" SELECT o.objectId ,o.parentId ,o.name, o.description from ObjectEntity o where o.objectType.objectTypeId IN :ids AND o.parentId = :parentId")
    List<ObjectEntity> findAllByObjectTypeObjectTypeIdInAndObjectEntityObjectId(List<Long> ids, Long parentId);

    ObjectEntity findAllByObjectIdAndObjectEntityObjectId(long objectId, long parentId);

    List<ObjectEntity> findByObjectEntityObjectIdAndParametersAttributeAttributeIdIn(long parentId, List<Long> attributeId);
}
