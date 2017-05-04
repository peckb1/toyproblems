package com.github.peckb1.topcoder.practice.easy;

/**
 * Your friend's birthday is approaching, and he wants his age to be written in candles on his cake.
 * In fact, he has already placed several candles on the cake. The candles are arranged in a single row,
 * and there are two different colors of candles. One color represents the digit '0' and the other color
 * represents the digit '1'. You don't want to relayout the candles from scratch, so you have to determine
 * if there's a base for which the existing candles spell out your friend's age. To simplify the task, you can
 * choose any strictly positive base, not necessarily an integer one.
 * <p>
 * For example, if the candles are "00010" and your friend's age is 10, then the candles spell out 10
 * in base 10 (decimal). If the candles are "10101" and your friend's age is 21, then you can say that
 * "10101" is 21 in base 2 (binary). If the candles are "10100" and your friend's age is 6, then the
 * candles spell out 6 in base sqrt(2)=1.41421356237.... Note that you are not allowed to rotate the
 * cake, so "10" cannot be read as "01".
 * <p>
 * You are given a candlesLine, where the i-th character is the digit ('0' or '1') represented by the
 * i-th candle in the row of candles on the cake. You are also given an age, which is your friend's age.
 * Return the positive base for which the candles represent your friend's age. If there is no such base,
 * return -1, and if there are multiple such bases, return -2.
 * <p>
 * The number an an-1...a1 a0 in base B is equal to an*B^n + an-1*B^n-1 + ... + a1*B + a0.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AgeEncoding {

    private static final Double DELTA = 0.00000000001;

    public double getRadix(int age, String candlesLine) {
        // trim any leading 0s, except for the last one as any extras don't do anything
        while (candlesLine.length() > 1 && candlesLine.charAt(0) == '0') {
            candlesLine = candlesLine.substring(1);
        }

        if (candlesLine.equals("0")) {
            // if we're a 0 - then any base would work
            return -1;

        } else if (candlesLine.equals("1")) {
            if (age > 1) {
                // In any base, "1" represents the age of 1, any more are impossible
                return -1;
            } else {
                // In any base, "1" represents the age of 1.
                return -2;
            }
        }

        double lowBase = 0;
        double highBase = 1000;

        // the short cut means we don't actually iterate for all the values
        // but it's fun to use it :D
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            double midPointBase = (lowBase + highBase) / 2.0;
            double valueAtMidPointBase = eval(midPointBase, candlesLine.toCharArray());

            // short circuit to avoid running forever
            if (midPointBase - lowBase < DELTA && highBase - midPointBase < DELTA) {
                return lowBase;
            }

            if (valueAtMidPointBase < age) {
                lowBase = midPointBase;
            } else {
                highBase = midPointBase;
            }
        }
        return lowBase == 0 ? -1 : lowBase;
    }

    private double eval(double base, char[] characters) {
        double power = 1;
        double totalValue = 0;

        for (int i = characters.length - 1; i >= 0; i--) {
            if (characters[i] == '1') {
                totalValue += power;
            }
            power *= base;
        }

        return totalValue;
    }

}
