package com.random.lottery;

import com.random.lottery.model.SignupGroupConfigT;
import com.random.lottery.service.MemberAttendanceRateService;
import com.random.lottery.service.SignupGroupConfigService;
import com.random.lottery.service.SignupGroupMemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LotteryApplicationTests {

    @Autowired
    private MemberAttendanceRateService memberAttendanceRateService;

    @Autowired
    private SignupGroupConfigService signupGroupConfigService;

    @Autowired
    private SignupGroupMemberService signupGroupMemberService;

    /**
     * 统计会员数量
     */
    @Test
    public void contextLoads() {
        System.out.println(memberAttendanceRateService.getList().size());
    }

    /**
     * 更新出勤率表中的会员id
     */
    @Test
    public void setMemberId() {
        /*List<Integer> ids = new ArrayList<>();
        List<Integer> memberIds = new ArrayList<>();*/

        Map<Integer, Integer> data = new HashMap<>();

        for (int i = 13629,j = 13625 ; i <= 27253; i++,j--) {
            /*ids.add(i);
            memberIds.add(j);*/
            data.put(i,j);
        }

        memberAttendanceRateService.updateMemberId(data);
    }

    /**
     * 获取配置信息
     */
    @Test
    public void testConfig() {
        List<SignupGroupConfigT> configs = signupGroupConfigService.getAllConfig();

        for (SignupGroupConfigT config : configs) {
            System.out.println("组别：" + config.getSignupConfigId() + "  可选人数：" +  config.getEnableQuantity() + "\n");
        }

//        System.out.println(signupGroupConfigService.getAllConfig().size());


    }

    /**
     * 获取所有会员（按出勤率排序）
     */
    @Test
    public void testAllMember() {
        System.out.println(memberAttendanceRateService.getAllMemberId());
    }

    /**
     * 获取出勤率统计列表（按出勤率排序）
     */
    @Test
    public void testAttendanceRateCount() {
        System.out.println(memberAttendanceRateService.getAttendanceRateCount());
    }

    /**
     * 抽签
     * 不设置map的大小：5s479ms
     * 设置map的大小：4s506ms
     */
    @Test
    public void testLottery() {

        //获取所有分组配置信息
        List<SignupGroupConfigT> configs = signupGroupConfigService.getAllConfig();
        //获取所有会员（按出勤率排序）
        List<Integer> allMember = memberAttendanceRateService.getAllMemberId();
        //获取出勤率统计列表（按出勤率排序）
        List<Integer> attendanceRateCount = memberAttendanceRateService.getAttendanceRateCount();
        //抽签
        Map<SignupGroupConfigT, List<Integer>> maps = memberAttendanceRateService.grouping(configs, attendanceRateCount, allMember, null);
//        System.out.println(maps == null ? "null" : maps.size());
//        System.out.println(maps == null ? "null" : maps);

        //数据校验
        /*int sum = 0;
        for (Map.Entry<SignupGroupConfigT, List<Integer>> entry : maps.entrySet()) {
            sum += entry.getValue().size();
        }
        System.out.println("============================已分组会员：" + sum);
*/
        //存储数据到数据库
        int num = signupGroupMemberService.addMember(maps);
//        System.out.println("****************************更新行数：" + sum);

    }


}
