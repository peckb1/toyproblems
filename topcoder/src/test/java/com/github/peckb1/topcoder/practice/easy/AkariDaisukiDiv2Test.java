package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AkariDaisukiDiv2Test {

    private AkariDaisukiDiv2 akariDaisukiDiv2;

    @Before
    public void setUp() throws Exception {
        this.akariDaisukiDiv2 = new AkariDaisukiDiv2();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(2, this.akariDaisukiDiv2.countTuples("topcoderdivtwo"));

        Assert.assertEquals(0, this.akariDaisukiDiv2.countTuples("foxciel"));

        Assert.assertEquals(4, this.akariDaisukiDiv2.countTuples("magicalgirl"));

        Assert.assertEquals(75, this.akariDaisukiDiv2.countTuples("waaiusushioakariusushiodaisuki"));

        Assert.assertEquals(8924, this.akariDaisukiDiv2.countTuples("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));

    }
}
