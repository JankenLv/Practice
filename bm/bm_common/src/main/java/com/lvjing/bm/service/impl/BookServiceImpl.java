package com.lvjing.bm.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lvjing.bm.dao.BookDao;
import com.lvjing.bm.entity.Book;
import com.lvjing.bm.service.BookService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private SqlSession sqlSession;

    public void add(List<Book> bookList) {
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        for (Book book : bookList) {
            book.setCreateTime(new Date());
            book.setUpdateTime(new Date());
            mapper.insert(book);
        }
    }

    public void remove(Integer id) {
        bookDao.delete(id);
    }

    public void modify(Book book) {
        bookDao.update(book);
    }

    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    public List<Book> getByCatId(Integer id) {
        return bookDao.selectByCatId(id);
    }

    public List<Book> getAll() {
        return bookDao.selectAll();
    }
}
