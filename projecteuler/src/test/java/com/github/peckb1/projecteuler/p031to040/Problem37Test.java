package com.github.peckb1.projecteuler.p031to040;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem37Test {

    private Problem37 problem37;

    @Before
    public void setUp() throws Exception {
        this.problem37 = new Problem37();
    }

    @Test
    public void testProblem37() throws Exception {
        Assert.assertEquals(748317, this.problem37.sumTruncatablePrimes());
    }
}
