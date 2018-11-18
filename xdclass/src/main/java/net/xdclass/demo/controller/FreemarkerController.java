package net.xdclass.demo.controller;

import net.xdclass.demo.bean.AcmeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 使用freemarker模版引擎
 *
 * <p> @作者：jankin_lv </p>
 * <p> @创建时间: 2018/11/5 23:38 </p>
 */
@Controller
@RequestMapping("/api/freemarker")
public class FreemarkerController {

    @Autowired
    private AcmeProperties acmeProperties;

    @GetMapping("/index")
    public Object goIndex(Map<String, Object> map) {
        map.put("acme", acmeProperties);
        return "fm/index";
    }

}
