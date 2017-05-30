package com.github.peckb1.projecteuler.p011to020;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * <p>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following sequence:
 * <p>
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Problem14 {

    public int longestChain(int upperLimit) {
        int maxChain = 0;
        int largestChainNumber = -1;
        for (int i = upperLimit - 1; i >= upperLimit / 2; i--) {
            int chain = chain(i);
            maxChain = Math.max(maxChain, chain);
            if (maxChain == chain) {
                largestChainNumber = i;
            }
        }
        return largestChainNumber;
    }

    private int chain(long i) {
        int count = 0;
        while (i != 1) {
            count++;
            if (i % 2 == 0) {
                i = i / 2;
            } else {
                i = (3 * i) + 1;
            }
        }
        return count;
    }

}
