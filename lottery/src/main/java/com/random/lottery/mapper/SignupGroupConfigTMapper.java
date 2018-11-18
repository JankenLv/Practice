package com.random.lottery.mapper;

import com.random.lottery.model.SignupGroupConfigT;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignupGroupConfigTMapper {

    List<SignupGroupConfigT> selectAll();

}