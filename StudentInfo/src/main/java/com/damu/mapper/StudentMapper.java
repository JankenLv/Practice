package com.damu.mapper;

import com.damu.entity.Course;
import com.damu.entity.Student;
import com.damu.entity.StudentWithCourse;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

public interface StudentMapper {

    // 根据id查询student

    @Select("select * from mytest.student where id = #{id}")
    Student selectStudentById(int id);


    // 添加student

    /*@Insert("insert into mytest.student(reg_no,name,sex,age,grade,major)" +
            "values(#{reg_no},#{name},#{sex},#{age},#{grade},#{major})")*/
    @InsertProvider(type = UseSqlBuilder.class,method = "buildNewStudent")
    @SelectKey(before = false,resultType = int.class,statement = "select LAST_INSERT_ID()",keyProperty = "id")
    int addNewStudent(Student student);



    // 通过专业名查询课程

    /*@Results(value = {
        @Result(property = "id", column = "id", id = true),
        @Result(property = "courseID", column = "courseid"),
        @Result(property = "majorName", column = "major_name"),
        @Result(property = "courseName", column = "courname"),
        @Result(property = "courseTime", column = "courtime"),
        @Result(property = "courseTeacher", column = "courteacher")
    })*/
//    @Select("select * from mytest.course where major_name = #{name}")
    @ResultMap("com.damu.entity.Student.courseResultMap")
    @SelectProvider(type = UseSqlBuilder.class,method = "buildCourseByName")
    Course selectCourseByMajorName(String name);


    // 通过id更新student（这个方法执行完后并没有获取自增生成的主键）

    @UpdateProvider(type = UseSqlBuilder.class,method = "updateStudent")
    @SelectKey(keyProperty = "id", statement = "SELECT LAST_INSERT_ID()", resultType = int.class, before = false)
    int updateStudentById(@Param("name") final String name, @Param("id") final int id);


    // 根据id删除student

    @DeleteProvider(type = UseSqlBuilder.class,method = "deleteStudent")
    void delStudentById(final int id);


    // 联合查询student和对应的course

    @ResultMap("com.damu.entity.Student.StudentWithCourseMap")
    @SelectProvider(type = UseSqlBuilder.class,method = "joinQuery")
    StudentWithCourse selectStudentWithCourse(int id);


    // 编写动态SQL语句的内部类
    class UseSqlBuilder {

        // 查询语句
        public static String buildCourseByName() {
            return new SQL(){{
                SELECT("*");
                FROM("mytest.course");
                WHERE("major_name = #{majorName}");
            }}.toString();
        }

        // 查询语句
        public static String findStudent(final Student student) {
            return new SQL(){{
                SELECT("*");
                FROM("mytest.student");
                if (student.getId() != null) {
                    WHERE("id = " + student.getId());
                }
                /*if (student.get != null) {
                    WHERE("id = " + student.getId() );
                }*/
            }}.toString();
        }

        // insert语句流畅的写法！！
        public String buildNewStudent() {

            return new SQL()
                    .INSERT_INTO("mytest.student")
                    .VALUES("reg_no,name,sex,age,grade,major","#{reg_no},#{name},#{sex},#{age},#{grade},#{major}")
                    .toString();
        }

        // 更新语句

        public String updateStudent() {
            return new SQL(){{
                UPDATE("mytest.student");
                SET("name = #{name}");
                WHERE("id = #{id}");
            }}.toString();
        }

        // 删除语句

        public static String deleteStudent() {
            return new SQL(){{
                DELETE_FROM("mytest.student");
                WHERE("id = #{id}");
            }}.toString();
        }

        // 联合查询

        public String joinQuery() {
            return new SQL(){{
                SELECT("s.id as s_id,\n" +
                        "s.reg_no as s_reg_no,\n" +
                        "s.name as s_name,\n" +
                        "s.sex as s_sex,\n" +
                        "s.age as s_age,\n" +
                        "s.grade as s_grade,\n" +
                        "s.major as s_major,\n" +
                        "c.courname as c_courname,\n" +
                        "c.courtime as c_courtime,\n" +
                        "c.courteacher as c_courteacher");
                FROM("mytest.student AS s");
                LEFT_OUTER_JOIN("mytest.course AS c ON s.major = c.major_name");
                WHERE("s.id = #{id}");
            }}.toString();
        }

    }

}
