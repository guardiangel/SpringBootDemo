package com.felix.springbootdemo.constants;

public enum ErrorCodeEnums {
    SYSTEM_SUCCESS("0000", "Operate successfully！"),

    ERROR_CODE_1000("1000", "The input object is null"),
    ERROR_CODE_1001("1001", "Operate failed, try later."),
    ERROR_CODE_1002("1002", "Invalid auth status, please login again."),
    ERROR_CODE_1003("1003", "Account can't be null！"),
    ERROR_CODE_1004("1004", "Password can't be null！"),
    ERROR_CODE_1005("1005", "Account doesn't exist！"),
    ERROR_CODE_1006("1006", "More than one login account！"),
    ERROR_CODE_1007("1007", "Wrong login password！"),
    ERROR_CODE_1008("1008", "Token error or failure！"),
    ERROR_CODE_1009("1009", "UUID can't be null！"),
    ERROR_CODE_1010("1010", "Image verification code cannot be empty！"),
    ERROR_CODE_1011("1011", "The image verification code has expired, please click on the image to refresh！"),
    ERROR_CODE_1012("1012", "The image verification code is wrong, please re-enter it.！"),

    //Validation error
    ERROR_CODE_5555("5555", "Validation error. Please double check."),


    SYSTEM_ERROR("9999", "The system is out of business, please try again later.！");

    //Error code
    private String code;

    //Error message
    private String message;

    ErrorCodeEnums(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }

}
