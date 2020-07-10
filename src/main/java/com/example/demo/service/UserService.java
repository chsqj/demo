package com.example.demo.service;

import com.example.demo.javaBean.UserBean;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private Set<UserBean> users = new HashSet<>();

    public void initData() {
        users.add(new UserBean(1,"root", "root"));
        users.add(new UserBean(2, "admin", "admin"));
    }

    public boolean checkUser(UserBean userBean) {
        for(UserBean user : users) {
            if(user.equals(userBean)) return true;
        }
        return false;
    }
}
