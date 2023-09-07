package com.felix.springbootdemo.utils;

import java.io.Serializable;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Transient;
import org.springframework.util.StringUtils;


@ApiModel("Wrap data class")
public class JSONResult<T> implements Serializable {
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setShowMessage(boolean showMessage) {
        this.showMessage = showMessage;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof JSONResult other)) {
            return false;
        }
        if (!other.canEqual(this)) {
            return false;
        }
        if (isSuccess() != other.isSuccess()) {
            return false;
        }
        Object thisObject = getMessage();
        Object otherObject = other.getMessage();
        if (!Objects.equals(thisObject, otherObject)) {
            return false;
        }
        Object thisCode = getCode();
        Object otherCode = other.getCode();
        if (!Objects.equals(thisCode, otherCode)) {
            return false;
        }
        if (isShowMessage() != other.isShowMessage()) {
            return false;
        }
        Object thisData = getData();
        Object otherData = other.getData();
        return Objects.equals(thisData, otherData);
    }

    protected boolean canEqual(Object other) {
        return other instanceof JSONResult;
    }

    public int hashCode() {
        int result = 1;
        result = result * 59 + (isSuccess() ? 79 : 97);
        Object messageForhash = getMessage();
        result = result * 59 + ((messageForhash == null) ? 43 : messageForhash.hashCode());
        Object codeForhash = getCode();
        result = result * 59 + ((codeForhash == null) ? 43 : codeForhash.hashCode());
        result = result * 59 + (isShowMessage() ? 79 : 97);
        Object dataForHash = getData();
        return result * 59 + ((dataForHash == null) ? 43 : dataForHash.hashCode());
    }

    public String toString() {
        return "JSONResult(success=" + isSuccess() + ", " +
                "message=" + getMessage() + ", code=" + getCode() + ", " +
                "showMessage=" + isShowMessage() + ", data=" + getData() + ")";
    }

    @ApiModelProperty("Response status（true:success;false:failure;）")
    private boolean success = true;

    public boolean isSuccess() {
        return this.success;
    }

    @ApiModelProperty("description")
    private String message = "Operate successfully";

    public String getMessage() {
        return this.message;
    }

    @ApiModelProperty("status")
    private String code = "0000";

    public String getCode() {
        return this.code;
    }

    @ApiModelProperty("Show prompt message")
    private boolean showMessage = false;

    public boolean isShowMessage() {
        return this.showMessage;
    }

    @ApiModelProperty("Responsive data")
    @Transient
    private T data;

    public T getData() {
        return this.data;
    }

    public JSONResult<T> success() {
        return new JSONResult<>();
    }


    public JSONResult<T> success(boolean showMessage) {
        JSONResult instance = new JSONResult<>();
        instance.setShowMessage(showMessage);
        return instance;
    }

    public JSONResult<T> success(Object obj) {
        JSONResult instance = new JSONResult<>();
        instance.setData(obj);
        return instance;
    }

    public JSONResult<T> success(T obj, boolean showMessage) {
        JSONResult<T> instance = new JSONResult<>();
        instance.setData(obj);
        instance.setShowMessage(showMessage);
        return instance;
    }

    public JSONResult<T> success(T obj, String code) {
        JSONResult<T> instance = new JSONResult<>();
        instance.setSuccess(true);
        instance.setCode(code);
        instance.setData(obj);
        return instance;
    }

    public JSONResult<T> success(String code, String message) {
        JSONResult<T> instance = new JSONResult();
        instance.setSuccess(true);
        instance.setCode(code);
        instance.setMessage(message);
        return instance;
    }

    public JSONResult<T> error() {
        JSONResult instance = new JSONResult<>();
        instance.setCode("9999");
        instance.setSuccess(false);
        instance.setMessage("System exception, please try again later.");
        return instance;
    }

    public JSONResult<T> error(String message) {
        JSONResult<T> instance = new JSONResult<>();
        instance.setCode("9999");
        instance.setSuccess(false);
        instance.setMessage(message);
        return instance;
    }

    public JSONResult<T> error(String message, T obj) {
        JSONResult<T> instance = new JSONResult<>();
        instance.setCode("9999");
        instance.setMessage(message);
        instance.setSuccess(false);
        instance.setData(obj);
        return instance;
    }

    public boolean hasLength(String str) {
        return StringUtils.hasLength(str);
    }

    public JSONResult<T> error(String code, String message) {
        JSONResult<T> instance = new JSONResult<>();
        instance.setCode(hasLength(code) ? code : "9999");
        instance.setMessage(message);
        instance.setSuccess(false);
        return instance;
    }
}
