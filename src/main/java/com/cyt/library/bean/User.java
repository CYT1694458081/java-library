package com.cyt.library.bean;

import java.sql.Timestamp;

public class User {
    private int user_id;
    private String name;
    private String password;
    private String regtime;
    private String role;
    private int borrow_num;

    public User(int user_id, String name, String password, String regtime, String role, int borrow_num) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.regtime = regtime;
        this.role = role;
        this.borrow_num = borrow_num;
    }

    public int getuser_id() {
        return user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getborrow_num() {
        return borrow_num;
    }

    public void setborrow_num(int borrow_num) {
        this.borrow_num = borrow_num;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", regtime=" + regtime +
                ", role='" + role + '\'' +
                ", borrow_num=" + borrow_num +
                '}';
    }
}
