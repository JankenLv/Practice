package com.lvjing.service;

import com.lvjing.dao.CarDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CarService extends JdbcDaoSupport implements CarDAO {

    public void findCar() {
        System.out.println("find a car");
    }

    public void addCar() {
        System.out.println("add a car");
    }

    public void delCar() {
        System.out.println("delete a car");
    }

    public void updateCar() {
        System.out.println("update a car");
    }
}
