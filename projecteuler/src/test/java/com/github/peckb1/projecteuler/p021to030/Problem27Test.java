package com.github.peckb1.projecteuler.p021to030;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem27Test {

    private Problem27 problem27;

    @Before
    public void setUp() throws Exception {
        this.problem27 = new Problem27();
    }

    @Test
    public void testProblem27() throws Exception {
        Assert.assertEquals(-59231, this.problem27.productCoefficients());
    }
}
