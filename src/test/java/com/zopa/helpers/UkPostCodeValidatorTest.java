package com.zopa.helpers;

import org.junit.Test;

import static org.junit.Assert.*;

public class UkPostCodeValidatorTest {

    @Test
    public void validateUKPostCode() {
        // https://en.wikipedia.org/wiki/Postcodes_in_the_United_Kingdom#Validation
        String[] postcodes = {
                "AA9A 9AA",
                "A9A 9AA",
                "A9 9AA",
                "A99 9AA",
                "AA9 9AA",
                "AA99 9AA",
        };

        for (String postCode : postcodes) {
            assertTrue(UkPostCodeValidator.isValid(postCode));
        }
    }

}