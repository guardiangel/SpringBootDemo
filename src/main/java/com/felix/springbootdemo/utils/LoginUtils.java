package com.felix.springbootdemo.utils;

import java.util.UUID;

public final class LoginUtils {
    public static String getLoginToken() {
        return (UUID.randomUUID().toString()
                + Math.random()).replace("-", "")
                .replace(".", "");
    }
}
