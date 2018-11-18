package com.lvjing.cglibProxy;

import org.junit.Test;

public class domain {

    @Test
    public void test() {
        CarDao carDao = new CarDao();

        CarDao proxy = (CarDao) new CGLIBProxy(carDao).createProxy();

        /*carDao.addCar();
        carDao.updateCar();
        carDao.delCar();
        carDao.findCar();*/
        proxy.updateCar();
        proxy.addCar();
        proxy.delCar();
        proxy.findCar();
    }

}
