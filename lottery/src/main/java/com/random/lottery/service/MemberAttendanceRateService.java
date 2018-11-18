package com.random.lottery.service;

import com.random.lottery.mapper.MemberAttendanceRateTMapper;
import com.random.lottery.model.MemberAttendanceRateT;
import com.random.lottery.model.SignupGroupConfigT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class MemberAttendanceRateService {

    @Autowired
    private MemberAttendanceRateTMapper memberAttendanceRateTMapper;

    /**
     * 获取会员出勤率列表
     *
     * @return
     */
    public List<MemberAttendanceRateT> getList() {
        return memberAttendanceRateTMapper.selectAll();
    }

    /**
     * 更新会员id
     */
    @Transactional
//    public void updateMemberId(List<Integer> ids, List<Integer> memberIds) {
    public void updateMemberId(Map<Integer, Integer> data) {

//        memberAttendanceRateTMapper.updateMemberId(ids,memberIds);
        memberAttendanceRateTMapper.updateMemberId(data);
    }

    /**
     * 获取所有会员
     * @return
     */
    public List<Integer> getAllMemberId() {
        return memberAttendanceRateTMapper.getAllMemberId();
    }

    /**
     * 获取出勤率统计列表
     * @return
     */
    public List<Integer> getAttendanceRateCount() {
        return memberAttendanceRateTMapper.getAttendanceRateCount();
    }

   /* *//**
     * 抽签
     *
     * @param signupGroupConfigId
     * @return
     *//*
    @Transactional
    public Boolean randomSignup(Long signupGroupConfigId) {
        // 获取抽签配置信息
        List<SignupGroupConfigT> signupGroupConfigs = signupGroupConfigService.getAll();
        *//*if (StringUtils.isEmpty(signupGroupConfigs) || signupGroupConfigs.isEmpty()) {
            throw new ApplicationException(ApplicationErrorEnum.PARAMETER_EMPTY_ERROR, "抽签配置信息");
        }*//*
        // 获取出勤率统计列表（统计每个级别出勤率人数，排除第十类人和审核未通过的人）
        *//*List<Integer> attendanceRateCounts = memberAttendanceRateService.getAttendanceRateCount();
        if (StringUtils.isEmpty(attendanceRateCounts) || attendanceRateCounts.isEmpty()) {
            throw new ApplicationException(ApplicationErrorEnum.PARAMETER_EMPTY_ERROR, "出勤率");
        }*//*
        // 获取所有会员（按出勤率排序，排除第十类人和审核未通过的人）
        List<Integer> enableMember = memberAttendanceRateService.getAllMemberId();
        *//*if (StringUtils.isEmpty(enableMember) || enableMember.isEmpty()) {
            throw new ApplicationException(ApplicationErrorEnum.PARAMETER_EMPTY_ERROR, "会员");
        }*//*
        //抽签
        List<Map<SignupGroupConfigT,List<Integer>>> lotteryResult = grouping(signupGroupConfigs, attendanceRateCounts, enableMember, null);

        return null;
    }*/

    /**
     * 抽签（会员随机分组）
     *
     * @param signupGroupConfigTS 分组配置项
     * @param attendanceRateCounts 出勤率统计列表
     * @param enableMember 可分组会员
     * @param result 分组结果
     */
    public Map<SignupGroupConfigT,List<Integer>> grouping(List<SignupGroupConfigT> signupGroupConfigTS, List<Integer> attendanceRateCounts, List<Integer> enableMember, Map<SignupGroupConfigT,List<Integer>> result) {

        while (!(signupGroupConfigTS.isEmpty() || attendanceRateCounts.isEmpty() || enableMember.isEmpty())) {

            //抽签配置信息
            SignupGroupConfigT signupGroupConfigT = signupGroupConfigTS.get(0);
            //出勤率统计
            Integer attendanceRateCount = attendanceRateCounts.get(0);
            List<Integer> memberOfRate;

            if (!(StringUtils.isEmpty(signupGroupConfigT) || StringUtils.isEmpty(attendanceRateCount))) {

                if (attendanceRateCount > signupGroupConfigT.getEnableQuantity()) {
                    //*****出勤率人数统计大于可报名人数*****

                    //获取这一级别出勤率的所有会员ID
                    memberOfRate = new ArrayList<>(enableMember.subList(0, attendanceRateCount));
                    //抽签
                    List<Integer> lotteryResult = this.lottery(Collections.min(memberOfRate), Collections.max(memberOfRate), signupGroupConfigT.getEnableQuantity(), memberOfRate);

                    //保存分组结果
                    result = this.getGroup(signupGroupConfigT,lotteryResult,result);

                    //移除数据
                    signupGroupConfigTS.remove(signupGroupConfigT);  //移除已使用抽签配置信息
                    enableMember.removeAll(lotteryResult);  //移除已抽签会员
                    attendanceRateCounts.set(0, attendanceRateCount - signupGroupConfigT.getEnableQuantity());  //这一级别出勤率剩余可抽签人数
                } else if (attendanceRateCount < signupGroupConfigT.getEnableQuantity()) {
                    //*****出勤率人数统计小于可报名人数*****

                    //获取这一级别出勤率的所有会员ID(全部中签)
                    memberOfRate = new ArrayList<>(enableMember.subList(0, attendanceRateCount));

                    //保存分组结果
                    result = this.getGroup(signupGroupConfigT,memberOfRate,result);

                    //移除数据
                    attendanceRateCounts.remove(attendanceRateCount);  //移除已抽签出勤率级别
                    enableMember.removeAll(memberOfRate);  //移除已抽签会员
                    signupGroupConfigT.setEnableQuantity(signupGroupConfigT.getEnableQuantity() - attendanceRateCount);  //这一分组剩余可抽签人数
                    signupGroupConfigTS.set(0,signupGroupConfigT);
                } else {
                    //*****出勤率人数统计等于可报名人数*****

                    //获取这一级别出勤率的所有会员ID
                    memberOfRate = new ArrayList<>(enableMember.subList(0, attendanceRateCount));

                    //保存分组结果
                    result = this.getGroup(signupGroupConfigT,memberOfRate,result);

                    //移除数据
                    attendanceRateCounts.remove(attendanceRateCount);  //移除已抽签出勤率级别
                    enableMember.removeAll(memberOfRate);  //移除已抽签会员
                    signupGroupConfigTS.remove(signupGroupConfigT);  //移除已使用抽签配置信息
                }

                //递归
                grouping(signupGroupConfigTS, attendanceRateCounts, enableMember, result);
            }

        }
//        System.out.println(result == null ? "null" : result.size());
        return result;
    }

    /**
     * 在给定的范围内(min,max)获取指定数量(number)的随机数
     *
     * @param min 最小值
     * @param max 最大值
     * @param number 数量
     * @param enableNumber 有效数字列表
     * @return List<Integer>
     */
    private List<Integer> lottery(int min, int max, int number, List<Integer> enableNumber){
        List<Integer> result = new ArrayList<>(number); // 集合初始化时指定其大小
        Random r = new Random();

        //易造成死循环!要判断min > max > 0; number > 0; enableNumber??

        while (result.size() < number) {
            //获取随机数
            int randomNum = r.nextInt(max-min+1) + min;
            //保存有效结果
            if (enableNumber.contains(randomNum)) {
                result.add(randomNum);
            }
        }
        return result;
    }

    /**
     * 获取分组结果
     *
     * @param config 分组配置项
     * @param memberId 分组会员ID列表
     * @param result 分组结果
     * @return Map<SignupGroupConfigT,List<Integer>>
     */
    private Map<SignupGroupConfigT,List<Integer>> getGroup(SignupGroupConfigT config, List<Integer> memberId,Map<SignupGroupConfigT,List<Integer>> result) {

        //result为null（首次进入）
        if (StringUtils.isEmpty(result) || result.isEmpty()) {
            result = new HashMap<>(11);  // 初始化map是指定其大小
            result.put(config,memberId);
            return result;
        }

        //合并或新增会员分组
        if (result.containsKey(config)) {
            List<Integer> originalChild = result.get(config);  //原来的已存在的会员
            originalChild.addAll(memberId);  //合并新的会员
            result.put(config, originalChild);  //保存结果
        } else {
            result.put(config,memberId);  //新的分组
        }

        return result;
    }

}
