package com.yellowpages.repository;

import com.yellowpages.log.annotation.Trace;
import com.yellowpages.log.eventtype.LogEventType;
import com.yellowpages.model.ObjectTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by Ruksad siddiqui on 28/1/18
 */
public interface ObjectTypeEntityRepository extends JpaRepository<ObjectTypeEntity,Long>{

    @Trace(type = LogEventType.DATABASE)
    Optional<ObjectTypeEntity> findOneByObjectTypeId(Long objectTypeId);

    @Trace(type = LogEventType.DATABASE)
    Optional<Object> findOneByName(String name);

    List<ObjectTypeEntity> findAllByParentId(long id);

    @Query(value="  SELECT t1.name AS objectTypeNameOne , " +
            "t1.OBJECT_TYPE_ID as objectTypeNameOneId ," +
            " t2.name as objectTypeNameTwo,  " +
            "t2.OBJECT_TYPE_ID as objectTypeNameTwoId ," +
            " t3.name as objectTypeNameThree, " +
            "t3.OBJECT_TYPE_ID as objectTypeNameThreeId ," +
            " t4.name as objectTypeNameFour," +
            " t4.OBJECT_TYPE_ID as objectTypeNameFourId\n" +
            "FROM OBJECT_TYPE AS t1\n" +
            "LEFT JOIN OBJECT_TYPE AS t2 ON t2.PARENT_ID = t1.OBJECT_TYPE_ID\n" +
            "LEFT JOIN OBJECT_TYPE AS t3 ON t3.PARENT_ID = t2.OBJECT_TYPE_ID\n" +
            "LEFT JOIN OBJECT_TYPE AS t4 ON t4.PARENT_ID = t3.OBJECT_TYPE_ID\n" +
            "WHERE t1.OBJECT_TYPE_ID = ?1 AND t2.OBJECT_TYPE_ID = ?2 ",nativeQuery = true)
    List<Object[]> getHierarchyForLevel2(long category,long subCategory);

    @Query(value="SELECT t1.name AS objectTypeNameOne ," +
            " t1.OBJECT_TYPE_ID as objectTypeNameOneId , " +
            "t2.name as objectTypeNameTwo, " +
            " t2.OBJECT_TYPE_ID as objectTypeNameTwoId ," +
            " t3.name as objectTypeNameThree," +
            " t3.OBJECT_TYPE_ID as objectTypeNameThreeId , " +
            "t4.name as objectTypeNameFour," +
            " t4.OBJECT_TYPE_ID as objectTypeNameFourId\n" +
            "FROM OBJECT_TYPE AS t1\n" +
            "LEFT JOIN OBJECT_TYPE AS t2 ON t2.PARENT_ID = t1.OBJECT_TYPE_ID\n" +
            "LEFT JOIN OBJECT_TYPE AS t3 ON t3.PARENT_ID = t2.OBJECT_TYPE_ID\n" +
            "LEFT JOIN OBJECT_TYPE AS t4 ON t4.PARENT_ID = t3.OBJECT_TYPE_ID\n" +
            "WHERE t1.OBJECT_TYPE_ID = ?1 AND t3.OBJECT_TYPE_ID = ?2 ",nativeQuery = true)
    List<Object[]> getHierarchyForLevel3(long category,long subCategory);

    @Query(value=" SELECT o.objectTypeId ,o.name ,o.description from ObjectTypeEntity o where o.parentId IN :ids ")
    List<Object[]> findByParentIdsIn(@Param("ids")List<Long> ids);
}
