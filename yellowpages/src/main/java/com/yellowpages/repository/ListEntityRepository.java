package com.yellowpages.repository;

import com.yellowpages.model.ListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 11/3/18
 */
public interface ListEntityRepository extends JpaRepository<ListEntity,Long> {

    @Query(value=" SELECT o.listId ,o.value ,o.attributesEntity.attributeId ,o.attributesEntity.name, o.attributesEntity.description from ListEntity " +
            "o where o.attributesEntity.attributeId IN :ids order by FIND_IN_SET(o.attributesEntity.attributeId,:isStr)")
    List<Object[]> findAllListInIds(@Param("ids") List<Long> ids,@Param("isStr") String idStr);
}
