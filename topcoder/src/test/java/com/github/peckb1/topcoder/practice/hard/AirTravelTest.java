package com.github.peckb1.topcoder.practice.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AirTravelTest {

    private static final double DELTA = 0.000000001;

    private AirTravel airTravel;

    @Before
    public void setUp() throws Exception {
        this.airTravel = new AirTravel();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(10612.237799994255,
                this.airTravel.shortestTrip(new int[]{0, 0, 70}, new int[]{90, 0, 45}, new String[]{"2", "0 2", "0 1"}, 0, 1),
                DELTA);

        Assert.assertEquals(6283.185307179586,
                this.airTravel.shortestTrip(new int[]{0, 0, 70}, new int[]{90, 0, 45}, new String[]{"1 2", "0 2", "0 1"}, 0, 1),
                DELTA);

        Assert.assertEquals(0.0,
                this.airTravel.shortestTrip(new int[]{0, 30, 60}, new int[]{25, -130, 78}, new String[]{"1 2", "0 2", "1 2"}, 0, 0),
                DELTA);

        Assert.assertEquals(-1.0,
                this.airTravel.shortestTrip(new int[]{0, 20, 55}, new int[]{-20, 85, 42}, new String[]{"1", "0", "0"}, 0, 2),
                DELTA);
    }

}
