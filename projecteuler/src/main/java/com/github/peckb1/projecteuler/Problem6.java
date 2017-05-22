package com.github.peckb1.projecteuler;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class Problem6 {

    private static final BigInteger TWO = BigInteger.valueOf(2);
    private static final BigInteger SIX = BigInteger.valueOf(6);

    /**
     * Brute Force
     */
    public BigInteger sumSquareDifference(int lowInclusive, int highInclusive) {
        BigInteger sum = ZERO;
        BigInteger sum_sq = ZERO;
        for (int i = lowInclusive; i <= highInclusive; i++) {
            BigInteger I = BigInteger.valueOf(i);
            sum = sum.add(I);
            sum_sq = sum_sq.add(I.pow(2));
        }

        return sum.pow(2).subtract(sum_sq);
    }

    /**
     * Math!
     */
    public BigInteger sumSquareDifference(int limit) {
        BigInteger L = BigInteger.valueOf(limit);
        // SUM = ( L * (L + 1) ) / 2
        BigInteger sum = L.multiply(L.add(ONE)).divide(TWO);
        // SUM_SQ = ( ( ( 2 * L ) + 1 ) * (L + 1) * L ) / 6
        BigInteger sum_sq = TWO.multiply(L).add(ONE).multiply(L.add(ONE)).multiply(L).divide(SIX);
        return sum.pow(2).subtract(sum_sq);
    }

}
