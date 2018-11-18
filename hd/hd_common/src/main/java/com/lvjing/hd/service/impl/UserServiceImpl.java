package com.lvjing.hd.service.impl;

import com.lvjing.hd.dao.UserDao;
import com.lvjing.hd.entity.User;
import com.lvjing.hd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void register(User user) {
        userDao.insert(user);
    }

    public User getUser(String username) {
        return userDao.selectByName(username);
    }
}
