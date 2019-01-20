package com.yellowpages.service;

import com.yellowpages.model.ObjectEntity;
import com.yellowpages.model.dto.PostAdDto;
import org.springframework.stereotype.Service;

/**
 * Created by Ruksad siddiqui on 11/3/18
 */
@Service
public interface PostAdRulesService {
    PostAdDto postAddRuleForVehicle(Long parentId);
    PostAdDto getUserRegistrationTemplate();
    PostAdDto postAddRuleForProperties(Long parentId);
    PostAdDto postAddRuleForCategory(Long parentId);
    ObjectEntity preparePostAdModel(PostAdDto postAdDto);
    ObjectEntity prePareUserRegistration(PostAdDto postAdDto);
}
