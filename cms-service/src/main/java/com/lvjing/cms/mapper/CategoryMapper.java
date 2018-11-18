package com.lvjing.cms.mapper;

import com.lvjing.cms.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 油画分类的映射器接口
 */
public interface CategoryMapper {

    /**
     * 获取所有油画分类
     * @return 所有油画分类的集合
     */
    @Select("select * from mytest.category order by createTime asc ")
    List<Category> getAllCategories();

    /**
     * 获取所有油画分类的id和名称
     * @return 所有油画分类的集合
     */
    @Select("select id,name from mytest.category")
    List<Category> getCategoryNameAndId();

    /**
     * 添加油画分类
     * @param category 油画分类信息
     * @return 封装了新增分类的id的实体类
     */
    @Insert("insert into mytest.category(name, createName, createTime, description)" +
            "values(#{name},#{createName},#{createTime},#{description} )")
    @SelectKey(resultType = int.class,keyColumn = "id",before = false,keyProperty = "id",statement = "select LAST_INSERT_ID()")
    int addCategory(Category category);

    /**
     * 根据id获取油画分类
     * @param id 分类id
     * @return 油画分类
     */
    @Select("select * from mytest.category where id = #{id}")
    Category getCategoryById(int id);

    /**
     * 修改油画分类信息
     * @param category 油画分类信息
     * @return 封装了新增分类的id的实体类
     */
    @Update("update mytest.category set name = #{name}, createName = #{createName}," +
            "description = #{description} where id = #{id}")
    @SelectKey(resultType = int.class,keyColumn = "id",before = false,keyProperty = "id",statement = "select LAST_INSERT_ID()")
    int updateCategory(Category category);

    /**
     * 根据id删除油画分类
     * @param id 油画id
     */
    @Delete("delete from mytest.category where id = #{id}")
    int delCategory(int id);

}
