package com.random.lottery.mapper;

import com.random.lottery.model.MemberAttendanceRateT;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MemberAttendanceRateTMapper {

    List<MemberAttendanceRateT> selectAll();

//    void updateMemberId(@Param("id")List<Integer> ids, @Param("memberIds")List<Integer> memberIds);
    void updateMemberId(@Param("data") Map<Integer, Integer> data);

    List<Integer> getAllMemberId();

    List<Integer> getAttendanceRateCount();

}