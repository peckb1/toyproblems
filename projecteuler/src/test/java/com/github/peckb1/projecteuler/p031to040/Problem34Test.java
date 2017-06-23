package com.github.peckb1.projecteuler.p031to040;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem34Test {

    private Problem34 problem34;

    @Before
    public void setUp() throws Exception {
        this.problem34 = new Problem34();
    }

    @Test
    public void testProblem34() throws Exception {
        Assert.assertEquals(40730, this.problem34.digitFactorials());
    }
}
