package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AimToTenTest {

    private AimToTen aimToTen;

    @Before
    public void setUp() throws Exception {
        this.aimToTen = new AimToTen();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(0, this.aimToTen.need(new int[]{9, 10, 10, 9}));

        Assert.assertEquals(4, this.aimToTen.need(new int[]{8, 9}));

        Assert.assertEquals(950, this.aimToTen.need(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

        Assert.assertEquals(0, this.aimToTen.need(new int[]{10, 10, 10, 10}));
    }
}
