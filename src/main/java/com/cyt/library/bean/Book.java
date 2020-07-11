package com.cyt.library.bean;

public class Book {
    private int book_id;
    private String name;
    private String content;
    private String type;
    private int num;

    public Book(int book_id, String name, String content, String type, int num) {
        this.book_id = book_id;
        this.name = name;
        this.content = content;
        this.type = type;
        this.num = num;
    }

    public int getbook_id() {
        return book_id;
    }

    public void setbook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", num=" + num +
                '}';
    }
}
