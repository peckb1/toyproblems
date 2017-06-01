package com.github.peckb1.projecteuler.p011to020;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * <p>
 * What is the sum of the digits of the number 2^1000?
 */
public class Problem16 {

    public BigInteger powerDigitSum(int power) {
        BigInteger largeValue = BigInteger.valueOf(2).pow(power);
        String valueAsString = largeValue.toString();

        BigInteger sum = ZERO;
        for(int i = 0; i < valueAsString.length(); i++) {
            sum = sum.add(BigInteger.valueOf(valueAsString.charAt(i) - '0'));
        }

        return sum;
    }

}
