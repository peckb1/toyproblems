package com.github.peckb1.projecteuler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class Problem1Test {

    private Problem1 problem1;

    @Before
    public void setUp() throws Exception {
        this.problem1 = new Problem1();
    }

    @Test
    public void testProblem1() throws Exception {
        Assert.assertEquals(BigInteger.valueOf(233168), this.problem1.sumOfMultiples(3, 5, 1000));
        Assert.assertEquals(BigInteger.valueOf(233168), this.problem1.sumOfMultiples(new int[]{3, 5}, 1000));
    }
}
