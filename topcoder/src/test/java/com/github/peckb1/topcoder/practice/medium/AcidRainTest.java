package com.github.peckb1.topcoder.practice.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AcidRainTest {

    private AcidRain acidRain;

    @Before
    public void setUp() throws Exception {
        this.acidRain = new AcidRain();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(0,
                this.acidRain.saveHarvest(new int[]{1},
                        new int[]{2},
                        new int[]{1}));

        Assert.assertEquals(0,
                this.acidRain.saveHarvest(new int[]{1, 2},
                        new int[]{2, 3},
                        new int[]{1, 1}));

        Assert.assertEquals(0,
                this.acidRain.saveHarvest(new int[]{0, 1},
                        new int[]{1, 3},
                        new int[]{100, 100}));

        Assert.assertEquals(1,
                this.acidRain.saveHarvest(new int[]{0, 1},
                        new int[]{2, 4},
                        new int[]{1, 2}));

        Assert.assertEquals(2,
                this.acidRain.saveHarvest(new int[]{1, 0, 3, 5},
                        new int[]{4, 3, 5, 6},
                        new int[]{10, 3, 1000, 8}));
    }
}
