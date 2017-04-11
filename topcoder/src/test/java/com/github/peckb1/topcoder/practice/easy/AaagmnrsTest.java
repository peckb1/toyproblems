package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AaagmnrsTest {

    private Aaagmnrs aaagmnrs;

    @Before
    public void setUp() throws Exception {
        this.aaagmnrs = new Aaagmnrs();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertArrayEquals(
                new String[]{ "Aaagmnrs", "TopCoder" },
                this.aaagmnrs.anagrams(new String[]{ "Aaagmnrs", "TopCoder", "anagrams", "Drop Cote" }));

        Assert.assertArrayEquals(
                new String[] { "SnapDragon vs tomek" },
                this.aaagmnrs.anagrams(new String[]{ "SnapDragon vs tomek", "savants groped monk", "Adam vents prongs ok" }));

        Assert.assertArrayEquals(
                new String[]{ "Radar ghost jilts Kim", "patched hers first" },
                this.aaagmnrs.anagrams(new String[]{ "Radar ghost jilts Kim", "patched hers first", "DEPTH FIRST SEARCH", "DIJKSTRAS ALGORITHM" }));
    }
}
