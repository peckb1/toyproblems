package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddMultiplyTest {

    private AddMultiply addMultiply;

    @Before
    public void setUp() throws Exception {
        this.addMultiply = new AddMultiply();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertArrayEquals(new int[]{2, 2, 2}, this.addMultiply.makeExpression(6));

        Assert.assertArrayEquals(new int[]{4, 2, 3}, this.addMultiply.makeExpression(11));

        Assert.assertArrayEquals(new int[]{-5, 2, 10}, this.addMultiply.makeExpression(0));

        Assert.assertArrayEquals(new int[]{249, 2, 2}, this.addMultiply.makeExpression(500));

        Assert.assertArrayEquals(new int[]{-3, 2, 11}, this.addMultiply.makeExpression(5));
    }
}
