package com.lvjing.cms.mapper;

import com.lvjing.cms.entity.Canvas;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * 油画管理后台的映射器接口
 */
public interface CanvasMapper {


    /**
     * 查找油画
     * @param canvas 查找条件
     * @return 存储油画的list集合
     */
    @SelectProvider(type = BuildSQL.class,method = "findCanvas")
    List<Canvas> findCanvas(Canvas canvas);


    /**
     * 查找油画
     * @param firstIndex 查询的起始索引位置
     * @param lastIndex  限制显示的记录数
     * @return 存储油画的list集合
     */
    @Select("select * from mytest.canvas order by createTime asc limit #{firstIndex}, #{lastIndex}")
    List<Canvas> pagingForCanvas(@Param("firstIndex")int firstIndex, @Param("lastIndex")int lastIndex);


    /**
     * 根据分类查找油画
     * @param categoryId  分类id
     * @param firstIndex 查询的起始索引位置
     * @param lastIndex  限制显示的记录数
     * @return 存储油画的list集合
     */
    @Select("select * from mytest.canvas where categoryId = #{categoryId} order by createTime asc limit #{firstIndex}, #{lastIndex}")
    List<Canvas> pagingForCanvasOfCategory(@Param("categoryId")int categoryId,@Param("firstIndex")int firstIndex, @Param("lastIndex")int lastIndex);


    /**
     * 统计油画总数
     * @return 油画总数
     */
    @Select("select COUNT(*) from mytest.canvas")
    int countCanvas();


    /**
     * 统计某一分类下的油画总数
     * @param categoryId 油画分类
     * @return 油画总数
     */
    @Select("select COUNT(*) from mytest.canvas where categoryId = #{categoryId}")
    int countCanvasOfCategory(int categoryId);

    /**
     * 根据id获取油画图片
     * @param id 油画id
     * @return 油画图片
     */
    @Select("select smallImg from mytest.canvas where id = #{id} for update")
    Canvas getSmallImg(int id);

    /**
     * 添加油画
     * @param canvas 封装油画信息的实体类
     * @return  封装新增油画id的实体类
     */
    @Insert("insert into mytest.canvas(categoryId, name, creator, price, smallImg, createTime, description, details)" +
            "values(#{categoryId},#{name},#{creator},#{price},#{smallImg},#{createTime},#{description},#{details})")
    @SelectKey(resultType = int.class,keyColumn = "id",before = false,keyProperty = "id",statement = "select LAST_INSERT_ID()")
    int addCanvas(Canvas canvas);

    /**
     * 更新油画
     * @param canvas 封装油画信息的实体类
     * @return  封装更新油画id的实体类
     */
    @UpdateProvider(type = BuildSQL.class,method = "updateCanvas")
    @SelectKey(resultType = int.class,keyColumn = "id",before = false,keyProperty = "id",statement = "select LAST_INSERT_ID()")
    int updateCanvas(Canvas canvas);

    /**
     * 删除油画
     * @param id 油画id
     */
    @Delete("delete from mytest.canvas where id = #{id}")
    int deleteCanvas(int id);


    /**
     * 创建动态SQL语句的内部类
     */
    class BuildSQL {

        public static String findCanvas(final Canvas canvas) {
            return new SQL(){{
                SELECT("*");
                FROM("mytest.canvas");
                if (canvas.getId() != null) {
                    WHERE("id = #{id}");
                }
                if (canvas.getCategoryId() != null) {
                    WHERE("categoryId = #{categoryId}");
                }
            }}.toString();
        }


        public static String updateCanvas(final Canvas canvas) {
            return new SQL(){{
                UPDATE("mytest.canvas");
                if (canvas.getName()!=null) {
                    SET("name = #{name} ");
                }
                if (canvas.getCategoryId()!=null) {
                    SET("categoryId = #{categoryId} ");
                }
                if (canvas.getCreator()!=null) {
                    SET("creator = #{creator} ");
                }
                if (canvas.getDescription()!=null) {
                    SET("description = #{description}");
                }
                if (canvas.getDetails()!=null) {
                    SET("details = #{details} ");
                }
                if (canvas.getPrice()!=null) {
                    SET(" price = #{price} ");
                }
                if (canvas.getSmallImg()!=null) {
                    SET("smallImg = #{smallImg}");
                }
                WHERE("id = #{id}");
            }}.toString();
        }
    }

}

