package com.zopa.models;

import org.apache.commons.lang3.RandomUtils;
import org.joda.time.LocalDate;


public class Address {
    public String postcode;
    public String fullAddress;
    public LocalDate dateMovedIn;

    public Address() {
        postcode = "SE10 8EW";
        fullAddress = "1 HATFIELD HOUSE 5 MERRYWEATHER PLACE  SE108EW  LONDON ";
        int daysToMinus = RandomUtils.nextInt(1000, 1700);
        dateMovedIn = LocalDate.now().minusDays(daysToMinus);
    }
}
