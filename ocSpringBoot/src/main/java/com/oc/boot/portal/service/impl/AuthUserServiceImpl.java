package com.oc.boot.portal.service.impl;

import com.oc.boot.portal.bean.AuthUser;
import com.oc.boot.portal.dao.AuthUserMapper;
import com.oc.boot.portal.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserMapper authUserMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AuthUser> getAll() {
        return authUserMapper.selectAll();
    }
}
