package com.sayo.girl.domain;

/**
 * http request result
 * Created by Shuangyao
 * 23:15 2018/1/4
 */
public class RequestResult<T> {
    // error code
    private Integer code;
    // message
    private  String message;
    //return json
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
