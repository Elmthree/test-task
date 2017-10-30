package com.zopa.models;

import org.apache.commons.lang3.RandomUtils;

public enum Title {
    Mr,
    Ms,
    Mrs,
    Miss;

    public static Title getRandom() {
        int index = RandomUtils.nextInt(0, Title.values().length - 1);
        return Title.values()[index];
    }
}
