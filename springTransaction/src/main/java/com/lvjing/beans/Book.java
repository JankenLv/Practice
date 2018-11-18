package com.lvjing.beans;

import java.util.Date;

public class Book {

    private String isbn;    // 书籍国际编码
    private String name;    // 书籍名称
    private Float  price;    // 书籍价格
    private Date   pubdate;   // 书籍出版日期

    @Override
    public String toString() {
        return "[ Book: " + isbn + " " + name + " " + price + " " + pubdate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }
}
