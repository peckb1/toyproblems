package com.github.peckb1.projecteuler.p011to020;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * <p>
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * <p>
 * Find the sum of the digits in the number 100!
 */
public class Problem20 {

    public long sumDigitFactorial(int n) {

        BigInteger factorial = factorial(n);

        String s = factorial.toString();
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }

        return sum;
    }

    private static BigInteger factorial(int n) {
        BigInteger result = ONE;
        for (; n > 1; n--) {
            result = result.multiply(BigInteger.valueOf(n));
        }
        return result;
    }
}
