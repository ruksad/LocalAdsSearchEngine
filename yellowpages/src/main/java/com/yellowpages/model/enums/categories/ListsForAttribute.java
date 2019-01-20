package com.yellowpages.model.enums.categories;


import lombok.AllArgsConstructor;

/**
 * Created by Ruksad siddiqui on 11/3/18
 */
@AllArgsConstructor
public enum ListsForAttribute implements PostAdRule {
    COLOUR(50000005L),
    TRANSMISSION(50000006L),
    YEAR(50000008L),
    GENDER(50000017L),
    CONDITION(50000009L),
    FUEL(50000007L),
    BED_ROOMS(50000027L),
    CAR_PARKING(50000030L),
    FURNISHING(50000032L),
    MEALS(50000033L),
    FACING(50000036L);

    private final Long displayValue;
    @Override
    public Long getDisplayValue() {
        return this.displayValue;
    }
}
