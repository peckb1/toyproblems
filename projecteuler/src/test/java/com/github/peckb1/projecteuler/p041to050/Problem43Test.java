package com.github.peckb1.projecteuler.p041to050;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem43Test {

    private Problem43 problem43;

    @Before
    public void setUp() throws Exception {
        this.problem43 = new Problem43();
    }

    @Test
    public void testProblem42() throws Exception {
        Assert.assertEquals(16695334890L, this.problem43.subdivisiblePandigitals());
    }

}
