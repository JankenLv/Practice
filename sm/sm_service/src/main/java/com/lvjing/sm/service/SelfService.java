package com.lvjing.sm.service;

import com.lvjing.sm.entity.Staff;

public interface SelfService {
    Staff login(String account, String password);

    void changePassword(Integer id, String password);
}
