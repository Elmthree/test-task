package com.zopa.models;

import org.apache.commons.lang3.RandomUtils;

public enum EmploymentStatus {
    EMPLOYED_FULL_TIME,
    SELF_EMPLOYED,
    OWNER_OR_PARTNER,
    EMPLOYED_PART_TIME,
    UNEMPLOYED,
    RETIRED,
    HOMEMAKER;

    public static EmploymentStatus getRandom() {
        int index = RandomUtils.nextInt(0, EmploymentStatus.values().length - 1);
        return EmploymentStatus.values()[index];
    }
}
