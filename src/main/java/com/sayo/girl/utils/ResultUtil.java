package com.sayo.girl.utils;

import com.sayo.girl.domain.RequestResult;

/**
 * Created by Shuangyao
 * 21:35 2018/1/6
 */
public class ResultUtil {

    //request successful with data result
    public static RequestResult success(Object object){
        RequestResult result = new RequestResult();
        result.setCode(200);
        result.setMessage("success");
        result.setData(object);

        return result;
    }

    //request successful without data result
    public static RequestResult success(){
        return success(null);
    }

    //request fail
    public static RequestResult error(Integer code, String msg){
        RequestResult result = new RequestResult();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(null);

        return result;
    }
}
