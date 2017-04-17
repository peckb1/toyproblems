package com.github.peckb1.topcoder.practice.easy;

import java.util.Arrays;

/**
 * You are working for the financial institution TopBank, and you have been tasked with writing a module that will take
 * an initial account balance, along with a list of that day's transactions, and return the ending balance for the day.
 * <p>
 * Each transaction will be either a credit, which adds funds to the account, or a debit, which removes funds
 * from the account. If a debit exceeds the available funds at the time, then the account balance will go negative.
 * You will be given an startingBalance, the initial account balance. You will also be given a transactions,
 * the list of transactions for the day. Each element of transactions will be in the form "type amount"
 * (quotes added for clarity). Each type will be 'C' or 'D', for credit or debit, respectively.
 * <p>
 * Each amount will be an integer between 1 and 1000000, inclusive, with no leading zeros.
 * You are to return an representing the ending balance after processing all of the transactions.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AccountBalance {

    public int processTransactions(int startingBalance, String[] transactions) {
        for(String transaction: transactions) {
            String[] details = transaction.split(" ");
            String type = details[0];
            int amount = Integer.parseInt(details[1]);
            if (type.equals("C")) {
                startingBalance += amount;
            } else if (type.equals("D")) {
                startingBalance -= amount;
            } else {
                throw new IllegalArgumentException("Malformed Transation: " + transaction);
            }
        }

        return startingBalance;
    }

}
