package com.lvjing.cms.service;

import com.lvjing.cms.dao.CategoryDao;
import com.lvjing.cms.entity.Category;

import java.util.List;

public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();
    private static CategoryService categoryService;

    private CategoryService() {
    }

    public static CategoryService getInstance() {
        if (categoryService == null) {
            categoryService = new CategoryService();
        }
        return categoryService;
    }

    /**
     * 获取所有油画分类
     *
     * @return 所有油画分类的集合
     */
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    /**
     * 根据id获取油画分类
     *
     * @param id 分类id
     * @return 油画分类
     */
    public Category getCategoryById(int id) {
        return categoryDao.getCategoryById(id);
    }

    /**
     * 获取所有油画分类的id和名称
     *
     * @return 所有油画分类的集合
     */
    public List<Category> getCategoryNameAndId() {
        return categoryDao.getCategoryNameAndId();
    }

    /**
     * 添加油画分类
     *
     * @param category 油画分类信息
     * @return 封装了新增分类的id的实体类
     */
    public Category addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    /**
     * 修改油画分类信息
     *
     * @param category 油画分类信息
     * @return 封装了新增分类的id的实体类
     */
    public Category updateCategory(Category category) {
        return categoryDao.updateCategory(category);
    }

    /**
     * 根据id删除油画分类
     *
     * @param id 油画id
     */
    public int delCategory(int id) {
        return categoryDao.delCategory(id);
    }

}
