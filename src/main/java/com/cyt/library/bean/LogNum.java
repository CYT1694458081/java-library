package com.cyt.library.bean;

public class LogNum {
    private int user_id;
    private String user_name;
    private int borrowLog_num;
    private int backLog_num;

    public LogNum( int user_id, String user_name, int borrowLog_num, int backLog_num) {

        this.user_id = user_id;
        this.user_name = user_name;
        this.borrowLog_num = borrowLog_num;
        this.backLog_num = backLog_num;
    }

    @Override
    public String toString() {
        return "LogNum{" +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", borrowLog_num=" + borrowLog_num +
                ", backLog_num=" + backLog_num +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getBorrowLog_num() {
        return borrowLog_num;
    }

    public void setBorrowLog_num(int borrowLog_num) {
        this.borrowLog_num = borrowLog_num;
    }

    public int getBackLog_num() {
        return backLog_num;
    }

    public void setBackLog_num(int backLog_num) {
        this.backLog_num = backLog_num;
    }
}
