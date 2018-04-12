package com.springbootmybatis.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Aop基本示例
 */
@Aspect
@Component
public class HttpAspect {
    private  final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);


    /**
     * 方法执行之前，拦截单个方法
     */
    @Before("execution(public * com.springbootmybatis.demo.controller.TestBootController.getUser(..))")
    public void  aopOneBeforeMethod(JoinPoint joinpoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName()+"."+joinpoint.getSignature().getName());
        //参数
        logger.info("args={}",joinpoint.getArgs());
        System.out.println("请求了getUser方法-->前");
    }
    /**
     * 方法执行之前，拦截所有的方法
     */
    @Before("execution(public * com.springbootmybatis.demo.controller.TestBootController.*(..))")
    public void  aopAllBeforeMethod(){
        System.out.println("执行了所有的方法拦截-->前");
    }

    /**
     * 方法执行之后，拦截单个方法
     */
    @After("execution(public * com.springbootmybatis.demo.controller.TestBootController.getUser(..))")
    public void  aopOneAfterMethod(){
        System.out.println("请求了getUser方法-->后");
    }
    /**
     * 方法执行之前，拦截所有的方法
     */
    @After("execution(public * com.springbootmybatis.demo.controller.TestBootController.*(..))")
    public void  aopAllAfterMethod(){
        System.out.println("执行了所有的方法拦截-->后");
    }

}
