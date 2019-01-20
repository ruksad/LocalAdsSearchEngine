package com.yellowpages.model.enums.categories;

import lombok.AllArgsConstructor;

/**
 * Created by Ruksad siddiqui on 29/3/18
 */
@AllArgsConstructor
public enum PropertiesAttributes implements PostAdRule {
    CARPET_AREA(50000028L),
    MONTHLY_MAINTENANCE(50000029L),
    LENGTH(50000034L),
    BREADTH(50000035L),
    PLOT_SIZE(50000031L);

    private final Long displayValue;
    @Override
    public Long getDisplayValue() {
        return this.displayValue;
    }
}
