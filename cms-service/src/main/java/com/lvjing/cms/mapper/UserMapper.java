package com.lvjing.cms.mapper;


import com.lvjing.cms.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

/**
 * 操作用户信息的映射器接口
 */
public interface UserMapper {


    /**
     * 查询用户
     * @param user 查询信息
     * @return 用户信息
     */
    @SelectProvider(type = BuildSQL.class,method = "findUser")
    @SelectKey(resultType = int.class,keyColumn = "id",before = false,keyProperty = "id",statement = "select LAST_INSERT_ID()")
    User findUser(User user);

    /**
     * 新用户注册
     * @param user 注册信息
     * @return 0-注册失败；1-注册成功
     */
    @Insert("insert into mytest.user(name,password,createTime,status)" +
            "values(#{name},#{password},#{createTime},#{status})")
    @SelectKey(resultType = int.class,keyColumn = "id",before = false,keyProperty = "id",statement = "select LAST_INSERT_ID()")
    int register(User user);

    /**
     * 刷新用户登录时间
     * @param id 用户id
     * @param loginTime 登陆时间
     */
    @Update("update mytest.user set updateTime = #{loginTime} where id = #{id}")
    void refreshUserStatus(@Param("id") int id, @Param("loginTime")Date loginTime);


    class BuildSQL{

        public static String findUser(final User user) {
            return new SQL(){{
                SELECT("*");
                FROM("mytest.user");
                if (user.getName() != null && !(user.getName().equals(""))) {
                    WHERE("name = #{name}");
                }
                if (user.getPassword() != null && user.getPassword() !=0) {
                    WHERE("password = #{password}");
                }
            }}.toString();
        }

    }

}
