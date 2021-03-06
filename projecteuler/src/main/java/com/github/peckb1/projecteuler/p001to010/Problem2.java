package com.github.peckb1.projecteuler.p001to010;

import java.math.BigInteger;

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2,
 * the first 10 terms will be:
 * <p>
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * <p>
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 */
public class Problem2 {

    public BigInteger fibEvenSum(int limit) {
        BigInteger sum = BigInteger.ZERO;

        int first = 1;
        int second = 1;
        int next = first + second;
        while (next <= limit) {
            if (next % 2 == 0) {
                sum = sum.add(BigInteger.valueOf(next));
            }
            first = second;
            second = next;
            next = first + second;
        }

        return sum;
    }
}
