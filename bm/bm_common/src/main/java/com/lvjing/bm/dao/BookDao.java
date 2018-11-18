package com.lvjing.bm.dao;

import com.lvjing.bm.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookDao")
public interface BookDao {
    void insert(Book book);

    void delete(Integer id);

    void update(Book book);

    Book selectById(Integer id);

    List<Book> selectByCatId(Integer id);

    List<Book> selectAll();

}
