package com.github.peckb1.topcoder.practice.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdaptiveRoutingTest {

    private AdaptiveRouting adaptiveRouting;

    @Before
    public void setUp() throws Exception {
        this.adaptiveRouting = new AdaptiveRouting();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(3,
                this.adaptiveRouting.deliveryTime(
                        new String[]{"1 2 1", "2 3 1", "2 5 1", "3 4 1", "4 6 1", "5 6 1"},
                        new int[]{},
                        1,
                        6));

        Assert.assertEquals(4,
                this.adaptiveRouting.deliveryTime(
                        new String[]{"1 2 1", "2 3 1", "2 5 1", "3 4 1", "4 6 1", "5 6 1"},
                        new int[]{5},
                        1,
                        6));

        Assert.assertEquals(22,
                this.adaptiveRouting.deliveryTime(
                        new String[]{"1 2 1", "1 2 22"},
                        new int[]{0},
                        1,
                        2));

        Assert.assertEquals(108,
                this.adaptiveRouting.deliveryTime(
                        new String[]{"4 3 100", "2 4 3", "3 2 1", "2 5 1", "4 1 2", "5 4 1"},
                        new int[]{2, 5},
                        1,
                        3));

        Assert.assertEquals(9,
                this.adaptiveRouting.deliveryTime(
                        new String[]{"10 12 5", "10 11 2", "11 12 3"},
                        new int[]{2},
                        10,
                        12));

        Assert.assertEquals(12,
                this.adaptiveRouting.deliveryTime(
                        new String[]{"53 21 6", "53 21 4", "9 85 4", "9 90 7", "53 90 1", "21 9 7", "85 7 5", "90 47 7", "85 9 3", "53 85 5", "7 47 9", "53 7 9", "7 47 1", "21 47 6", "90 47 2"},
                        new int[]{14, 9, 7, 8, 0, 3},
                        53,
                        47));

        Assert.assertEquals(-1,
                this.adaptiveRouting.deliveryTime(
                        new String[]{"65 37 24", "37 2 66", "65 37 32", "65 46 97", "65 3 52", "37 3 66", "65 77 50", "3 56 99", "77 3 100", "3 2 39", "46 3 75", "56 46 79", "46 2 83", "3 77 73", "3 2 60", "77 2 90"},
                        new int[]{10, 4, 0, 3, 8, 15, 12, 1, 13, 9, 7, 2},
                        65,
                        2));
    }
}
