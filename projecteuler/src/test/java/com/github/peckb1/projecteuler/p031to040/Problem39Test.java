package com.github.peckb1.projecteuler.p031to040;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem39Test {

    private Problem39 problem39;

    @Before
    public void setUp() throws Exception {
        this.problem39 = new Problem39();
    }

    @Test
    public void testProblem39() throws Exception {
        Assert.assertEquals(840, this.problem39.maximumIntegralSolutions());
    }
}
