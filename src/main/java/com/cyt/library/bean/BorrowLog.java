package com.cyt.library.bean;

import java.sql.Timestamp;
import java.util.Date;

public class BorrowLog {
    private int borrow_id;
    private int user_id;
    private int book_id;
    private String borrow_date;

    public BorrowLog(int borrow_id, int user_id, int book_id, String borrow_date) {
        this.borrow_id = borrow_id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.borrow_date = borrow_date;
    }
    public int getborrow_id() {
        return borrow_id;
    }

    public void setborrow_id(int borrow_id) {
        this.borrow_id = borrow_id;
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

    public String getborrow_date() {
        return borrow_date;
    }

    public void setborrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    @Override
    public String toString() {
        return "BorrowLog{" +
                "borrow_id=" + borrow_id +
                ", user_id=" + user_id +
                ", book_id=" + book_id +
                ", borrow_date=" + borrow_date +
                '}';
    }
}
