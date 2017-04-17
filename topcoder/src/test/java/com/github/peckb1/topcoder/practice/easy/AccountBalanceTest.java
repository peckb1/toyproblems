package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountBalanceTest {

    private AccountBalance accountBalance;

    @Before
    public void setUp() throws Exception {
        this.accountBalance = new AccountBalance();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(250,
                this.accountBalance.processTransactions(100, new String[]{"C 1000", "D 500", "D 350"}));

        Assert.assertEquals(100,
                this.accountBalance.processTransactions(100, new String[]{}));

        Assert.assertEquals(-10,
                this.accountBalance.processTransactions(100, new String[]{"D 50", "D 20", "D 40"}));

        Assert.assertEquals(10580,
                this.accountBalance.processTransactions(53874, new String[]{"D 1234", "C 987", "D 2345", "C 654", "D 6789", "D 34567"}));
    }
}
