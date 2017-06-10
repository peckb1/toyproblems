package com.github.peckb1.projecteuler.p021to030;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem25Test {

    private Problem25 problem25;

    @Before
    public void setUp() throws Exception {
        this.problem25 = new Problem25();
    }

    @Test
    public void testProblem25() throws Exception {
        Assert.assertEquals(0, this.problem25.getFibIndex(1));
        Assert.assertEquals(7, this.problem25.getFibIndex(2));
        Assert.assertEquals(12, this.problem25.getFibIndex(3));
        Assert.assertEquals(4782, this.problem25.getFibIndex(1000));
    }
}
