package com.github.peckb1.topcoder.practice.easy;

import java.util.Arrays;

/**
 * An AND-equation is an equation that looks like this:
 * X[0] AND X[1] AND ... AND X[N-1] = Y
 * Here X[i] and Y are non-negative integers and the bitwise AND operation is defined in the Notes.
 * <p>
 * In C++, C#, and Java the operator AND is denoted "&". So for example (P & Q & R) is the bitwise AND of
 * numbers P, Q, and R. In VB the same operator is denoted "And".
 * <p>
 * You are given a A that contains exactly N+1 elements. Your task is to construct an AND-equation using each
 * element of A exactly once. (That is, N of them will be on the left hand side of the AND-equation and the
 * remaining one will be on the right hand side.) If this is possible, return the value of Y in this AND-equation.
 * If no AND-equation can be constructed, return -1. (It can be shown that for each A there is at most one possible
 * value Y, so the return value is always defined correctly.)
 * <p>
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class ANDEquation {

    private final int MAX_VALUE = 1048575;

    public int restoreY(int[] A) {
        Arrays.sort(A);

        int result = MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            result = result & A[i];
        }
        if (result == A[0]) {
            return result;
        } else {
            return -1;
        }
    }

}
