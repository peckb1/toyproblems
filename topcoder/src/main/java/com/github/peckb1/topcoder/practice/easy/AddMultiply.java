package com.github.peckb1.topcoder.practice.easy;

/**
 * You are given an y. We are looking for any x that satisfies the following constraints:
 * <p>
 * - x has exactly three elements
 * - ( x[0] * x[1] ) + x[2] = y
 * - Each x[i] must be between -1000 and 1000, inclusive.
 * - No x[i] can be equal to 0 or 1.
 * Find and return one such x.
 * <p>
 * If there are multiple valid solutions, you may return any of them.
 * You may assume that for our constraints on y (specified below) at least one valid x always exists.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AddMultiply {

    public int[] makeExpression(int y) {
        int[] results = new int[3];

        if (y % 2 == 0) {
            // are we an even number?
            if (Math.abs(y) <= 5) {
                // do we need to handle the shenanigans around the [-5, 5] range?
                results[2] = 10;
            } else {
                // if not, just make the value 2
                results[2] = 2;
            }
        } else {
            // do we need to handle the shenanigans around the [-5, 5] range?
            if (Math.abs(y) <= 5) {
                results[2] = 11;
            } else {
                // if not, just make the value 3
                results[2] = 3;
            }
        }

        // set y to be our new even number which is going to be >= 4
        y -= results[2];

        // set our mid point to be 2, since we know we have an even number
        results[1] = 2;

        // set our first number to be whatever it needs to be based on the fact we know we have an even number
        results[0] = y / results[1];

        return results;
    }

}
