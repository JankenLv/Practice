package com.lvjing.hd.dao;

import com.lvjing.hd.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
public interface CategoryDao {
    void insert(Category category);

    void delete(Integer id);

    void update(Category category);

    Category selectOne(Category category);

    List<Category> selectAll();

}
