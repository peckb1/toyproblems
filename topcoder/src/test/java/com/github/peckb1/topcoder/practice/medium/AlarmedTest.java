package com.github.peckb1.topcoder.practice.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlarmedTest {

    private static final double DELTA = 1e-8;
    private Alarmed alarmed;

    @Before
    public void setUp() throws Exception {
        this.alarmed = new Alarmed();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(347.99999999999994,
                this.alarmed.noise(new int[]{50},new int[]{2},new int[]{87}),
                DELTA);

        Assert.assertEquals(2400.9999999999995,
                this.alarmed.noise(new int[]{1,99},new int[]{50,50},new int[]{1,1}),
                DELTA);

        Assert.assertEquals(1537.9999999999998,
                this.alarmed.noise(new int[]{3,11,2,62,91},new int[]{90,10,75,25,50},new int[] {5,4,3,2,1}),
                DELTA);

        Assert.assertEquals( 3295.5717878751793,
                this.alarmed.noise(new int[]{1,99},new int[]{50,50},new int[]{1,2}),
                DELTA);
    }
}
