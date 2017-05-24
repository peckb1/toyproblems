package com.github.peckb1.projecteuler.p001to010;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Problem5Test {

    private Problem5 problem5;

    @Before
    public void setUp() throws Exception {
        this.problem5 = new Problem5();
    }

    @Test
    public void testProblem4() throws Exception {
        List<Long> oneToTen = LongStream.range(1, 11).boxed().collect(Collectors.toList());
        List<Long> oneToTwenty = LongStream.range(1, 21).boxed().collect(Collectors.toList());

        Assert.assertEquals(2_520, this.problem5.lcm(oneToTen));
        Assert.assertEquals(232_792_560, this.problem5.lcm(oneToTwenty));
    }
}
