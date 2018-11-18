package com.lvjing.oa.controller;

import com.lvjing.oa.biz.DepartmentBiz;
import com.lvjing.oa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentBiz departmentBiz;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("list", departmentBiz.getAll());
        return "department_list";
    }

    @RequestMapping("/to_add")
    public String toAdd() {
        return "department_add";
    }

    @RequestMapping(value = "/add",method = POST)
    public String add(Department department) {
        departmentBiz.add(department);
        return "redirect:list";
    }

    @RequestMapping(value = "/to_update/{sn}", method = GET)
    public String toUpdate(@PathVariable String sn, Map<String, Object> map) {
        map.put("department",departmentBiz.get(sn));
        return "department_update";
    }

    @RequestMapping(value = "/update",method = PUT)
    public String update(Department department) {
        departmentBiz.edit(department);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove/{sn}", method = DELETE)
    public String remove(@PathVariable String sn) {
        departmentBiz.remove(sn);
        return "redirect:../list";
    }
}
