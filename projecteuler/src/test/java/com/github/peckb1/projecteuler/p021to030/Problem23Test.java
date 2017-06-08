package com.github.peckb1.projecteuler.p021to030;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem23Test {

    private Problem23 problem23;

    @Before
    public void setUp() throws Exception {
        this.problem23 = new Problem23();
    }

    @Test
    public void testProblem23() throws Exception {
        Assert.assertEquals(4179871, this.problem23.abundantSums());
    }
}
