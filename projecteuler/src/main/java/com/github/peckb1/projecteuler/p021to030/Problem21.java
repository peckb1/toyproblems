package com.github.peckb1.projecteuler.p021to030;

import java.util.ArrayList;
import java.util.List;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called
 * amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem21 {

    public int sumAmicableNumbers(int upperBound) {
        int[] numbers = new int[upperBound];
        int sumOfPairs = 0;
        for(int i = 1; i < upperBound; i++) {
            int divisorSum = divisorSum(i);
            numbers[i] = divisorSum;
            if (divisorSum < upperBound && numbers[divisorSum] == i && divisorSum != i) {
                sumOfPairs += divisorSum + i;
            }
        }
        return sumOfPairs;
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
