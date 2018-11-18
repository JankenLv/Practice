package com.lvjing.sm.controller;

import com.lvjing.sm.entity.Department;
import com.lvjing.sm.entity.Staff;
import com.lvjing.sm.service.DepartmentService;
import com.lvjing.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentService departmentService;

    //   /staff/list.do       /staff_list.jsp

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> list = staffService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("/pages/staff_list.jsp").forward(request,response);
//        request.getRequestDispatcher("../department_list.jsp").forward(request,response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        request.setAttribute("LIST",list);
        request.getRequestDispatcher("/pages/staff_add.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Staff staff = setStaff(request);
        staffService.add(staff);
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        Integer id = Integer.valueOf(request.getParameter("id"));
        Staff staff = staffService.get(id);
        request.setAttribute("LIST",list);
        request.setAttribute("STAFF",staff);
        request.getRequestDispatcher("/pages/staff_edit.jsp").forward(request,response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Staff staff = setStaff(request);
        staffService.edit(staff);
        response.sendRedirect("list.do");
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list = departmentService.getAll();
        String id = request.getParameter("id");
        Staff staff = staffService.get(Integer.valueOf(id));
        request.setAttribute("LIST",list);
        request.setAttribute("STAFF",staff);
        request.getRequestDispatcher("/pages/staff_detail.jsp").forward(request,response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        staffService.remove(Integer.valueOf(id));
        response.sendRedirect("list.do");
    }

    private Staff setStaff(HttpServletRequest request){
        Staff staff = null;
        try {
            Integer id = request.getParameter("id")==null || request.getParameter("id").equals("")?null:Integer.valueOf(request.getParameter("id"));
            String account = request.getParameter("account")==null || request.getParameter("account").equals("")?null:request.getParameter("account");
            String name = request.getParameter("name")==null || request.getParameter("name").equals("")?null:request.getParameter("name");
            Integer did = request.getParameter("did")==null || request.getParameter("did").equals("")?null:Integer.valueOf(request.getParameter("did"));
            String sex = request.getParameter("sex")==null || request.getParameter("sex").equals("")?null:request.getParameter("sex");
            String idNumber = request.getParameter("idNumber")==null || request.getParameter("idNumber").equals("")?null:request.getParameter("idNumber");
            Date bornDate = request.getParameter("bornDate")==null || request.getParameter("bornDate").equals("")?null:DateFormat.getDateInstance().parse(request.getParameter("bornDate").replace("/","-"));
            String info = request.getParameter("info")==null || request.getParameter("info").equals("")?"无":request.getParameter("info");

            staff = new Staff();
            staff.setId(id);
            staff.setAccount(account);
            staff.setDid(did);
            staff.setName(name);
            staff.setSex(sex);
            staff.setIdNumber(idNumber);
            staff.setBornDate(bornDate);
            staff.setInfo(info);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return staff;
    }
}
