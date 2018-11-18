package net.xdclass.demo.controller;

import net.xdclass.demo.bean.Greeting;
import net.xdclass.demo.service.MybatisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 使用Thymeleaf模板引擎进行页面跳转
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/10 10:41 </p>
 */
@Controller
@RequestMapping("/api/thymeleaf")
public class ThymeleafController {

    @Autowired
    private MybatisTestService mybatisTestService;

    @GetMapping("/hello")
    public String index() {
        return "index";// 不用加后缀，在配置文件里配置了
    }

    /**
     * 返回一个对象到前端页面
     *
     * @param map
     * @return
     */
    @GetMapping("/info")
    public String info(Map<String, Object> map) {
        map.put("greeting", new Greeting(2233L,"jankin_lv"));
        return "admin/info";
    }

    /**
     * 获取部门信息
     *
     * @param map
     * @return
     */
    @GetMapping("/dep_info")
    public String departmentInfo(Map<String, Object> map) {
        map.put("deps",mybatisTestService.listDepartment());
        return "admin/dep_info";
    }

}
