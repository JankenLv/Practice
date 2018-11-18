package com.damu.dao;

import com.damu.entity.Course;
import com.damu.entity.Student;
import com.damu.entity.StudentWithCourse;
import com.damu.util.JDBCUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class studentDAO {

    private SqlSession sqlSession;
    private Student student;
    private List<Student> studentList;
    private int result;
    private  List<Course> courses;
    private  Course course;
    private StudentWithCourse studentWithCourse;

    private SqlSession getSqlSession() {
        sqlSession = JDBCUtil.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    public List<Student> getAllStudents() {
        try {
            studentList = getSqlSession().selectList("getStudent",new Student());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return studentList;
    }

    public Student addStudent(Student student) {
        try {
            getSqlSession().insert("addStudent",student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return student;
    }

    public Student getStudentById(int id) {
        try {
            student = getSqlSession().selectOne("getStudent",new Student((id)));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return student;
    }

    public Student modifyStudent(Student student) {
        try {
            getSqlSession().update("modifyStudent",student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return student;
    }

    public int delStudent(int id) {
        try {
            result = getSqlSession().delete("delStudent",id);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return result;
    }

    public List<Course> getAllCourses() {
        try {
            courses = getSqlSession().selectList("findCourses");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return courses;
    }

    public Course getCourseById(int id) {
        try {
            course = getSqlSession().selectOne("findCourses",new Course(id));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return course;
    }

    public Student getStudentAndCourse(int id) {
        try {
            student = getSqlSession().selectOne("findStudentAndCourse",new Student(id));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return student;
    }

    public StudentWithCourse getStudentWithCourse(int id) {
        try {
            studentWithCourse = getSqlSession().selectOne("findStudentWithCourse",new Student(id));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return studentWithCourse;
    }

}
