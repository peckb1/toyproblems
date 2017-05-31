package com.github.peckb1.projecteuler.p011to020;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class Problem15Test {

    private Problem15 problem15;

    @Before
    public void setUp() throws Exception {
        this.problem15 = new Problem15();
    }

    @Test
    public void testProblem15() throws Exception {
        Assert.assertEquals(BigInteger.valueOf(6), this.problem15.routes(2));
        Assert.assertEquals(BigInteger.valueOf(137846528820L), this.problem15.routes(20));
    }
}
