package com.github.peckb1.projecteuler.p031to040;

import com.github.peckb1.projecteuler.util.PrimeUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 * <p>
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * <p>
 * How many circular primes are there below one million?
 */
public class Problem35 {

    private final Set<Integer> knownPrimes;

    public Problem35() {
        this.knownPrimes = new HashSet<>();
    }

    public int circularPrimes(int upperBound) {
        int circularPrimeCount = 0;

        for (int i = 2; i < upperBound; i++) {
            int digits = (int) (Math.log10(i) + 1);
            int n = i;
            boolean allGood = true;
            for(int d = 0; d < digits; d++) {
                n = (int) ((n % 10) * Math.pow(10, digits - 1) + (n / 10));
                if (!knownPrimes.contains(n) && !PrimeUtils.isPrimePE(n)) {
                    allGood = false;
                } else {
                    knownPrimes.add(n);
                }
            }
            if (allGood) {
                circularPrimeCount++;
            }
        }

        return circularPrimeCount;
    }

}
