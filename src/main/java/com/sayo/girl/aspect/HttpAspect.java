package com.sayo.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Shuangyao
 * 23:54 2018/1/3
 */

@Aspect
@Component
public class HttpAspect {

    private final static    Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.sayo.girl.controller.GirlController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURI());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getDeclaringTypeName());
        //类参数
        logger.info("class_parmas={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("after http");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturn(Object object){
//        logger.error("return={}", object.toString());
    }
}
