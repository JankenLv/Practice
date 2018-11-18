package com.lvjing.hd.service;

import com.lvjing.hd.entity.User;

public interface UserService {
    void register(User user);

    User getUser(String username);
}
