package com.zopa.models;


import org.apache.commons.lang3.RandomUtils;

public enum OwnAHome {
    OWNER_NO_MORTGAGE,
    OWNER_WITH_MORTGAGE,
    OTHER;

    public static OwnAHome getRandom() {
        int index = RandomUtils.nextInt(0, OwnAHome.values().length - 1);
        return OwnAHome.values()[index];
    }
}
