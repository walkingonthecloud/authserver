package com.pilogix.authserver.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    public static String encode(String input) {
        return Base64.getEncoder().encodeToString(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }
}


