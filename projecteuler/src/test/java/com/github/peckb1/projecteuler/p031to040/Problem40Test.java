package com.github.peckb1.projecteuler.p031to040;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem40Test {

    private Problem40 problem40;

    @Before
    public void setUp() throws Exception {
        this.problem40 = new Problem40();
    }

    @Test
    public void testProblem40() throws Exception {
        Assert.assertEquals(210, problem40.productOfDigits());
    }

}
