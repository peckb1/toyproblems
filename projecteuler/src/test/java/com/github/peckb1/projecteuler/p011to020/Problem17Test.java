package com.github.peckb1.projecteuler.p011to020;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem17Test {

    private Problem17 problem17;

    @Before
    public void setUp() throws Exception {
        this.problem17 = new Problem17();
    }

    @Test
    public void testProblem17() throws Exception {
        Assert.assertEquals(3, this.problem17.letterCounts(1));
        Assert.assertEquals(19, this.problem17.letterCounts(5));
        Assert.assertEquals(36, this.problem17.letterCounts(9));
        Assert.assertEquals(106, this.problem17.letterCounts(19));
        Assert.assertEquals(854, this.problem17.letterCounts(99));
        Assert.assertEquals(21113, this.problem17.letterCounts(999));
        Assert.assertEquals(21124 , this.problem17.letterCounts(1000));
    }
}
