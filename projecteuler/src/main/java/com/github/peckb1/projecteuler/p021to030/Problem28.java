package com.github.peckb1.projecteuler.p021to030;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * <p>
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * <p>
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * <p>
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class Problem28 {

    public long diagonalSum(int N) {
        // odds only please
        if (N % 2 == 0) {
            return -1;
        }

        long largest = N * N;
        long sum = 0;
        while(largest > 1) {
            for(int i = 0; i < 4; i++) {
                sum += largest;
                largest -= (N - 1);
            }
            N -= 2;
        }

        return sum + 1;
    }

}
