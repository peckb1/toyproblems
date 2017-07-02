package com.github.peckb1.projecteuler.p041to050;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9
 * in some order, but it also has a rather interesting sub-string divisibility property.
 * <p>
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 * <p>
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class Problem43 {

    public static void main(String[] args) {
        System.out.println(new Problem43().subdivisiblePandigitals());
    }

    public long subdivisiblePandigitals() {
        AtomicLong sum = new AtomicLong(0);

        permutation("0123456789", pandigital -> {
            if (subDivisible(pandigital)) {
                sum.addAndGet(Long.parseLong(pandigital));
            }
        });

        return sum.get();
    }

    private boolean subDivisible(String pandigital) {
        return divisible(pandigital.substring(1, 4), 2) &
                divisible(pandigital.substring(2, 5), 3) &
                divisible(pandigital.substring(3, 6), 5) &
                divisible(pandigital.substring(4, 7), 7) &
                divisible(pandigital.substring(5, 8), 11) &
                divisible(pandigital.substring(6, 9), 13) &
                divisible(pandigital.substring(7, 10), 17);
    }

    private boolean divisible(String substring, int i) {
        return Integer.parseInt(substring) % i == 0;
    }

    /**
     * Thanks stack overflow :D
     * https://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string
     */
    private void permutation(String str, Consumer<String> callback) {
        permutation("", str, callback);
    }

    private void permutation(String prefix, String str, Consumer<String> callback) {
        int n = str.length();
        if (n == 0) {
            callback.accept(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), callback);
            }
        }
    }

}
