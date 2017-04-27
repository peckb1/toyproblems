package com.github.peckb1.topcoder.practice.easy;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdditionGameTest {

    private AdditionGame addtionGame;

    @Before
    public void setUp() throws Exception {
        this.addtionGame = new AdditionGame();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(13, this.addtionGame.getMaximumPoints(3, 4, 5, 3));

        Assert.assertEquals(3, this.addtionGame.getMaximumPoints(1,1,1,8));

        Assert.assertEquals(1140, this.addtionGame.getMaximumPoints(3, 5, 48, 40));

        Assert.assertEquals(446, this.addtionGame.getMaximumPoints(36, 36, 36, 13));

        Assert.assertEquals(57, this.addtionGame.getMaximumPoints(8, 2, 6, 13));
    }
}
