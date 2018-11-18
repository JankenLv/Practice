package org.lvjing.Base;

public abstract class Role {

    protected void init(){
        System.out.println("角色初始化");
    };

    void die(){
        System.out.println("角色死亡");
    };

}
