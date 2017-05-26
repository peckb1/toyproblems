package com.github.peckb1.projecteuler.p001to010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class Problem10Test {

    private Problem10 problem10;

    @Before
    public void setUp() throws Exception {
        this.problem10 = new Problem10();
    }

    @Test
    public void testProblem10() throws Exception {
        Assert.assertEquals(BigInteger.valueOf(17), this.problem10.sumPrimes(10));
        Assert.assertEquals(new BigInteger("142913828922"), this.problem10.sumPrimes(2_000_000));
    }

}
