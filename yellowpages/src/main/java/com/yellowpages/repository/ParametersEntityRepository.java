package com.yellowpages.repository;

import com.yellowpages.model.ParametersCompositeKey;
import com.yellowpages.model.ParametersEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ruksad siddiqui on 28/1/18
 */
public interface ParametersEntityRepository extends JpaRepository<ParametersEntity,ParametersCompositeKey> {

    List<ParametersEntity> findAllByAttributeAttributeIdIn(List<Long> ids);

	List<ParametersEntity> findByValue(String mobileNumberOrEmail);


}
