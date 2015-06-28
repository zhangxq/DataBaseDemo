package com.database.zhangxq.databasedemo.model;

import com.orm.SugarRecord;

/**
 * Created by zhangxq on 2015/6/14.
 */
public class User extends SugarRecord<User> {
    private String userName;
    private String password;
    private String phone;

    public User() {
    }

    public User(String userName, String password, String phone) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
