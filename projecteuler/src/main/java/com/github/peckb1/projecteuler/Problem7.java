package com.github.peckb1.projecteuler;

public class Problem7 {

    public long findNthPrime(int n) {
        n = n - 1;

        long value = 2;
        int count = 0;
        do {
            if (isPrime(value)) {
                count++;
            }
            value++;
        } while (count != n);

        return value - 1;
    }

    private boolean isPrime(long n) {
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
