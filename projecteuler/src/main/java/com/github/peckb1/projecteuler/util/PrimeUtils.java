package com.github.peckb1.projecteuler.util;

public class PrimeUtils {

    private PrimeUtils() { }

    public static boolean isPrimePE(long n) {
        if (n < 0) {
            return false;
        }

        // filter out 1
        if (n == 1) {
            return false;
        }

        // filter out 2, 3
        if (n < 4) {
            if (n == 2 || n == 3) {
                return true;
            }
        }

        // filter out 4, 6, 8
        if (n % 2 == 0) {
            return false;
        }

        // 1, 2, 3, 4, 6, 8 are already missing so
        // if we are < 9 - only 5 and 7 still remain
        if (n < 9) {
            return true;
        }

        if (n % 3 == 0) {
            return false;
        }

        double r = Math.floor(Math.sqrt(n));
        double f = 5;
        while (f <= r) {
            if (n % f == 0) {
                return false;
            }
            if (n % (f + 2) == 0) {
                return false;
            }

            f += 6;
        }

        return true;
    }

    public static boolean isPrime(long n) {
        // positives only
        if (n < 0) {
            return false;
        }

        // check if we are 2
        if (n == 2) {
            return true;
        }

        // check if n is a multiple of 2
        if (n % 2 == 0) {
            return false;
        }
        // if not, then just check the odds
        double upper = Math.sqrt(n);
        for (int i = 3; i <= upper; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
