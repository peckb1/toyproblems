package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AutogameTest {

    private Autogame autogame;

    @Before
    public void setUp() throws Exception {
        this.autogame = new Autogame();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(8, this.autogame.wayscnt(new int[]{1, 2, 3}, 5));

        Assert.assertEquals(4, this.autogame.wayscnt(new int[]{1, 1, 1}, 1));

        Assert.assertEquals(4, this.autogame.wayscnt(new int[]{2, 1}, 42));

        Assert.assertEquals(9, this.autogame.wayscnt(new int[]{2, 3, 4, 3}, 3));

        Assert.assertEquals(18, this.autogame.wayscnt(new int[]{4, 4, 3, 2, 1}, 3));
    }
}
