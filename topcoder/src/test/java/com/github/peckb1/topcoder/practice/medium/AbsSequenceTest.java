package com.github.peckb1.topcoder.practice.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbsSequenceTest {

    private AbsSequence absSequence;

    @Before
    public void setUp() throws Exception {
        this.absSequence = new AbsSequence();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertArrayEquals(new String[]{"21", "12", "9", "3", "6"},
                this.absSequence.getElements("21", "12", new String[]{"0", "1", "2", "3", "4"}));

        Assert.assertArrayEquals(new String[]{"0"},
                this.absSequence.getElements("0", "0", new String[]{"1000000000000000000"}));

        Assert.assertArrayEquals(new String[]{"117", "470", "2", "823", "115", "87", "49", "25", "115", "23"},
                this.absSequence.getElements("823", "470", new String[]{"3", "1", "31", "0", "8", "29", "57", "75", "8", "77"}));

        Assert.assertArrayEquals(new String[]{"178470", "108270", "90", "0", "90", "90", "710370", "90", "0", "0" },
                this.absSequence.getElements("710370", "177300", new String[]{"5","95","164721","418","3387","710","0","1197","19507","5848"}));
    }
}
