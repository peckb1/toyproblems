package com.github.peckb1.projecteuler.p011to020;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem12Test {

    private Problem12 problem12;

    @Before
    public void setUp() throws Exception {
        this.problem12 = new Problem12();
    }

    @Test
    public void testProblem12() throws Exception {
        Assert.assertEquals(28, this.problem12.triangleNumber(5));
        Assert.assertEquals(76576500, this.problem12.triangleNumber(500));
    }
}
