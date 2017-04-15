package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccessChangerTest {

    private AccessChanger accessChangeer;

    @Before
    public void setUp() throws Exception {
        this.accessChangeer = new AccessChanger();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertArrayEquals(new String[]{"Test* t = new Test();", "t.a = 1;", "t.b = 2;", "t.go(); // a=1, b=2 --> a=2, b=3"},
                this.accessChangeer.convert(new String[]{"Test* t = new Test();", "t->a = 1;", "t->b = 2;", "t->go(); // a=1, b=2 --> a=2, b=3"}));

        Assert.assertArrayEquals(new String[]{"--. // the arrow --->", "---", "> // the parted arrow"},
                this.accessChangeer.convert(new String[]{"---> // the arrow --->", "---", "> // the parted arrow"}));

        Assert.assertArrayEquals(new String[]{".. // two successive arrows ->->"},
                this.accessChangeer.convert(new String[]{"->-> // two successive arrows ->->"}));
    }
}
