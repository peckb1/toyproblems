package com.github.peckb1.topcoder.practice.easy;

/**
 * Start with any integer between 00 and 99, inclusive, written as two digits (use a leading zero if the number
 * is less than 10). Add the two digits together. Now concatenate the rightmost digit of the first number with
 * the rightmost digit of the sum to get a new number. If you repeat this process enough times, you'll end up
 * back at the original number. For example:
 * <p>
 * Combine Second Digits of
 * Start With    Add Digits    the Original and the Sum
 * ------------------------------------------------------
 * 26     :   2+6 = 08   :   "6" and "8" = 68
 * 68     :   6+8 = 14   :   "8" and "4" = 84
 * 84     :   8+4 = 12   :   "4" and "2" = 42
 * 42     :   4+2 = 06   :   "2" and "6" = 26
 * <p>
 * In this case, it took us 4 steps to get back to where we started, so we would return 4. Starting with n,
 * return the number of steps it takes to get back to n.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AdditionCycles {

    public int cycleLength(int n) {
        int count = 0;

        int newValue = n;
        do {
            newValue = nextValue(newValue);
            count++;
        } while (newValue != n);

        return count;
    }

    private int nextValue(int n) {
        int ones = n % 10;
        int tens = ((n % 100) - ones) / 10;
        int newOnes = (ones + tens) % 10;
        int newTens = ones * 10;
        return newTens + newOnes;
    }

}
