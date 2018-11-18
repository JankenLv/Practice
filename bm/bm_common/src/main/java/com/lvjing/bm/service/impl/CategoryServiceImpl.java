package com.lvjing.bm.service.impl;

import com.lvjing.bm.dao.CategoryDao;
import com.lvjing.bm.entity.Category;
import com.lvjing.bm.service.CategoryService;
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

    public Category getById(Integer id) {
        return categoryDao.selectById(id);
    }

    public List<Category> getAll() {
        return categoryDao.selectAll();
    }
}
