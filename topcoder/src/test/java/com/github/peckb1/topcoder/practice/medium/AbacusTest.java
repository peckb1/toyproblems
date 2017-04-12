package com.github.peckb1.topcoder.practice.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbacusTest {

    private Abacus abacus;

    @Before
    public void setUp() throws Exception {
        this.abacus = new Abacus();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertArrayEquals(
                new String[]{"ooo---oooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "o---oooooooo", "ooooo---oooo"},
                this.abacus.add(new String[]{"ooo---oooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "oo---ooooooo", "---ooooooooo"},
                        5));

        Assert.assertArrayEquals(
                new String[]{"oo---ooooooo", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---"},
                this.abacus.add(new String[]{"ooo---oooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "oo---ooooooo", "---ooooooooo"},
                        21));

        Assert.assertArrayEquals(
                new String[]{"oooooooo---o", "---ooooooooo", "ooooooooo---", "---ooooooooo", "oo---ooooooo", "---ooooooooo" },
                this.abacus.add(new String[]{"ooooooooo---", "---ooooooooo", "ooooooooo---", "---ooooooooo", "oo---ooooooo", "---ooooooooo"},
                        100000));

        Assert.assertArrayEquals(
                new String[]{"---ooooooooo", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---", "ooooooooo---" },
                this.abacus.add(new String[]{"o---oooooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo", "---ooooooooo" },
                        1));
    }
}
