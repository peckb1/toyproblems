package com.github.peckb1.projecteuler.p011to020;

import java.math.BigInteger;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 * <p>
 * How many such routes are there through a 20×20 grid?
 * <p>
 * https://en.wikipedia.org/wiki/Lattice_path
 * <p>
 * https://en.wikipedia.org/wiki/Binomial_coefficient
 */
public class Problem15 {

    /**
     * from (0, 0) to (a, b)
     * the number of combinations of a objects out of a set of a+b objects
     * a + b choose a
     * <p>
     * n choose k == n! / k!(n - k)!
     */
    public BigInteger routes(int N) {
        int n = N + N;
        int k = N;

        return factorial(n).divide( factorial(k).multiply( factorial(n - k) ) );
    }

    public static BigInteger factorial(int number) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

}
