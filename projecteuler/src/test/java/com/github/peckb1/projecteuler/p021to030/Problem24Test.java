package com.github.peckb1.projecteuler.p021to030;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem24Test {

    private Problem24 problem24;

    @Before
    public void setUp() throws Exception {
        this.problem24 = new Problem24();
    }

    @Test
    public void testProblem24() throws Exception {
        Assert.assertEquals("0123456789", this.problem24.lexicographic(1, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Assert.assertEquals("0123456798", this.problem24.lexicographic(2, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Assert.assertEquals("2783915460", this.problem24.lexicographic(1000000, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Assert.assertEquals("9876543201", this.problem24.lexicographic(3628799, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Assert.assertEquals("9876543210", this.problem24.lexicographic(3628800, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
