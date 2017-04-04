package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ANDEquationTest {

    private ANDEquation andEquation;

    @Before
    public void setUp() throws Exception {
        this.andEquation = new ANDEquation();
    }

    @Test
    public void testTopCoderExamples() throws Exception {
        Assert.assertEquals(1, this.andEquation.restoreY(new int[]{1, 3, 5}));
        Assert.assertEquals(-1, this.andEquation.restoreY(new int[]{31, 7}));
        Assert.assertEquals(7, this.andEquation.restoreY(new int[]{31, 7, 7}));
        Assert.assertEquals(0, this.andEquation.restoreY(new int[]{1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1}));
        Assert.assertEquals(191411, this.andEquation.restoreY(new int[]{191411, 256951, 191411, 191411, 191411, 256951, 195507, 191411, 192435, 191411, 191411, 195511, 191419, 191411, 256947, 191415, 191475, 195579, 191415, 191411, 191483, 191411, 191419, 191475, 256947, 191411, 191411, 191411, 191419, 256947, 191411, 191411, 191411}));
        Assert.assertEquals(-1, this.andEquation.restoreY(new int[]{1362, 1066, 1659, 2010, 1912, 1720, 1851, 1593, 1799, 1805, 1139, 1493, 1141, 1163, 1211}));
        Assert.assertEquals(-1, this.andEquation.restoreY(new int[]{2, 3, 7, 19}));

    }
}
