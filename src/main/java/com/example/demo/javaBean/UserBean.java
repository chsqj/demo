package com.example.demo.javaBean;

import org.apache.catalina.User;

public class UserBean {
    private int id;
    private String userName;
    private String password;

    public UserBean() {

    }

    public UserBean(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        UserBean userBean = (UserBean) obj;
        return this.userName.equals(userBean.getUserName()) && this.password.equals(userBean.getPassword());
    }
}
