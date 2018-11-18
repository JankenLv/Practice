package com.lvjing.cms.dao;

import com.lvjing.cms.entity.Category;
import com.lvjing.cms.mapper.CategoryMapper;
import com.lvjing.cms.util.JDBCUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CategoryDao {

    private SqlSession sqlSession;
    private int result;
    private List<Category> categoryList;

    private SqlSession getSqlSession() {
        sqlSession = JDBCUtil.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    private void closeSqlSession() {
        if (sqlSession!=null) {
            sqlSession.close();
        }
        sqlSession = null;
    }

    private CategoryMapper getCategoryMapper() {
        return getSqlSession().getMapper(CategoryMapper.class);
    }

    /**
     * 获取所有油画分类
     *
     * @return 所有油画分类的集合
     */
    public List<Category> getAllCategories() {
        try {
            categoryList = getCategoryMapper().getAllCategories();
        } finally {
            closeSqlSession();
        }
        return categoryList;
    }

    /**
     * 获取所有油画分类的id和名称
     *
     * @return 所有油画分类的集合
     */
    public List<Category> getCategoryNameAndId() {
        try {
            categoryList = getCategoryMapper().getCategoryNameAndId();
        } finally {
            closeSqlSession();
        }
        return categoryList;
    }

    /**
     * 根据id获取油画分类
     *
     * @param id 分类id
     * @return 油画分类
     */
    public Category getCategoryById(int id) {
        Category category;
        try {
            category = getCategoryMapper().getCategoryById(id);
        } finally {
            closeSqlSession();
        }
        return category;
    }

    /**
     * 添加油画分类
     *
     * @param category 油画分类信息
     * @return 封装了新增分类的id的实体类
     */
    public Category addCategory(Category category) {
        try {
            result = getCategoryMapper().addCategory(category);
            if (result != 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } finally {
            closeSqlSession();
        }
        return category;
    }

    /**
     * 修改油画分类信息
     *
     * @param category 油画分类信息
     * @return 封装了新增分类的id的实体类
     */
    public Category updateCategory(Category category) {
        try {
            result = getCategoryMapper().updateCategory(category);
            if (result != 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } finally {
            closeSqlSession();
        }
        return category;
    }

    /**
     * 根据id删除油画分类
     *
     * @param id 油画id
     */
    public int delCategory(int id) {
        try {
            id = getCategoryMapper().delCategory(id);
            if (id != 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } finally {
            closeSqlSession();
        }
        return id;
    }

}
