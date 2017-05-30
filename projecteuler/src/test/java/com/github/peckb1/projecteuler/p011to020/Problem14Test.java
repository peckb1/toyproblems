package com.github.peckb1.projecteuler.p011to020;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem14Test {

    private Problem14 problem14;

    @Before
    public void setUp() throws Exception {
        this.problem14 = new Problem14();
    }

    @Test
    public void testProblem14() throws Exception {
        Assert.assertEquals(9, this.problem14.longestChain(10));
        Assert.assertEquals(97, this.problem14.longestChain(100));
        Assert.assertEquals(871, this.problem14.longestChain(1_000));
        Assert.assertEquals(6_171, this.problem14.longestChain(10_000));
        Assert.assertEquals(77_031, this.problem14.longestChain(100_000));
        Assert.assertEquals(837_799, this.problem14.longestChain(1_000_000));
        Assert.assertEquals(8_400_511, this.problem14.longestChain(10_000_000));
    }
}
