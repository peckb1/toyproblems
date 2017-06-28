package com.github.peckb1.projecteuler.p031to040;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem38Test {

    private Problem38 problem38;

    @Before
    public void setUp() throws Exception {
        this.problem38 = new Problem38();
    }

    @Test
    public void testProblem38() throws Exception {
        Assert.assertEquals(932718654, this.problem38.largestPandigital());
    }
}
