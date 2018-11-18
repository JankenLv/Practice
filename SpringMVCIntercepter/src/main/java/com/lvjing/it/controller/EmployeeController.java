package com.lvjing.it.controller;

import com.lvjing.it.dao.EmployeeDAO;
import com.lvjing.it.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping(value = "/emp")
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/list",method = GET)
    public ModelAndView getAllEmployee() {
        Collection<Employee> employees = employeeDAO.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Employees", employees);
        modelAndView.setViewName("employee_list");
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = POST)
    public String addEmployee(Employee employee) {
        employeeDAO.insert(employee);
        return "redirect:/emp/list";
    }

    @RequestMapping(value = "/remove/{id}",method = DELETE)
    public String removeEmployee(@PathVariable Integer id) {
        employeeDAO.delete(id);
        return "redirect:/emp/list";
    }

    @RequestMapping(value = "/toEdit/{id}",method = GET)
    public ModelAndView toEditEmployee(@PathVariable Integer id){
        Employee employee = employeeDAO.selectById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Employee",employee);
        modelAndView.setViewName("edit_employee");
        return modelAndView;
    }

    @RequestMapping(value = "/edit",method = PUT)
    public String editEmployee(Employee employee) {
        employeeDAO.update(employee);
        return "redirect:/emp/list";
    }

    @RequestMapping(value = "/toAdd")
    public String toAddEmployee() {
        return "add_employee";
    }



}
