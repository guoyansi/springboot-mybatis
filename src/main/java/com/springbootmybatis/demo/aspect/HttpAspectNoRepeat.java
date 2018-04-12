package com.springbootmybatis.demo.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Aop基本示例，去除重复的拦截配置
 */
@Aspect
@Component
public class HttpAspectNoRepeat {

    private  final static Logger logger= LoggerFactory.getLogger(HttpAspectNoRepeat.class);

    @Pointcut("execution(public * com.springbootmybatis.demo.controller.TestBootController.getUser(..))")
    public void aopOne(){

    }
    @Pointcut("execution(public * com.springbootmybatis.demo.controller.TestBootController.*(..))")
    public void aopAll(){

    }
    /**
     * 方法执行之前，拦截单个方法
     */
    @Before("aopOne()")
    public void  aopOneBeforeMethod(){
        logger.info("去除重复配置后的单个方法拦截-->前-->logger");
    }
    /**
     * 方法执行之前，拦截所有的方法
     */
    @Before("aopAll()")
    public void  aopAllBeforeMethod(){
        System.out.println("去除重复配置后的所有方法拦截-->前");
    }

    /**
     * 方法执行之后，拦截单个方法
     */
    @After("aopOne()")
    public void  aopOneAfterMethod(){
        System.out.println("去除重复配置后的单个方法拦截-->后");
    }
    /**
     * 方法执行之前，拦截所有的方法
     */
    @After("aopAll()")
    public void  aopAllAfterMethod(){
        System.out.println("去除重复配置后的所有方法拦截-->后");
    }

    @AfterReturning(returning = "object",pointcut = "aopOne()")
    public void getReturnFromMethod(Object object){
        logger.info("返回值：{}",object);
    }
}
