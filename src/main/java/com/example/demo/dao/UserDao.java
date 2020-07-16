package com.example.demo.dao;

import com.example.demo.javaBean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface UserDao {
    public UserBean findUser(String username);
}
