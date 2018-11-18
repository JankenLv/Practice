package com.imooc.servlet;

import com.imooc.domain.Course;
import com.imooc.service.serviceImpl.CourseServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * 查询课程信息的servlet
 */
public class QueryCourseServlet extends HttpServlet {
    /**
     * 查询课程的方法
     * @param query
     * @return jsonArray of courses
     */
    private JSONArray queryCourse(String query) {
        List<Course> courses = new CourseServiceImpl().getAllCourse();
        JSONArray result = new JSONArray();

        JSONArray jsonArrayOfCourse = JSONArray.fromObject(courses);  // 把course数据转换为json格式
        if (Objects.equals("getAllCourses", query)) {
            // 没有查询条件，返回所有课程：
            result.addAll(jsonArrayOfCourse);
        } else if(query.matches("\\d+") || query.matches("\\d+\\.\\d+")){
            // query为数字时，从课程id或课程时长里查找
            // 从课程id里查找：
            for (int i = 0; i < jsonArrayOfCourse.size(); i++) {
                if (Objects.equals(query,jsonArrayOfCourse.getJSONObject(i).getString("id"))) {
                    result.add(jsonArrayOfCourse.getJSONObject(i));
                    break;
                }
            }

            // 从课程时长里查找：
            query = String.valueOf(Float.valueOf(query));
            for (int i = 0; i < jsonArrayOfCourse.size(); i++) {
                if (Objects.equals(query,jsonArrayOfCourse.getJSONObject(i).getString("courseTime"))) {
                    result.add(jsonArrayOfCourse.getJSONObject(i));
                }
            }
        } else {
            // query为字符时，从id和时长外的数据查找:
            for (int i = 0; i < jsonArrayOfCourse.size(); i++) {
                JSONObject jsonFromCourse = jsonArrayOfCourse.getJSONObject(i);
                Collection content = jsonFromCourse.values();
                for(Object value : content) {
                    if (!(value.toString().matches("\\d+") || value.toString().matches("\\d+.\\d+"))) {
                        if (query.equalsIgnoreCase(value.toString())) {
                            result.add(jsonFromCourse);
                        }
                    }
                }
            }
        }
        return result;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String query = request.getParameter("query");
        JSONArray result = queryCourse(query);
        request.getSession().setAttribute("result",result);
        request.getSession().setAttribute("export","result");
//            System.out.println("搜索结果：\n" + result);

        // 返回搜索结果
        response.setContentType("text/json;charset=UTF-8");
        ServletOutputStream os = response.getOutputStream();
        byte[] bytes = result.toString().getBytes("UTF-8");
        os.write(bytes);
        os.flush();
        os.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req, resp);
    }
}
