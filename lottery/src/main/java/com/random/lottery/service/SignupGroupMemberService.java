package com.random.lottery.service;

import com.random.lottery.mapper.SignupGroupMemberTMapper;
import com.random.lottery.model.SignupGroupConfigT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SignupGroupMemberService {

    @Autowired
    private SignupGroupMemberTMapper signupGroupMemberTMapper;

    /**
     * 新增会员分组信息
     *
     * @param map 会员分组信息（整合数据到Map）
     * @return 新增行数
     */
    public int addMember(Map<SignupGroupConfigT, List<Integer>> map) {
        return signupGroupMemberTMapper.insert(map);
    }

}
