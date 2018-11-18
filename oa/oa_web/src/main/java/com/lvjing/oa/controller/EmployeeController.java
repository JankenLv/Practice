package com.lvjing.oa.controller;

import com.lvjing.oa.biz.DepartmentBiz;
import com.lvjing.oa.biz.EmployeeBiz;
import com.lvjing.oa.entity.Department;
import com.lvjing.oa.entity.Employee;
import com.lvjing.oa.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller("employeeController")
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private DepartmentBiz departmentBiz;

    @Autowired
    private EmployeeBiz employeeBiz;

    @RequestMapping("/list")
    public String list(Map<String, Object> map) {
        map.put("list", employeeBiz.getAll());
        return "employee_list";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String, Object> map) {
        map.put("employee",new Employee());
        map.put("dlist",departmentBiz.getAll());
        map.put("post",Contant.getPost());
        return "employee_add";
    }

    @RequestMapping(value = "/add",method = POST)
    public String add(Employee employee) {
        employeeBiz.add(employee);
        return "redirect:list";
    }

    @RequestMapping(value = "/to_update/{sn}", method = GET)
    public String toUpdate(@PathVariable String sn, Map<String, Object> map) {
        map.put("employee",employeeBiz.get(sn));
        map.put("dlist",departmentBiz.getAll());
        map.put("post",Contant.getPost());
        return "employee_update";
    }

    @RequestMapping(value = "/update",method = PUT)
    public String update(Employee employee) {
        employeeBiz.edit(employee);
        return "redirect:list";
    }

    @RequestMapping(value = "/remove/{sn}", method = DELETE)
    public String remove(@PathVariable String sn) {
        employeeBiz.remove(sn);
        return "redirect:../list";
    }
}
