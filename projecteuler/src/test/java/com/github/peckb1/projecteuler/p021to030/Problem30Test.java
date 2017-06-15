package com.github.peckb1.projecteuler.p021to030;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem30Test {

    private Problem30 problem30;

    @Before
    public void setUp() throws Exception {
        this.problem30 = new Problem30();
    }

    @Test
    public void testProblem30() throws Exception {
        Assert.assertEquals(1301, this.problem30.sumDigitPowers(3));
        Assert.assertEquals(19316, this.problem30.sumDigitPowers(4));
        Assert.assertEquals(443839, this.problem30.sumDigitPowers(5));
    }
}
