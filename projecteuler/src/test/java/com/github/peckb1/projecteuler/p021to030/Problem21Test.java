package com.github.peckb1.projecteuler.p021to030;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem21Test {

    private Problem21 problem21;

    @Before
    public void setUp() throws Exception {
        this.problem21 = new Problem21();
    }

    @Test
    public void testProblem21() throws Exception {
        Assert.assertEquals(504, new Problem21().sumAmicableNumbers(1000));
        Assert.assertEquals(31626, new Problem21().sumAmicableNumbers(10000));
    }
}
