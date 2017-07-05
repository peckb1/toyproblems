package com.github.peckb1.projecteuler.p041to050;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem44Test {

    private Problem44 problem44;

    @Before
    public void setUp() throws Exception {
        this.problem44 = new Problem44();
    }

    @Test
    public void testProblem42() throws Exception {
        Assert.assertEquals(5482660, this.problem44.pentagonalDifference());
    }

}
