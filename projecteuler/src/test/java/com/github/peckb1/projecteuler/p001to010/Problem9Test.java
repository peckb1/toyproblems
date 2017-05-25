package com.github.peckb1.projecteuler.p001to010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem9Test {

    private Problem9 problem9;

    @Before
    public void setUp() throws Exception {
        this.problem9 = new Problem9();
    }

    @Test
    public void testProblem9() throws Exception {
        Assert.assertEquals(-1, this.problem9.productOfTriplet(10));
        Assert.assertEquals(60, this.problem9.productOfTriplet(12));
        Assert.assertEquals(-1, this.problem9.productOfTriplet(100));
        Assert.assertEquals(31875000, this.problem9.productOfTriplet(1_000));
        Assert.assertEquals(1810228928, this.problem9.productOfTriplet(10_000));
    }
}
