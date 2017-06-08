package com.github.peckb1.projecteuler.p021to030;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28
 * is a perfect number.
 * <p>
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant
 * if this sum exceeds n.
 * <p>
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as
 * the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater
 * than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced
 * any further by analysis even though it is known that the greatest number that cannot be expressed as the
 * sum of two abundant numbers is less than this limit.
 * <p>
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class Problem23 {

    private static final int MAX = 28123;

    public long abundantSums() {

        Set<Integer> abundants = new TreeSet<>();

        for (int i = 1; i <= MAX; i++) {
            int divisorSum = divisorSum(i);
            if (divisorSum > i) {
                abundants.add(i);
            }
        }

        long total = 0;
        for (int i = 1; i < MAX; i++) {
            if (!sumOfAbundants(abundants, i)) {
                total += i;
            }
        }

        return total;
    }

    private boolean sumOfAbundants(Set<Integer> abundants, int n) {
        for (int a : abundants) {
            if (a > n) {
                return false;
            }
            if (abundants.contains(n - a)) {
                return true;
            }
        }
        return false;
    }

    private int divisorSum(int i) {
        return divisors(i).stream().reduce(0, (x, y) -> x + y);
    }

    private List<Integer> divisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }
}
