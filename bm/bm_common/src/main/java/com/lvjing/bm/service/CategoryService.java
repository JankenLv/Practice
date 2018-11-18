package com.lvjing.bm.service;

import com.lvjing.bm.entity.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);

    void remove(Integer id);

    void modify(Category category);

    Category getById(Integer id);

    List<Category> getAll();
}
