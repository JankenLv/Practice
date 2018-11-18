package com.random.lottery.mapper;

import com.random.lottery.model.SignupGroupConfigT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SignupGroupMemberTMapper {

    int insert(@Param("data") Map<SignupGroupConfigT, List<Integer>> map);

}