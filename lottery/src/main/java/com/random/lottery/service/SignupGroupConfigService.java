package com.random.lottery.service;

import com.random.lottery.mapper.SignupGroupConfigTMapper;
import com.random.lottery.model.SignupGroupConfigT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignupGroupConfigService {

    @Autowired
    private SignupGroupConfigTMapper signupGroupConfigTMapper;

    /**
     * 获取所有分组配置信息
     *
     * @return
     */
    public List<SignupGroupConfigT> getAllConfig() {
        return signupGroupConfigTMapper.selectAll();
    }

}
