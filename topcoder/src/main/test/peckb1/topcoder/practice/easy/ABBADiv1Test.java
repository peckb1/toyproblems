package peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ABBADiv1Test {

    private ABBADiv1 abbaDiv1;

    @Before
    public void setUp() throws Exception {
        this.abbaDiv1 = new ABBADiv1();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(ABBADiv1.POSSIBLE, this.abbaDiv1.canObtain("A", "BABA"));
        Assert.assertEquals(ABBADiv1.POSSIBLE, this.abbaDiv1.canObtain("BAAAAABAA", "BAABAAAAAB"));
        Assert.assertEquals(ABBADiv1.IMPOSSIBLE, this.abbaDiv1.canObtain("A", "ABBA"));
        Assert.assertEquals(ABBADiv1.POSSIBLE, this.abbaDiv1.canObtain("AAABBAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB"));
        Assert.assertEquals(ABBADiv1.IMPOSSIBLE, this.abbaDiv1.canObtain("AAABAAABB", "BAABAAABAABAABBBAAAAAABBAABBBBBBBABB"));
    }
}
