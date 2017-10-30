package com.zopa.models;

import org.apache.commons.lang3.RandomUtils;

public enum Reason {
    CAR,
    HOME_IMPROVEMENTS,
    CONSOLIDATE;

    public static Reason getRandom() {
        int index = RandomUtils.nextInt(0, Reason.values().length - 1);
        return Reason.values()[index];
    }
}
