package com.yellowpages.security.model;

import com.yellowpages.model.enums.categories.PostAdRule;
import lombok.AllArgsConstructor;

/**
 * Created by Ruksad siddiqui on 8/4/18
 */
@AllArgsConstructor
public enum UserRegistrationMandatoryAttr implements PostAdRule {
    REGISTERED_SINCE(50000010L),
    TELEPHONE(50000013L),
    EMAIL(50000015L),
    PASSWORD(50000040L),
    REGISTERED_USER_STATUS(50000041L);

    private final Long displayValue;
    @Override
    public Long getDisplayValue() {
        return this.displayValue;
    }
}
