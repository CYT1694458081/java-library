package com.cyt.library.bean;

import java.sql.Timestamp;
import java.util.Date;

public class BackLog {
    private int back_id;
    private int user_id;
    private int book_id;
    private String back_date;

    public BackLog(BorrowLog borrowLog, String back_date) {
        this.back_id = borrowLog.getborrow_id();
        this.user_id = borrowLog.getuser_id();
        this.book_id = borrowLog.getbook_id();
        this.back_date = back_date;
    }

    public int getback_id() {
        return back_id;
    }

    public void setback_id(int back_id) {
        this.back_id = back_id;
    }

    public int getuser_id() {
        return user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getbook_id() {
        return book_id;
    }

    public void setbook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getback_date() {
        return back_date;
    }

    public void setback_date(String back_date) {
        this.back_date = back_date;
    }

    @Override
    public String toString() {
        return "BackLog{" +
                "back_id=" + back_id +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", back_date=" + back_date +
                '}';
    }
}
