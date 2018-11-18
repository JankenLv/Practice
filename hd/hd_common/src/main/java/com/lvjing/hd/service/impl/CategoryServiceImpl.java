package com.lvjing.hd.service.impl;

import com.lvjing.hd.dao.CategoryDao;
import com.lvjing.hd.entity.Category;
import com.lvjing.hd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public void add(Category category) {
        category.setCreateTime(new Date());
        category.setUpdateTime(new Date());
        categoryDao.insert(category);
    }

    public void remove(Integer id) {
        categoryDao.delete(id);
    }

    public void modify(Category category) {
        categoryDao.update(category);
    }

    public Category get(Category category) {
        return categoryDao.selectOne(category);
    }

    public List<Category> getAll() {
        return categoryDao.selectAll();
    }
}
