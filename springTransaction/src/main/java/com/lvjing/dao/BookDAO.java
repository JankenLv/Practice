package com.lvjing.dao;

import com.lvjing.beans.Book;

public interface BookDAO {

    void findBook(Book book);
    void addBook(Book book);
    void updateBook(Book book);
    void delBook(int id);

}
