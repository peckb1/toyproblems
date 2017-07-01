package com.github.peckb1.projecteuler.p041to050;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem41Test {

    private Problem41 problem41;

    @Before
    public void setUp() throws Exception {
        this.problem41 = new Problem41();
    }

    @Test
    public void testProblem40() throws Exception {
        Assert.assertEquals(7652413, this.problem41.largestPandigitalPrime());
    }

}
