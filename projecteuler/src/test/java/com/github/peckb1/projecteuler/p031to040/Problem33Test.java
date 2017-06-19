package com.github.peckb1.projecteuler.p031to040;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem33Test {

    private Problem33 problem33;

    @Before
    public void setUp() throws Exception {
        this.problem33 = new Problem33();
    }

    @Test
    public void testProblem33() throws Exception {
        Assert.assertEquals(100, this.problem33.digitCancelingFractions());
    }
}
