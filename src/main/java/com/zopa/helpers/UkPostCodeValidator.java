package com.zopa.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UkPostCodeValidator {

    // Got the Government's supplied regex for validating UK post codes from https://en.wikipedia.org/wiki/Postcodes_in_the_United_Kingdom#Validation

    private static String regex = "^([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9]?[A-Za-z])))) [0-9][A-Za-z]{2})$";
    private static Pattern pattern = Pattern.compile(regex);

    public static boolean isValid(String postCode) {
        Matcher matcher = pattern.matcher(postCode);
        return matcher.matches();
    }

}
