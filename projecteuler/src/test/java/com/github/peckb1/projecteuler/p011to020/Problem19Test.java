package com.github.peckb1.projecteuler.p011to020;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class Problem19Test {

    private Problem19 problem19;

    @Before
    public void setUp() throws Exception {
        this.problem19 = new Problem19();
    }

    @Test
    public void testProblem19() throws Exception {
        LocalDate start = LocalDate.of(1901, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2001, Month.JANUARY, 1);
        Assert.assertEquals(171, this.problem19.sundays(start, end));
    }
}
