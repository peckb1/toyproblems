package com.github.peckb1.projecteuler;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem7Test {

    private Problem7 problem7;

    @Before
    public void setUp() throws Exception {
        this.problem7 = new Problem7();
    }

    @Test
    public void testProblem7() throws Exception {
        Assert.assertEquals(2, this.problem7.findNthPrime(1));
        Assert.assertEquals(3, this.problem7.findNthPrime(2));
        Assert.assertEquals(5, this.problem7.findNthPrime(3));
        Assert.assertEquals(7, this.problem7.findNthPrime(4));
        Assert.assertEquals(11, this.problem7.findNthPrime(5));
        Assert.assertEquals(13, this.problem7.findNthPrime(6));
        Assert.assertEquals(104743, this.problem7.findNthPrime(10001));
    }
}
