package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AirwaysTest {

    private static final double DELTA = 1e-8;
    private Airways airways;

    @Before
    public void setUp() throws Exception {
        this.airways = new Airways();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(437.99999999999994, this.airways.distance(3, -219, 0), DELTA);

        Assert.assertEquals(171.0, this.airways.distance(3, 171, 0), DELTA);

        Assert.assertEquals(3344.0000000000005, this.airways.distance(4, 233, 3111), DELTA);

        Assert.assertEquals(4243.534462721784, this.airways.distance(14, -3840, -1768), DELTA);
    }
}
