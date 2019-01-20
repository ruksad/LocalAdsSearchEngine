package com.yellowpages.repository;

import com.yellowpages.model.AttributesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 28/1/18
 */
public interface AttributesEntityRepository extends JpaRepository<AttributesEntity,Long>{

    List<AttributesEntity> findAllByAttributeIdIn(List<Long>ids);


    @Query(value=" SELECT o.attributeId ,o.name ,o.description from AttributesEntity o where o.attributeId IN :ids order by FIND_IN_SET(o.attributeId,:isStr)")
    List<Object[]> findAllAttributesInIds(@Param("ids") List<Long> ids,@Param("isStr") String idStr);
}
