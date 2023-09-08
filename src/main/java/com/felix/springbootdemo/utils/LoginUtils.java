package com.felix.springbootdemo.utils;

import cn.hutool.crypto.SecureUtil;

import java.util.UUID;

public final class LoginUtils {
    public static String getLoginToken() {
        return (UUID.randomUUID().toString()
                + Math.random()).replace("-", "")
                .replace(".", "");
    }
    public static void main(String[] args){
        System.out.println(SecureUtil.md5("123456"));
    }
}
