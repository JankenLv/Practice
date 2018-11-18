package com.lvjing.entity;

public class Books {
    private String id;
    private String bookName;
    public String price;

    public Books(){};

    public Books(String id, String bookName, String price){
        this.id = id;
        this.bookName = bookName;
        this.price = price;
    };

    @Override
    public String toString() {
        return "Books{" +
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
