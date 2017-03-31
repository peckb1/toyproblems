package com.github.peckb1.topcoder.practice.easy;

/**
 * You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:
 *
 * The string has exactly N characters, each of which is either 'A' or 'B'.
 * The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
 * If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
 *
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AB {

    public String createString(int N, int K) {
        if (K > max(N)) {
            return "";
        }

        String result = "";
        int currentValue = 0;
        int missingLetters = 1;

        for (int i = N; i > 0; i--) {
            if (currentValue == K) {
                result += 'B';
                continue;
            }

            int maxAddIfSwap = (i - missingLetters);
            if (maxAddIfSwap + currentValue <= K) {
                result += 'A';
                missingLetters++;
                currentValue += maxAddIfSwap;
            } else {
                result += 'B';
            }
        }

        return result;
    }

    private int max(int N) {
        int midway = N / 2;
        int difference = N - midway;
        return midway * difference;
    }

}
