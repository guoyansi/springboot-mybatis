package com.springbootmybatis.demo.exceptiion;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理类
 */
@ControllerAdvice
public class ExceptionHandle {
    private  final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    /**
     * 处理返回的Exception类型的异常
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> handler(Exception e){
        Map<String,Object> map=new HashMap<String, Object>();
        if(e instanceof MyException){//自定义异常
            MyException me=(MyException)e;
            map.put("status",me.getStatus());
            map.put("msg",e.getMessage());
        }else{
            //logger.error("系统异常：{}",e);
            map.put("status",2);
            map.put("msg","程序异常");
        }
        return map;
    }
}
