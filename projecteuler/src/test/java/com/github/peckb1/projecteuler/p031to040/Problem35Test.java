package com.github.peckb1.projecteuler.p031to040;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem35Test {

    private Problem35 problem35;

    @Before
    public void setUp() throws Exception {
        this.problem35 = new Problem35();
    }

    @Test
    public void testProblem35() throws Exception {
        Assert.assertEquals(4, this.problem35.circularPrimes(10));
        Assert.assertEquals(13, this.problem35.circularPrimes(100));
        Assert.assertEquals(25, this.problem35.circularPrimes(1_000));
        Assert.assertEquals(33, this.problem35.circularPrimes(10_000));
        Assert.assertEquals(43, this.problem35.circularPrimes(100_000));
        Assert.assertEquals(55, this.problem35.circularPrimes(1_000_000));
    }
}
