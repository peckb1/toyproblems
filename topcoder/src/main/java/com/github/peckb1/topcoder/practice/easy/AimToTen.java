package com.github.peckb1.topcoder.practice.easy;

import java.util.Arrays;

/**
 * You are given a int[] marks containing the grades you have received so far in a class.
 * <p>
 * Each grade is between 0 and 10, inclusive.
 * <p>
 * Assuming that you will receive a 10 on all future assignments, determine the minimum number of future assignments
 * that are needed for you to receive a final grade of 10. You will receive a final grade of 10 if your
 * average grade is 9.5 or higher.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AimToTen {

    private static final Double DELTA = 0.000000001;

    public int need(int[] marks) {

        int currentGrades = marks.length;
        int currentTotal = Arrays.stream(marks).reduce(0, (x, y) -> x + y);

        double average = (double) currentTotal / (double) currentGrades;

        while (average + DELTA < 9.5) {
            currentTotal += 10;
            currentGrades += 1;
            average = (double) currentTotal / (double) currentGrades;
        }

        return currentGrades - marks.length;
    }

}
