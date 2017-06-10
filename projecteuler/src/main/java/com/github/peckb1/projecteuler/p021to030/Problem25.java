package com.github.peckb1.projecteuler.p021to030;

import java.math.BigInteger;

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 * <p>
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 * <p>
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 * <p>
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem25 {

    public static void main(String[] args) {
        System.out.println(new Problem25().getFibIndex(1000));
    }

    public long getFibIndex(int digitLength) {
        int len = 0;
        int index = -1;
        while (len < digitLength) {
            index ++;
            BigInteger fibonacci = fibonacci(index);
            len = fibonacci.toString().length();
        }
        return index;
    }

    private static BigInteger fibonacci(long n) {
        BigInteger x = BigInteger.ZERO;
        BigInteger y = BigInteger.ONE;
        BigInteger z = BigInteger.ONE;

        for (long i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x.add(y);
        }
        return x;
    }
}
