package com.lvjing.aspectAnno;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class domain {

    private ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("Application.xml");
    }

    @Test
    public void test() {
        MemberDao memberDao = (MemberDao) context.getBean("memberDao");
        memberDao.addMember();
        memberDao.updateMember();
        memberDao.delMember();
        memberDao.findMember();
    }

}
