package com.github.peckb1.projecteuler.p021to030;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * <p>
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 * As 1 = 14 is not a sum it is not included.
 * <p>
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * <p>
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Problem30 {

    public static void main(String[] args) {
        System.out.println(new Problem30().sumDigitPowers(4));
        System.out.println(new Problem30().sumDigitPowers(5));
    }

    public int sumDigitPowers(int power) {
        int[] digitPowers = new int[10];
        for(int i = 0; i < digitPowers.length; i++) {
            digitPowers[i] = (int) Math.pow(i + 1, power);
        }

        List<Integer> foundValues = new ArrayList<>();
        for(int i = 2; i < Math.pow(10, power + 1); i++) {
            int sumOfPowers = 0;
            int number = i;
            while (number > 0) {
                int d = number % 10;
                number /= 10;

                int temp = (int) Math.pow(d, power);
                sumOfPowers += temp;
            }

            if (sumOfPowers == i) {
                foundValues.add(i);
            }
        }

        return foundValues.stream().reduce((x, y) -> x + y).orElse(0);
    }

}
