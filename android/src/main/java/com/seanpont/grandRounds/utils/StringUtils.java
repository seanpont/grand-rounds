package com.seanpont.grandRounds.utils;

import java.util.regex.Pattern;

public class StringUtils {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");

    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches() && !email.startsWith(".");
    }
}
