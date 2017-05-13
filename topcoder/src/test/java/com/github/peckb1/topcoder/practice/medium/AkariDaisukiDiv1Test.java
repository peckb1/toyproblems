package com.github.peckb1.topcoder.practice.medium;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AkariDaisukiDiv1Test {

    private AkariDaisukiDiv1 akariDaisukiDiv1;

    @Before
    public void setUp() throws Exception {
        this.akariDaisukiDiv1 = new AkariDaisukiDiv1();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(2, this.akariDaisukiDiv1.countF("a", "b", "c", "x", "axb", 2));

        Assert.assertEquals(0, this.akariDaisukiDiv1.countF("a", "b", "c", "x", "abcdefghij", 1));

        Assert.assertEquals(4, this.akariDaisukiDiv1.countF("a", "a", "a", "b", "aba", 2));

        Assert.assertEquals(191690599, this.akariDaisukiDiv1.countF("a", "b", "c", "d", "baadbdcbadbdccccbaaaadbdcbadbdccbaadbdcba", 58));

        Assert.assertEquals(1, this.akariDaisukiDiv1.countF("a", "x", "y", "b", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 49));

        Assert.assertEquals(127859200, this.akariDaisukiDiv1.countF("waai", "akari","daisuki", "usushio", "id", 10000000));
    }
}
