package com.github.peckb1.topcoder.practice.easy;

/**
 * Fox Ciel is playing a game called Addition Game.
 * <p>
 * Three numbers A, B and C are written on a blackboard, and Ciel initially has 0 points.
 * She repeats the following operation exactly N times: She chooses one of the three numbers on the blackboard.
 * Let X be the chosen number. She gains X points, and if X >= 1, the number X on the blackboard becomes X-1.
 * Otherwise, the number does not change.
 * <p>
 * Return the maximum number of points she can gain if she plays optimally.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AdditionGame {

    public int getMaximumPoints(int A, int B, int C, int N) {
        int points = 0;

        for(int i = 0 ; i < N; i++) {

            Integer max = max(A, B, C);

            points += max;

            if (max == A && max >= 1) {
                A--;
            } else if (max == B && max >= 1) {
                B--;
            } else if (max == C && max >= 1) {
                C--;
            }

        }

        return points;
    }

    private Integer max(Integer a, Integer b, Integer c) {
        if (a >= b && a >= c) {
            return a;
        }
        if (b >= a && b >= c) {
            return b;
        }
        return c;
    }

}
