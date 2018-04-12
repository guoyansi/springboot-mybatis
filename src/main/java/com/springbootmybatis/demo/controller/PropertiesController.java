package com.springbootmybatis.demo.controller;

import com.springbootmybatis.demo.entity.MyConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试读取配置信息的controller
 */
@RestController
public class PropertiesController {
    @Value("${myconfig}")
    private String myconfig;

    @Value("${age}")
    private String age;

    @Value("${content}")
    private String content;



    //@RequestMapping("/hello")
    @RequestMapping(value={"/hello","hi"})
    public String say(){
        String str="hello spring boot》》》》"+myconfig+";age:"+age;
        str+="====";
        str+=content;
        return str;
    }

    @Autowired
    private MyConfigProperties cof;

    @RequestMapping("/conf")
    public MyConfigProperties getConfig(){
        return cof;
    }
}
