package com.sayo.girl.handle;

import com.sayo.girl.domain.RequestResult;
import com.sayo.girl.exception.GirlException;
import com.sayo.girl.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Shuangyao
 * 22:54 2018/1/6
 */

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RequestResult handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            String msg = girlException.getMessage();
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }else {
            return ResultUtil.error(202, e.getMessage());
        }
    }
}
