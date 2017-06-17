package com.github.peckb1.projecteuler.p031to040;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem31Test {

    private Problem31 problem31;

    @Before
    public void setUp() throws Exception {
        this.problem31 = new Problem31();
    }

    @Test
    public void testProblem40() throws Exception {
        Assert.assertEquals(1, this.problem31.possibleCombinations(200, new int[]{1}));
        Assert.assertEquals(101, this.problem31.possibleCombinations(200, new int[]{1, 2}));
        Assert.assertEquals(2081, this.problem31.possibleCombinations(200, new int[]{1, 2, 5}));
        Assert.assertEquals(15211, this.problem31.possibleCombinations(200, new int[]{1, 2, 5, 10}));
        Assert.assertEquals(47696, this.problem31.possibleCombinations(200, new int[]{1, 2, 5, 10, 20}));
        Assert.assertEquals(69118, this.problem31.possibleCombinations(200, new int[]{1, 2, 5, 10, 20, 50}));
        Assert.assertEquals(73681, this.problem31.possibleCombinations(200, new int[]{1, 2, 5, 10, 20, 50, 100}));
        Assert.assertEquals(73682, this.problem31.possibleCombinations(200, new int[]{1, 2, 5, 10, 20, 50, 100, 200}));
    }
}
