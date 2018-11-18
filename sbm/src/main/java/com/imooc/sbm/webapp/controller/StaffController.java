package com.imooc.sbm.webapp.controller;

import com.imooc.sbm.webapp.bean.JsonResult;
import com.imooc.sbm.webapp.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping("/list.html")
    public String list(Map<String, Object> map) {
        try {
            map.put("JsonResult",JsonResult.render(staffService.getAllStaff()));
            return "staff_list";
        } catch (Exception e) {
            map.put("JsonResult",JsonResult.render("17000"));
            return "staff_list";
        }
    }
}
