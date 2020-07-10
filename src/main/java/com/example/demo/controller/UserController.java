package com.example.demo.controller;

import com.example.demo.javaBean.UserBean;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/checkUser")
    public String login(UserBean user, ModelMap map) {
        userService.initData();
        if(userService.checkUser(user)) {
            return "manager";
        }else {
            map.addAttribute("msg", "用户名密码错误");
            return "login";
        }
    }
}
