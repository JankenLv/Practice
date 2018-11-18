package com.lvjing.aspectAnno;

public class MemberDao {

    public void addMember() {
        System.out.println("add a member");
    }
    public void findMember() {
        //int i = 10/0;
        System.out.println("find a member");
    }
    public String updateMember() {
        System.out.println("update a member");
        return "小明";
    }
    public void delMember() {
        System.out.println("delete a member");
    }

}
