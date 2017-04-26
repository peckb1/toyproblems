package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AdditionCyclesTest {

    private AdditionCycles additionCycles;

    @Before
    public void setUp() throws Exception {
        this.additionCycles = new AdditionCycles();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(4, this.additionCycles.cycleLength(26));

        Assert.assertEquals(3, this.additionCycles.cycleLength(55));

        Assert.assertEquals(1, this.additionCycles.cycleLength(0));

        Assert.assertEquals(12, this.additionCycles.cycleLength(71));
    }
}
