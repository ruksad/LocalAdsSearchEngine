package com.yellowpages.model.enums.categories;

import lombok.AllArgsConstructor;

/**
 * Created by Ruksad siddiqui on 5/4/18
 */
@AllArgsConstructor
public enum UserRegistrationAttributes implements PostAdRule {
    REGISTRATION_SINCE(50000010L),
    TELEPHONE(50000013L),
    EMAIL(50000015L),
    PASSWORD(50000040L),
    REGISTERED_USER_STATUS(50000041L);

    private final Long displayValue;

    @Override
    public Long getDisplayValue() {
        return displayValue;
    }
}
