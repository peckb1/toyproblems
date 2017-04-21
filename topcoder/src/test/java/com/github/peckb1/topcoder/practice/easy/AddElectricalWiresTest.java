package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddElectricalWiresTest {

    private AddElectricalWires addElectricalWires;

    @Before
    public void setUp() throws Exception {
        this.addElectricalWires = new AddElectricalWires();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(3,
                this.addElectricalWires.maxNewWires(new String[]{"000", "000", "000"}, new int[]{0}));

        Assert.assertEquals(1,
                this.addElectricalWires.maxNewWires(new String[]{"000", "000", "000"}, new int[]{0, 1}));

        Assert.assertEquals(0,
                this.addElectricalWires.maxNewWires(new String[]{"01", "10"}, new int[]{0}));

        Assert.assertEquals(0,
                this.addElectricalWires.maxNewWires(new String[]{"00000","00000","00000","00000","00000"}, new int[]{0,1,2,3,4}));

        Assert.assertEquals(3,
                this.addElectricalWires.maxNewWires(new String[]{"01000","10100","01010","00100","00000"}, new int[]{2,4}));
    }
}
