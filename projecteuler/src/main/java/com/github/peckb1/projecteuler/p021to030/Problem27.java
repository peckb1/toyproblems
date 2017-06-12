package com.github.peckb1.projecteuler.p021to030;

import com.github.peckb1.projecteuler.util.PrimeUtils;

/**
 * Euler discovered the remarkable quadratic formula:
 * <p>
 * n^2 + n + 41
 * It turns out that the formula will produce 40 primes for the consecutive integer values 0 ≤ n ≤ 39. However,
 * when n=40, 40^2+40+41 = 40(40+1)+41 is divisible by 41, and certainly when
 * n=41,41^2+41+41 is clearly divisible by 41.
 * <p>
 * The incredible formula n^2−79n+1601 was discovered, which produces 80 primes for the consecutive
 * values 0≤n≤790≤n≤79. The product of the coefficients, −79 and 1601, is −126479.
 * <p>
 * Considering quadratics of the form:
 * <p>
 * n^2 + an + b, where |a|<1000 and |b|≤1000
 * <p>
 * where |n| is the modulus/absolute value of n
 * e.g. |11|=11 and |−4|=4
 * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum
 * number of primes for consecutive values of n, starting with n=0.
 */
public class Problem27 {

    private static final int LOW_A = -999;
    private static final int HIGH_A = 999;
    private static final int LOW_B = -1000;
    private static final int HIGH_B = 1000;

    public long productCoefficients() {
        int bestA = 0;
        int bestB = 0;
        int bestChain = -1;

        for (int a = LOW_A; a <= HIGH_A; a++) {
            for (int b = LOW_B; b <= HIGH_B; b++) {
                int n = 0;
                while (PrimeUtils.isPrimePE(n * n + a * n + b)) {
                    n++;
                }
                if (n > bestChain) {
                    bestA = a;
                    bestB = b;
                    bestChain = n;
                }
            }
        }

        return bestA * bestB;
    }

}
