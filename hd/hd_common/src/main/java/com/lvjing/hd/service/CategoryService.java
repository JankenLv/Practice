package com.lvjing.hd.service;

import com.lvjing.hd.entity.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);

    void remove(Integer id);

    void modify(Category category);

    Category get(Category category);

    List<Category> getAll();
}
