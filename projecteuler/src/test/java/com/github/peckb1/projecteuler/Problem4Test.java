package com.github.peckb1.projecteuler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem4Test {

    private Problem4 problem4;

    @Before
    public void setUp() throws Exception {
        this.problem4 = new Problem4();
    }

    @Test
    public void testProblem4() throws Exception {
        Assert.assertEquals(906609, this.problem4.palindrome());
    }
}
