package com.lvjing.service;

import com.lvjing.beans.Book;
import com.lvjing.dao.BookDAO;

/**
 * POJO服务类
 */
public class BookService implements BookDAO {

    public void findBook(Book book) {
        System.out.println("find book " + book);
    }

    public void addBook(Book book) {
        System.out.println("add book " + book);
    }

    public void updateBook(Book book) {
        System.out.println("update book " + book);
    }

    public void delBook(int id) {
        System.out.println("delete book " + id);
    }
}
