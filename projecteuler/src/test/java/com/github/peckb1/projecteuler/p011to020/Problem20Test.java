package com.github.peckb1.projecteuler.p011to020;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem20Test {

    private Problem20 problem20;

    @Before
    public void setUp() throws Exception {
        this.problem20 = new Problem20();
    }

    @Test
    public void testProblem20() throws Exception {
        Assert.assertEquals(1, this.problem20.sumDigitFactorial(1));
        Assert.assertEquals(27, this.problem20.sumDigitFactorial(10));
        Assert.assertEquals(648, this.problem20.sumDigitFactorial(100));
        Assert.assertEquals(10539, this.problem20.sumDigitFactorial(1000));
        Assert.assertEquals(149346, this.problem20.sumDigitFactorial(10000));}
}
