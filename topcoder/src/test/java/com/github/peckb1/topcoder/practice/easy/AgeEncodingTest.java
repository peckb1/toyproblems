package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AgeEncodingTest {

    private AgeEncoding ageEncoding;

    @Before
    public void setUp() throws Exception {
        this.ageEncoding = new AgeEncoding();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(10.0,
                this.ageEncoding.getRadix(10, "00010"),
                0.0000000001);

        Assert.assertEquals(2.0,
                this.ageEncoding.getRadix(21, "10101"),
                0.0000000001);

        Assert.assertEquals(1.414213562373095,
                this.ageEncoding.getRadix(6, "10100"),
                0.0000000001);

        Assert.assertEquals(0.9685012944510603,
                this.ageEncoding.getRadix(21, "10111111110111101111111100111111110111111111111100"),
                0.0000000001);

        Assert.assertEquals(-2.0,
                this.ageEncoding.getRadix(1, "1"),
                0.0000000001);

        Assert.assertEquals(1.0,
                this.ageEncoding.getRadix(1, "001000"),
                0.0000000001);
    }
}
