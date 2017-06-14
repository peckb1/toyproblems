package com.github.peckb1.projecteuler.p021to030;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem29Test {

    private Problem29 problem29;

    @Before
    public void setUp() throws Exception {
        this.problem29 = new Problem29();
    }

    @Test
    public void testProblem29() throws Exception {
        Assert.assertEquals(15, this.problem29.distinctPowerValues(5, 5));
        Assert.assertEquals(69, this.problem29.distinctPowerValues(10, 10));
        Assert.assertEquals(9183, this.problem29.distinctPowerValues(100, 100));
    }
}
