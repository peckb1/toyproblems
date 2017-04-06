package com.github.peckb1.topcoder.practice.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ASeriesTest {

    private ASeries aSeries;

    @Before
    public void setUp() throws Exception {
        this.aSeries = new ASeries();
    }

    @Test
    public void tetTopcoderExamples() throws Exception {
        Assert.assertEquals(5, this.aSeries.longest(new int[]{3,8,4,5,6,2,2}));
        Assert.assertEquals(3, this.aSeries.longest(new int[]{-1,-5,1,3}));
        Assert.assertEquals(3, this.aSeries.longest(new int[]{-10,-20,-10,-10}));
    }
}
