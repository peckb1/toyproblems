package com.github.peckb1.projecteuler.p031to040;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem36Test {

    private Problem36 problem36;

    @Before
    public void setUp() throws Exception {
        this.problem36 = new Problem36();
    }

    @Test
    public void testProblem36() throws Exception {
        Assert.assertEquals(0, this.problem36.sumOfPalindromicNumbers(1));
        Assert.assertEquals(25, this.problem36.sumOfPalindromicNumbers(10));
        Assert.assertEquals(157, this.problem36.sumOfPalindromicNumbers(100));
        Assert.assertEquals(1772, this.problem36.sumOfPalindromicNumbers(1_000));
        Assert.assertEquals(18228, this.problem36.sumOfPalindromicNumbers(10_000));
        Assert.assertEquals(286602, this.problem36.sumOfPalindromicNumbers(100_000));
        Assert.assertEquals(872187, this.problem36.sumOfPalindromicNumbers(1_000_000));
    }
}
