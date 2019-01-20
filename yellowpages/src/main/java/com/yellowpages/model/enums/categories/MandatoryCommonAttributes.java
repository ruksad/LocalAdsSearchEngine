package com.yellowpages.model.enums.categories;

import lombok.AllArgsConstructor;

/**
 * Created by Ruksad siddiqui on 30/3/18
 */
@AllArgsConstructor
public enum MandatoryCommonAttributes implements PostAdRule {

    PRICE(50000001L),
    TELEPHONE(50000013L),
    POSTED_BY(50000023l),
    OBJECT_TYPE_NAME(50000039l),
    EMAIL_ID(50000015l);
    private final Long displayValue;

    @Override
    public Long getDisplayValue() {
        return  displayValue;
    }
}
