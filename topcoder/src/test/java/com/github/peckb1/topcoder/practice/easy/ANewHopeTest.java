package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ANewHopeTest {

    private ANewHope aNewHope;

    @Before
    public void setUp() throws Exception {
        this.aNewHope = new ANewHope();
    }

    @Test
    public void testTopcodeExamples() throws Exception {
        Assert.assertEquals(4, this.aNewHope.count(
                new int[]{1,2,3,4},
                new int[]{4,3,2,1},
                3));

        Assert.assertEquals(3, this.aNewHope.count(
                new int[]{8,5,4,1,7,6,3,2},
                new int[]{2,4,6,8,1,3,5,7},
                3));


        Assert.assertEquals(1, this.aNewHope.count(
                new int[]{1,2,3,4},
                new int[]{1,2,3,4},
                2));
    }
}
