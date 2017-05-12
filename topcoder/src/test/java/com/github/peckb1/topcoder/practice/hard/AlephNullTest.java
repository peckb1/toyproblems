package com.github.peckb1.topcoder.practice.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlephNullTest {

    private AlephNull alephNull;

    @Before
    public void setUp() throws Exception {
        this.alephNull = new AlephNull();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertArrayEquals(new int[]{0, 1}, this.alephNull.rational(1, 0));

        Assert.assertArrayEquals(new int[]{1, 0}, this.alephNull.rational(1, 1));

        Assert.assertArrayEquals(new int[]{0, 0}, this.alephNull.rational(1, 2));

        Assert.assertArrayEquals(new int[]{1, 3}, this.alephNull.rational(4, 1));

        Assert.assertArrayEquals(new int[]{2, 1}, this.alephNull.rational(4, 6));

        Assert.assertArrayEquals(new int[]{5, 3}, this.alephNull.rational(5, 11));

        Assert.assertArrayEquals(new int[]{9, 7}, this.alephNull.rational(8, 70));

        Assert.assertArrayEquals(new int[]{43, 12}, this.alephNull.rational(10, 467));

        Assert.assertArrayEquals(new int[]{438, 43}, this.alephNull.rational(23, 4190316));

        Assert.assertArrayEquals(new int[]{7, 157}, this.alephNull.rational(30, 100));

        Assert.assertArrayEquals(new int[]{1, 0}, this.alephNull.rational(30, 536870912));

        Assert.assertArrayEquals(new int[]{29, 1}, this.alephNull.rational(30, 536870911));
    }
}
