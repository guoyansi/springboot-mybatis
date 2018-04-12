package com.springbootmybatis.demo.service;

import com.springbootmybatis.demo.dao.IGysDao;
import com.springbootmybatis.demo.entity.Gys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("gysService")
public class GysServiceImpl {
    @Autowired
    private IGysDao iGysDao;

    public List<Gys> getGysList() throws  Exception{
        return  iGysDao.getUserList();
    }
}
