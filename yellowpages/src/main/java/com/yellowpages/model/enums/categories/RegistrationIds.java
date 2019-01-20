package com.yellowpages.model.enums.categories;

import lombok.AllArgsConstructor;

/**
 * Created by Ruksad siddiqui on 5/4/18
 */
@AllArgsConstructor
public enum RegistrationIds {

    USER_OBJECT_TYPE(90000132L),
    GROUP_OBJECT_TYPE(90000131L),
    ALL_USERS_ID(60000028L);

    private final Long displayValue;
    public Long getDisplayValue() {
        return this.displayValue;
    }
}
