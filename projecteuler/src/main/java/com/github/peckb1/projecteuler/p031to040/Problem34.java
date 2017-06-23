package com.github.peckb1.projecteuler.p031to040;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * <p>
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * <p>
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem34 {

    public long digitFactorials() {
        int result = 0;
        for (int i = 10; i < factorial(10).intValue(); i++) {
            BigInteger sumOfFacts = ZERO;
            int number = i;
            while (number > 0) {
                int d = number % 10;
                number /= 10;
                sumOfFacts = sumOfFacts.add(factorial(d));
            }

            if (sumOfFacts.intValue() == i) {
                result += i;
            }
        }
        return result;
    }

    private static BigInteger factorial(int n) {
        BigInteger result = ONE;
        for (; n > 1; n--) {
            result = result.multiply(BigInteger.valueOf(n));
        }
        return result;
    }

}
