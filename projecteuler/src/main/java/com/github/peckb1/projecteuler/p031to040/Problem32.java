package com.github.peckb1.projecteuler.p031to040;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
 * for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 * <p>
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier,
 * and product is 1 through 9 pandigital.
 * <p>
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1
 * through 9 pandigital.
 * <p>
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class Problem32 {

    public int pandigitalSums(String digitString) {
        Set<Integer> products = new HashSet<>();
        final int N = (digitString.length() / 2);

        permutation(digitString, permutation -> {
            for(int a = 1; a <= N; a++) {
                for(int b = 1; b <= N && a + b < digitString.length(); b++) {

                    int A = Integer.parseInt(permutation.substring(0, a));
                    int B = Integer.parseInt(permutation.substring(a, a + b));
                    int C = Integer.parseInt(permutation.substring(a + b));

                    if (A * B == C) {
                        products.add(C);
                    }
                }
            }
        });

        return products.stream().reduce((x, y) -> x + y).orElse(0);
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
