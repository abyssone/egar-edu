package com.absdev.util;

public class Validator {
    public static boolean isNumericString(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean isNullOrEmptyString(String string) {
        if (string == null || string.trim().isEmpty()) return true;
        return false;
    }
}
