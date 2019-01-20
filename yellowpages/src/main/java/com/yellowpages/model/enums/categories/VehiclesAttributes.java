package com.yellowpages.model.enums.categories;

import lombok.AllArgsConstructor;

/**
 * Created by Ruksad siddiqui on 11/3/18
 */
@AllArgsConstructor
public enum VehiclesAttributes implements PostAdRule {
    KM_DRIVEN(50000022l),
    MODEL(50000004l);

    private final Long displayValue;
    @Override
    public Long getDisplayValue() {
        return this.displayValue;
    }
}
