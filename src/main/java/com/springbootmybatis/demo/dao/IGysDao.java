package com.springbootmybatis.demo.dao;

import com.springbootmybatis.demo.entity.Gys;

import java.util.List;

public interface IGysDao {
    List<Gys> getUserList() throws  Exception;
}
