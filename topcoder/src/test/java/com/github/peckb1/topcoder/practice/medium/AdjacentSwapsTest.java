package com.github.peckb1.topcoder.practice.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdjacentSwapsTest {

    private AdjacentSwaps adjacentSwaps;

    @Before
    public void setUp() throws Exception {
        this.adjacentSwaps = new AdjacentSwaps();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(1, this.adjacentSwaps.theCount(new int[]{1, 2, 0}));

        Assert.assertEquals(0, this.adjacentSwaps.theCount(new int[]{0, 1}));

        Assert.assertEquals(2, this.adjacentSwaps.theCount(new int[]{2, 0, 3, 1}));

        Assert.assertEquals(0, this.adjacentSwaps.theCount(new int[]{1, 0, 3, 2}));

        Assert.assertEquals(0, this.adjacentSwaps.theCount(new int[]{2, 0, 3, 1, 5, 6, 4}));

        Assert.assertEquals(716743312, this.adjacentSwaps.theCount(new int[]{1, 3, 0, 5, 2, 7, 4, 8, 10, 6, 12, 9, 14, 11, 16, 13, 18, 15, 19, 17}));
    }
}
