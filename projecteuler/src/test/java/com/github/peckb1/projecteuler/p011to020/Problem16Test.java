package com.github.peckb1.projecteuler.p011to020;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class Problem16Test {

    private Problem16 problem16;

    @Before
    public void setUp() throws Exception {
        this.problem16 = new Problem16();
    }

    @Test
    public void testProblem16() throws Exception {
        Assert.assertEquals(BigInteger.valueOf(26), this.problem16.powerDigitSum(15));
        Assert.assertEquals(BigInteger.valueOf(1366), this.problem16.powerDigitSum(1000));
        Assert.assertEquals(BigInteger.valueOf(1351546), this.problem16.powerDigitSum(1_000_000));
    }
}
