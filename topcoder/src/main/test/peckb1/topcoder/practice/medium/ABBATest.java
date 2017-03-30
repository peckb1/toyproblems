package peckb1.topcoder.practice.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ABBATest {

    private ABBA abba;

    @Before
    public void setUp() throws Exception {
        this.abba = new ABBA();
    }

    @Test
    public void testTopCoderExamples() throws Exception {
        Assert.assertEquals(ABBA.POSSIBLE, this.abba.canObtain("B", "ABBA"));
        Assert.assertEquals(ABBA.IMPOSSIBLE, this.abba.canObtain("AB", "ABB"));
        Assert.assertEquals(ABBA.IMPOSSIBLE, this.abba.canObtain("BBAB", "ABABABABB"));
        Assert.assertEquals(ABBA.POSSIBLE, this.abba.canObtain("BBBBABABBBBBBA", "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA"));
    }
}
