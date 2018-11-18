package com.lvjing.bm.service;

import com.lvjing.bm.entity.Book;

import java.util.List;

public interface BookService {
    void add(List<Book> bookList);

    void remove(Integer id);

    void modify(Book book);

    Book getById(Integer id);

    List<Book> getByCatId(Integer id);

    List<Book> getAll();

}
