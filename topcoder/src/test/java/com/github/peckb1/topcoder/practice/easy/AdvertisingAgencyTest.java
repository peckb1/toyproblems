package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdvertisingAgencyTest {

    private AdvertisingAgency advertisingAgency;

    @Before
    public void setUp() throws Exception {
        this.advertisingAgency = new AdvertisingAgency();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(0, this.advertisingAgency.numberOfRejections(new int[]{1, 2, 3}));

        Assert.assertEquals(2, this.advertisingAgency.numberOfRejections(new int[]{1, 1, 1}));

        Assert.assertEquals(2, this.advertisingAgency.numberOfRejections(new int[]{1, 2, 1, 2}));

        Assert.assertEquals(49, this.advertisingAgency.numberOfRejections(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
    }
}
