package com.github.peckb1.projecteuler.p031to040;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem32Test {

    private Problem32 problem32;

    @Before
    public void setUp() throws Exception {
        this.problem32 = new Problem32();
    }

    @Test
    public void testProblem32() throws Exception {
        Assert.assertEquals(0, this.problem32.pandigitalSums("1"));
        Assert.assertEquals(0, this.problem32.pandigitalSums("12"));
        Assert.assertEquals(0, this.problem32.pandigitalSums("123"));
        Assert.assertEquals(12, this.problem32.pandigitalSums("1234"));
        Assert.assertEquals(52, this.problem32.pandigitalSums("12345"));
        Assert.assertEquals(162, this.problem32.pandigitalSums("123456"));
        Assert.assertEquals(0, this.problem32.pandigitalSums("1234567"));
        Assert.assertEquals(13458, this.problem32.pandigitalSums("12345678"));
        Assert.assertEquals(45228, this.problem32.pandigitalSums("123456789"));
    }
}
