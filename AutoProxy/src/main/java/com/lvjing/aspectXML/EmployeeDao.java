package com.lvjing.aspectXML;

public class EmployeeDao {

    public void addEmployee() {
        System.out.println("add employee");
    }

    public String delEmployee() {
        System.out.println("delete employee");
        return " 小猪佩奇身上纹，今夜就做社会人！";
    }

    public void updateEmployee() {
        System.out.println("update employee");
    }

    public void findEmployee() {
        System.out.println("find employee");
        int i = 10/0;
    }

}
