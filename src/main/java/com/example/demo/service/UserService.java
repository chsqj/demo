package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.javaBean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean checkUser(UserBean userBean) {
        UserBean user = userDao.findUser(userBean.getUserName());
        if(user == null) return false;
        return user.getPassword().equals(userBean.getPassword());
    }
}
