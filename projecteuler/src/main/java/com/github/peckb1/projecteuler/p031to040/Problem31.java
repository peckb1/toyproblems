package com.github.peckb1.projecteuler.p031to040;

/**
 * Created by peckb oIn England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * <p>
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 * <p>
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins? 6/5/17.
 */
public class Problem31 {

    public int possibleCombinations(int total, int[] denominations) {
        int[] ways = new int[total + 1];
        ways[0] = 1;

        for (final int denomination : denominations) {
            for (int j = denomination; j <= total; j++) {
                ways[j] += ways[j - denomination];
            }
        }

        return ways[total];
    }

}
