package com.github.peckb1.projecteuler.p001to010;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * <p>
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 {

    public int productOfTriplet(int sum) {
        // a < b < c
        for (int a = 1; a <= sum - 2; a++) {
            for (int b = a + 1; b <= sum - 1; b++) {
                // a + b + c = sum
                int c = sum - a - b;

                if (c <= b) {
                    continue;
                }

                if ((c * c) == (a * a) + (b * b)) {
                    // return a * b * c
                    return a * b * c;
                }
            }
        }

        return -1;
    }

}
