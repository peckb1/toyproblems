package com.github.peckb1.projecteuler.p001to010;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of
 * two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {

    private final static int DIGITS = 3;

    public long palindrome() {
        // create our upper value
        int upper = 0;
        for (int i = 0; i < DIGITS; i++) {
            upper += 9 * Math.pow(10, i);
        }

        // iterate through all possible palindromes
        for (int i = upper; i > 0; i--) {
            String u = String.valueOf(i);
            int palindrome = Integer.parseInt(u + reverse(u));

            // setup a predicate to check if a digit is three digits or not
            final Predicate<? super Integer> threeDigit = x -> 100 <= x && x <= 999;

            // create the list of three digit factors
            List<Integer> threeDigitFactors = divisors(palindrome).stream().filter(threeDigit).collect(Collectors.toList());
            // sort the list by ascending order
            threeDigitFactors.sort(Comparator.reverseOrder());

            // find a palindrome with two three digit factors
            for (Integer factor : threeDigitFactors) {
                if (palindrome % factor == 0) {
                    int value = palindrome / factor;
                    if (threeDigit.test(value)) {
                        return palindrome;
                    }
                }
            }
        }

        return 0;
    }

    private String reverse(String u) {
        return new StringBuffer(u).reverse().toString();
    }

    private List<Integer> divisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        divisors.add(n);
        return divisors;
    }

}
