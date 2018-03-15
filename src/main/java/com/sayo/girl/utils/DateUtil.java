package com.sayo.girl.utils;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Shuangyao
 * 0:09 2018/2/2
 */
public class DateUtil {

//    @Bean
//    public Converter<String, Date> addNewConvert() {
//        return new Converter<String, Date>() {
//            @Override
//            public Date convert(String source) {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                Date date = null;
//                try {
//                    date = sdf.parse((String) source);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                return date;
//            }
//        };
//    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder, WebRequest request) {
//
//        //转换日期
//        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        // CustomDateEditor为自定义日期编辑器
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//    }
}
