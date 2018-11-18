package com.lvjing.cms.dao;

import com.lvjing.cms.entity.User;
import com.lvjing.cms.mapper.UserMapper;
import com.lvjing.cms.util.JDBCUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class UserDao {

    private SqlSession sqlSession;

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

    private UserMapper getUserMapper() {
        return getSqlSession().getMapper(UserMapper.class);
    }


    /**
     * 查找用户
     * @param user 查找信息
     * @return 用户信息
     */
    public User findUser(User user) {
        try {
            user = getUserMapper().findUser(user);
            if (user!=null) {
                if (user.getName()!=null&&user.getPassword()!=null) {
                    refreshUserStatus(user.getId(),new Date());
                }
            }
        } finally {
            closeSqlSession();
        }
        return user;
    }


    /**
     * 新用户注册
     * @param user 注册信息
     * @return 0-注册失败；1-注册成功
     */
    public int register(User user) {
        int result;
        try {
            result = getUserMapper().register(user);
            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } finally {
            closeSqlSession();
        }
        return result;
    }


    /**
     * 刷新用户登录状态
     * @param id 用户id
     * @param loginTime 登陆时间
     */
    private void refreshUserStatus(int id, Date loginTime) {
        try {
            getUserMapper().refreshUserStatus(id,loginTime);
            sqlSession.commit();
        } finally {
            closeSqlSession();
        }
    }


}
