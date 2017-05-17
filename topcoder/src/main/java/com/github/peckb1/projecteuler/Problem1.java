package com.github.peckb1.projecteuler;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.Predicate;

/**
 * If we list all the natural numbers below 10 that are sumOfMultiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these sumOfMultiples is 23.
 * <p>
 * Find the sum of all the sumOfMultiples of 3 or 5 below 1000.
 */
public class Problem1 {

    private static final int LIMIT = 1_000;

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();

        long t1 = System.currentTimeMillis();
        BigInteger solution01 = problem1.sumOfMultiples(new int[]{3, 5}, LIMIT);
        long t2 = System.currentTimeMillis();
        BigInteger solution02 = problem1.sumOfMultiples(3, 5, LIMIT);
        long t3 = System.currentTimeMillis();

        System.out.println(String.format("%s millis : %s", (t2 - t1), solution01));
        System.out.println(String.format("%s millis : %s", (t3 - t2), solution02));
    }

    /**
     * Math method
     */
    public BigInteger sumOfMultiples(int m1, int m2, int exclusiveUpperLimit) {
        BigInteger sumM1 = sum(m1, exclusiveUpperLimit);
        BigInteger sumM2 = sum(m2, exclusiveUpperLimit);
        BigInteger sumM1AndM2 = sum(m1 * m2, exclusiveUpperLimit);

        return sumM1.add(sumM2).subtract(sumM1AndM2);
    }

    private BigInteger sum(int n, int exclusiveUpperLimit) {
        BigInteger values = BigInteger.valueOf((exclusiveUpperLimit - 1) / n);
        // 1 + 2 + 3 + 4 + ... values
        //          ===
        // 1/2 values * (values + 1)
        return BigInteger.valueOf(n).multiply(values.multiply(values.add(BigInteger.ONE))).divide(BigInteger.valueOf(2));
    }

    /**
     * Brute Force Method
     */
    public BigInteger sumOfMultiples(int[] multiples, int exclusiveUpperLimit) {
        BigInteger sum = BigInteger.ZERO;
        int gcd = gcd(multiples);

        Predicate<Integer> multiple = integer -> {
            for (final int m : multiples) {
                if (integer % m == 0) {
                    return true;
                }
            }
            return false;
        };
        for(int n = 1; n < exclusiveUpperLimit; n += gcd) {
            if (multiple.test(n)) {
                sum = sum.add(BigInteger.valueOf(n));
            }
        }
        return sum;
    }

    private int gcd(int[] multiples) {
        return Arrays.stream(multiples).reduce((left, right) -> {
            while (left != 0 && right != 0) {
                int temp = right;
                right = left % right;
                left = temp;
            }
            return left + right;
        }).orElse(1);
    }

}
