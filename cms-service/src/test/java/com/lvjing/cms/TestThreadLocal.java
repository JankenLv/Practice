package com.lvjing.cms;

import java.util.Date;

public class TestThreadLocal {

    private ThreadLocal<Date> threadLocal = new ThreadLocal<>();
    private Date date;

    public  Date getDate() {
        if (threadLocal.get() == null) {
            date = new Date();
            threadLocal.set(date);
        }
        return threadLocal.get();
    }


}
