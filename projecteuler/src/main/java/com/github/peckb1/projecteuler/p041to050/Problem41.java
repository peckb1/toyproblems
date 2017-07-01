package com.github.peckb1.projecteuler.p041to050;

import com.github.peckb1.projecteuler.util.PrimeUtils;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 * <p>
 * What is the largest n-digit pandigital prime that exists?
 */
public class Problem41 {

    public static void main(String[] args) {
        System.out.println(new Problem41().largestPandigitalPrime());
    }

    public int largestPandigitalPrime() {
        List<String> pandigitalBases = Lists.newArrayList(
            "123456789", "12345678", "1234567", "123456", "12345", "1234", "123", "12", "1"
        );

        AtomicInteger largestPrime = new AtomicInteger(0);
        for(int i = 0; i < pandigitalBases.size() && largestPrime.get() == 0; i++) {
            permutation(pandigitalBases.get(i), pandigitalNumber -> {
                int number = Integer.parseInt(pandigitalNumber);
                boolean isPrime = PrimeUtils.isPrime(number);
                if (isPrime) {
                    if (number > largestPrime.get()) {
                        largestPrime.set(number);
                    }
                }
            });
        }

        return largestPrime.get();
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
