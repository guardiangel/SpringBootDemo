package com.felix.springbootdemo.exceptions;


import com.felix.springbootdemo.constants.ErrorCodeEnums;

/**
 * Custom exception
 */
public class CustomException extends RuntimeException {
    private String code;

    private String message;

    public CustomException(ErrorCodeEnums errorCodeConstants) {
        this.code = errorCodeConstants.getCode();
        this.message = errorCodeConstants.getMessage();
    }

    public CustomException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
