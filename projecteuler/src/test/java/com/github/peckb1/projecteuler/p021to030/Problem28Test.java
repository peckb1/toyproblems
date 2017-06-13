package com.github.peckb1.projecteuler.p021to030;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem28Test {

    private Problem28 problem28;

    @Before
    public void setUp() throws Exception {
        this.problem28 = new Problem28();
    }

    @Test
    public void testProblem28() throws Exception {
        Assert.assertEquals(1, this.problem28.diagonalSum(1));
        Assert.assertEquals(25, this.problem28.diagonalSum(3));
        Assert.assertEquals(101, this.problem28.diagonalSum(5));
        Assert.assertEquals(669171001, this.problem28.diagonalSum(1001));
    }
}
