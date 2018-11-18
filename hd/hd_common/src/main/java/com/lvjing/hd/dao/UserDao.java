package com.lvjing.hd.dao;

import com.lvjing.hd.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {
    void insert(User user);

    User selectByName(String username);
}
