package com.sayo.girl.enums;

/**
 * Created by Shuangyao
 * 0:23 2018/1/7
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1, "unknow error"),
    SUCCESS(200, "success"),
    PRIMARY_STUDENT(100, "You maybe a primary student."),
    SENIOR_STUDENT(101, "You maybe a senior student."),
    ADULT(102, "You are an adult."),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String msg){
        this.code = code;
        this.message = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
