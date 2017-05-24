package com.github.peckb1.projecteuler.p001to010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class Problem2Test {

    private Problem2 problem2;

    @Before
    public void setUp() throws Exception {
        this.problem2 = new Problem2();
    }

    @Test
    public void testProblem2() throws Exception {
        Assert.assertEquals(BigInteger.valueOf(4613732), this.problem2.fibEvenSum(4_000_000));
    }
}
