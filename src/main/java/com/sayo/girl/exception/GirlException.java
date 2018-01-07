package com.sayo.girl.exception;

import com.sayo.girl.enums.ResultEnum;

import javax.management.RuntimeMBeanException;

/**
 * Created by Shuangyao
 * 23:57 2018/1/6
 */
public class GirlException extends RuntimeException {
    // exception code
    private Integer code;
    // exception msg
    private String message;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
