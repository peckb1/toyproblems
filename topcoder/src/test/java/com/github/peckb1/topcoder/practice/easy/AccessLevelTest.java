package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccessLevelTest {

    private AccessLevel accessLevel;

    @Before
    public void setUp() throws Exception {
        this.accessLevel = new AccessLevel();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals("DDAAAA", this.accessLevel.canAccess(new int[]{0, 1, 2, 3, 4, 5}, 2));

        Assert.assertEquals("DDDDD", this.accessLevel.canAccess(new int[]{5, 3, 2, 10, 0}, 20));

        Assert.assertEquals("", this.accessLevel.canAccess(new int[]{}, 20));

        Assert.assertEquals("DADADD", this.accessLevel.canAccess(new int[]{34, 78, 9, 52, 11, 1}, 49));
    }
}
