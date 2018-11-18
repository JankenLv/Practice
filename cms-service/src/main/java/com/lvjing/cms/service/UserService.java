package com.lvjing.cms.service;

import com.lvjing.cms.dao.UserDao;
import com.lvjing.cms.entity.User;

public class UserService {

    private UserDao userDao = new UserDao();

    private static UserService userService;

    private UserService() {

    }

    public static UserService getInstance() {
        if (userService==null) {
            userService = new UserService();
        }
        return userService;
    }

    /**
     * 查找用户
     * @param user 查找信息
     * @return 用户信息
     */
    public User findUser(User user) {
        return userDao.findUser(user);
    }

    /**
     * 新用户注册
     * @param user 注册信息
     * @return 0-注册失败；1-注册成功
     */
    public int register(User user) {
        return userDao.register(user);
    }

}
