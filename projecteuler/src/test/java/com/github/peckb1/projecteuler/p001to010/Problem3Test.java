package com.github.peckb1.projecteuler.p001to010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Problem3Test {

    private Problem3 problem3;

    @Before
    public void setUp() throws Exception {
        this.problem3 = new Problem3();
    }

    @Test
    public void testProblem3() throws Exception {
        Integer largestFactor = this.problem3.primeFactors(600_851_475_143L).stream().reduce(1, Math::max);
        Assert.assertEquals(new Integer(6857), largestFactor);
    }

}
