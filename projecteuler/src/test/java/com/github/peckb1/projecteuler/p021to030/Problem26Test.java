package com.github.peckb1.projecteuler.p021to030;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem26Test {

    private Problem26 problem26;

    @Before
    public void setUp() throws Exception {
        this.problem26 = new Problem26();
    }

    @Test
    public void testProblem26() throws Exception {
        Assert.assertEquals(983, this.problem26.longestRepeatingDecimal(1000));
    }
}
