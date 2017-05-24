package com.github.peckb1.projecteuler.p001to010;

import java.util.ArrayList;
import java.util.List;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {

    /**
     * Brute Force
     */
    public List<Integer> primeFactors(long value) {
        List<Integer> factors = new ArrayList<>();

        // divide until we're an odd number
        if (value % 2 == 0) {
            factors.add(2);
            value = value / 2;
        }

        for (int i = 3; i <= Math.sqrt(value); i += 2) {
            if (value % i == 0 && isPrime(i)) {
                factors.add(i);
            }
        }

        return factors;
    }

    private boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n % 2 == 0) {
            return false;
        }
        //if not, then just check the odds
        double upper = Math.sqrt(n);
        for (int i = 3; i <= upper; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
