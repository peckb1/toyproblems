package com.github.peckb1.topcoder.practice.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ATaleOfThreeCitiesTest {

    private ATaleOfThreeCities aTaleOfThreeCities;

    @Before
    public void setUp() throws Exception {
        this.aTaleOfThreeCities = new ATaleOfThreeCities();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(3.414213562373095, this.aTaleOfThreeCities.connect(
                new int[]{0, 0, 0},
                new int[]{0, 1, 2},
                new int[]{2, 3},
                new int[]{1, 1},
                new int[]{1, 5},
                new int[]{3, 28}), 0.00000000000001);

        Assert.assertEquals(2.0, this.aTaleOfThreeCities.connect(
                new int[]{-2, -1, 0, 1, 2},
                new int[]{0, 0, 0, 0, 0},
                new int[]{-2, -1, 0, 1, 2},
                new int[]{1, 1, 1, 1, 1},
                new int[]{-2, -1, 0, 1, 2},
                new int[]{2, 2, 2, 2, 2}), 0.00000000000001);

        Assert.assertEquals(50.323397776611024, this.aTaleOfThreeCities.connect(
                new int[]{4, 5, 11, 21, 8, 10, 3, 9, 5, 6},
                new int[]{12, 8, 9, 12, 2, 3, 5, 7, 10, 13},
                new int[]{34, 35, 36, 41, 32, 39, 41, 37, 39, 50},
                new int[]{51, 33, 41, 45, 48, 22, 33, 51, 41, 40},
                new int[]{86, 75, 78, 81, 89, 77, 83, 88, 99, 77},
                new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90, 100}), 0.00000000000001);
    }
}
