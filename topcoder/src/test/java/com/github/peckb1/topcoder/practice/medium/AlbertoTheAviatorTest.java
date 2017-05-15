package com.github.peckb1.topcoder.practice.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlbertoTheAviatorTest {

    private AlbertoTheAviator albertoTheAviator;

    @Before
    public void setUp() throws Exception {
        this.albertoTheAviator = new AlbertoTheAviator();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(1, this.albertoTheAviator.MaximumFlights(10, new int[]{10}, new int[]{0}));

        Assert.assertEquals(2, this.albertoTheAviator.MaximumFlights(10, new int[]{8, 4}, new int[]{0, 2}));

        Assert.assertEquals(3, this.albertoTheAviator.MaximumFlights(12, new int[]{4, 8, 2, 1}, new int[]{2, 0, 0, 0}));

        Assert.assertEquals(2, this.albertoTheAviator.MaximumFlights(9, new int[]{4, 6}, new int[]{0, 1}));

        Assert.assertEquals(0, this.albertoTheAviator.MaximumFlights(100, new int[]{101}, new int[]{100}));

        Assert.assertEquals(3, this.albertoTheAviator.MaximumFlights(1947, new int[]{2407, 2979, 1269, 2401, 3227, 2230, 3991, 2133, 3338, 356, 2535, 3859, 3267, 365}, new int[]{2406, 793, 905, 2400, 1789, 2229, 1378, 2132, 1815, 355, 72, 3858, 3266, 364}));
    }
}
