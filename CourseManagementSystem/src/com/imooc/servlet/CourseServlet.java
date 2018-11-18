package com.imooc.servlet;

import com.imooc.domain.Course;
import com.imooc.service.CourseService;
import com.imooc.service.serviceImpl.CourseServiceImpl;
import com.imooc.utils.CourseUtil;
import com.imooc.utils.RegexUtil;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 操作课程信息存取的servlet
 */
public class CourseServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals("/addCourse",request.getServletPath())) {
            if (RegexUtil.validateCourseId(request.getParameter("courseId"))) {
                if (RegexUtil.validateCourseTime(request.getParameter("courseTime"))) {
                    Course course = CourseUtil.pack(request);
                    courseService.addCourse(course);
                    request.setAttribute("msg", "课程添加成功！");
                    request.getRequestDispatcher("/goTo?page=addCourse").forward(request, response);
                } else {
                    request.setAttribute("msg", "课程时长格式错误！课程添加失败！");
                    request.getRequestDispatcher("/goTo?page=addCourse").forward(request, response);
                }
            } else {
                request.setAttribute("msg", "课程ID格式错误！课程添加失败！");
                request.getRequestDispatcher("/goTo?page=addCourse").forward(request, response);
            }

        } else if (Objects.equals("/getAllCourses", request.getServletPath())) {
            if (courseService.getAllCourse().size() != 0) {
                request.getSession().setAttribute("result",JSONArray.fromObject(courseService.getAllCourse()));
                request.getSession().setAttribute("export","result");
                request.setAttribute("allCourses",courseService.getAllCourse());
                request.setAttribute("totalPages",courseService.getAllCourse().size());
            }
            request.getRequestDispatcher("/goTo?page=showCourse").forward(request,response);
        } else if (Objects.equals("/clearCourse", request.getServletPath())) {
            courseService.clearCourse();
        }
    }
}
