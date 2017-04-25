package com.github.peckb1.topcoder.practice.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ActivateGameTest {

    private ActivateGame activateGame;

    @Before
    public void setUp() throws Exception {
        this.activateGame = new ActivateGame();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(69,
                this.activateGame.findMaxScore(new String[]{"05", "aB"}));

        Assert.assertEquals(7,
        this.activateGame.findMaxScore(new String[]{"03", "21"}));

        Assert.assertEquals(118,
        this.activateGame.findMaxScore(new String[]{"John", "Brus", "Gogo"}));

        Assert.assertEquals(0,
        this.activateGame.findMaxScore(new String[]{"AAA", "AAA", "AAA"}));
    }
}
