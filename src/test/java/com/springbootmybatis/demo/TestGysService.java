package com.springbootmybatis.demo;

import com.springbootmybatis.demo.entity.Gys;
import com.springbootmybatis.demo.service.GysServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * 测试service
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGysService {

    @Autowired
    private GysServiceImpl gysService;

    @Test
    public  void getGysList() throws  Exception{
        List<Gys> list=gysService.getGysList();
        Assert.assertEquals(2,list.size());
    }
}
