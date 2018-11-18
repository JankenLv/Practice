package com.lvjing.main;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Calculator c;

    @Before
    public void initC() {
        c = new Calculator();
    }

    @Test(timeout = 500)
    public void add() {
        c.add(2);
        c.add(2);
        assertEquals(4,c.getResult());
    }

    @Test(timeout = 500)
    public void substract() {
        c.substract(2);
        assertEquals(2,c.getResult());
    }

    @Ignore
    public void multiply() {
    }

    @Test(expected = Exception.class)
    public void divide() throws Exception {
        c.divide(1);
    }

    @Test(timeout = 500)
    public void square() {
        c.square(5);
    }

    @Ignore
    public void squareRoot() {
        c.squareRoot(9);
    }

    @After
    public void clear() {
        c.clear();
    }
}