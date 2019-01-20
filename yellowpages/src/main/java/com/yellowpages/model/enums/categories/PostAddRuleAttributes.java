package com.yellowpages.model.enums.categories;

import lombok.AllArgsConstructor;

/**
 * Created by Ruksad siddiqui on 10/3/18
 */
@AllArgsConstructor
public enum PostAddRuleAttributes implements PostAdRule{
    PRICE(50000001L),
    TELEPHONE(50000013L),
    IMAGE(50000021l),
    POSTED_BY(50000023l),
    POSTED_DATE(50000024L),
    OBJECT_TYPE_NAME(50000039l),
    EMAIL_ID(50000015l);

    private final Long displayValue;

    @Override
    public Long getDisplayValue() {
       return  displayValue;
    }
}
