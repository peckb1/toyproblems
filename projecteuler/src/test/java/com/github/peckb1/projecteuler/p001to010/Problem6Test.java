package com.github.peckb1.projecteuler.p001to010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class Problem6Test {

    private Problem6 problem6;

    @Before
    public void setUp() throws Exception {
        this.problem6 = new Problem6();
    }

    @Test
    public void testProblem6() throws Exception {
        Assert.assertEquals(BigInteger.valueOf(2640), this.problem6.sumSquareDifference(1, 10));
        Assert.assertEquals(BigInteger.valueOf(25164150), this.problem6.sumSquareDifference(1, 100));

        Assert.assertEquals(BigInteger.valueOf(2640), this.problem6.sumSquareDifference(10));
        Assert.assertEquals(BigInteger.valueOf(25164150), this.problem6.sumSquareDifference(100));
        Assert.assertEquals(new BigInteger("5316911974886729899838124255256510464"), this.problem6.sumSquareDifference(Integer.MAX_VALUE));
    }
}
