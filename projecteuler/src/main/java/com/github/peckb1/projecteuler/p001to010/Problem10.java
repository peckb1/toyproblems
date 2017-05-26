package com.github.peckb1.projecteuler.p001to010;

import com.github.peckb1.projecteuler.util.PrimeUtils;

import java.math.BigInteger;

import static java.math.BigInteger.ZERO;
import static java.math.BigInteger.valueOf;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sum of all the primes below two million.
 */
public class Problem10 {

    public BigInteger sumPrimes(int upperLimit) {
        BigInteger sum = ZERO;

        if (upperLimit >= 2) {
            sum = sum.add(valueOf(2));
        }

        for(int i = 3; i < upperLimit; i += 2) {
            if (PrimeUtils.isPrime(i)) {
                sum = sum.add(BigInteger.valueOf(i));
            }
        }

        return sum;
    }

}
