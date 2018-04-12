package com.springbootmybatis.demo.controller;

import com.springbootmybatis.demo.entity.Gys;
import com.springbootmybatis.demo.exceptiion.MyException;
import com.springbootmybatis.demo.service.GysServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/testboot")
public class TestBootController {

    @RequestMapping("/getgys")
    public Gys getUser() {
        Gys user = new Gys();
        user.setRoleName("test");
        return user;
    }

    @Autowired
    private GysServiceImpl gysService;
    @RequestMapping("/getlist")
    public List<Gys> getlist() {
        List<Gys> list=null;
       try {
        list=gysService.getGysList();
       }catch (Exception e){
           e.printStackTrace();
       }
        return list;
    }


    @ResponseBody
    @RequestMapping("/testException")
    public Map<String,Object> testException() throws Exception {
        boolean a=false;
        if(a){
            return new HashMap<String, Object>();
        }else{
            int c=0;
            int v=5/c;
            return null;
            //throw new  Exception("测试一个异常");
        }
    }
    @ResponseBody
    @RequestMapping("/testMyException")
    public Map<String,Object> testMyException() throws Exception {
        boolean a=false;
        if(a){
            return new HashMap<String, Object>();
        }else{
            throw new MyException(3,"测试一个自定义异常");
        }
    }
}
