package com.damu.test;

import com.damu.entity.Course;
import com.damu.entity.Student;
import com.damu.mapper.StudentMapper;
import com.damu.service.StudentService;
import com.damu.util.JDBCUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class mybatisAnnotationTest {

    private StudentService studentService;
    private SqlSession sqlSession;
    private Student student;
    private StudentMapper mapper;
    private Course course;

    // 获取SqlSession的方法
    private SqlSession getSqlSession() {
        sqlSession = JDBCUtil.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    // 获取注解映射器
    private StudentMapper getStudentMapper() {
        mapper = getSqlSession().getMapper(StudentMapper.class);
        return mapper;
    }

    // 在调用测试方法前调用此方法
    @Before
    public void initTest() {
        studentService = StudentService.getInstance();
        JDBCUtil.initSqlSessionFactory();
    }

    @Ignore
    public void getStudent() {
        student = getStudentMapper().selectStudentById(2);
        System.out.println(student);
        sqlSession.close();
    }

    @Ignore
    public void getCourse() {
        course = getStudentMapper().selectCourseByMajorName("计算机系");
        System.out.println(course);
        sqlSession.close();
    }

    @Ignore
    public void addStudent() {
        student = new Student(20171210,"凤梨酥","男",30,"2018","数学系");
        mapper = getStudentMapper();
        mapper.addNewStudent(student);
        sqlSession.commit();
        student = mapper.selectStudentById(student.getId());
//        System.out.println(i);
        System.out.println(student);
    }

    @Ignore
    public void updateStudent() {
        mapper = getStudentMapper();
        mapper.updateStudentById("牛角包",25);
        sqlSession.commit();
    }

    @Ignore
    public void delStudent() {
        getStudentMapper().delStudentById(27);
        sqlSession.commit();
    }

    @Test
    public void selectStudentWithCourse() {
        System.out.println(getStudentMapper().selectStudentWithCourse(20));
    }

    // 所有测试方法完成后调用此方法
    @After
    public void closeSqlSession() {
        if (sqlSession!=null) {
            sqlSession.close();
            sqlSession=null;
        }
    }

}
