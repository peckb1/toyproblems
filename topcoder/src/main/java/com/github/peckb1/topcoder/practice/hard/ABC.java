package com.github.peckb1.topcoder.practice.hard;

/**
 * You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:
 * <p>
 * The string has exactly N characters, each of which is either 'A', 'B' or 'C'.
 * The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] < s[j].
 * If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class ABC {

    public static void main(String[] args) {
        ABC abc = new ABC();
        int min = 3;
        int max = 30;

        System.out.println(abc.createString(8, 21));
        for (int n = min; n <= max; n++) {
            System.out.println();
            int maxK = (n * (n - 1)) / 2;
            for (int k = 0; k <= maxK; k++) {
                String abcString = abc.createString(n, k);
                System.out.println(String.format("N = %s, K = %d --- %s", n, k, abcString));
            }
        }
    }

    public String createString(int N, int K) {
        // add in a coupld short circuits
        // if we need no pairs - just use C's
        if (K == 0) {
            return fillWithCs(N);
        }
        int maxK = maxABC(N);
        // if we are past the maximum allowable just return ""
        if (K > maxK) {
            return "";
        }
        // if we are at the max we can return the known max value
        if (K == maxK) {
            return maxString(N);
        }

        // setup our running variables
        StringBuilder resultBuilder = new StringBuilder();
        int runningPairTotal = 0;
        int numAsBeforeMe = 0;
        int numBsBeforeMe = 0;
        int me = 1; // technically never changes - but easier to read further down

        // iterate through our list
        for (int i = N; i > 0; i--) {
            // if our pair matches K - then we just want a bunch of Cs
            if (runningPairTotal == K) {
                append(resultBuilder, 'C', i);
                return resultBuilder.toString();
            }

            int spacesAfterMe = i - 1;
            int maximumAllowedA = N / 3;

            // since the easiest way to get a value is to put the As before the Bs, which go before the Cs
            // stop bothering to see if we need 'A' values if we have ever put a 'B' in the list, or it
            // we have surpassed the largest number of 'A' values in the max string

            // Why stop? Our point algorithm only works when the number of 'A' is less than the max 'A'
            if (numAsBeforeMe < maximumAllowedA) {
                int pairsForA = spacesAfterMe - numAsBeforeMe;

                // we want to add an A if we can - but make sure that we don't loose out on a value
                // so if A has the most points AND its pairs doesn't go past our K we can add it
                if (runningPairTotal + pairsForA <= K) {
                    runningPairTotal += pairsForA;
                    resultBuilder.append('A');
                    numAsBeforeMe++;
                    continue;
                }
                // we didn't add an 'A', and there is no reason to add a 'B' while we were still
                // less than the maximumAllowedA values
                resultBuilder.append('C');
            } else {
                // we have added all of the 'A' values that we can to reach our maximum value
                // but still have not found runningPairTotal == K so lets start adding 'B' values
                int pairsForB = spacesAfterMe - numBsBeforeMe;

                // If adding a 'B' here doesn't have us go over the K limit add it in
                if (runningPairTotal + pairsForB <= K) {
                    runningPairTotal += pairsForB;
                    resultBuilder.append('B');
                    numBsBeforeMe++;
                    continue;
                }
                // otherwise add a 'C'
                resultBuilder.append('C');
            }
        }

        return resultBuilder.toString();
    }

    /**
     * return the maximum value ABC String for a given N
     */
    private String maxString(int N) {
        int third = N / 3;
        int remainder = N % 3;

        int As = third + ((remainder >= 1) ? 1 : 0);
        int Bs = third + ((remainder >= 2) ? 1 : 0);
        int Cs = third;

        StringBuilder resultBuilder = new StringBuilder();
        append(resultBuilder, 'A', As);
        append(resultBuilder, 'B', Bs);
        append(resultBuilder, 'C', Cs);
        return resultBuilder.toString();
    }

    /**
     * A helper method for just filling an entire N with C's
     */
    private String fillWithCs(int N) {
        StringBuilder sb = new StringBuilder();
        append(sb, 'C', N);
        return sb.toString();
    }

    /**
     * helper value for just adding to a String builder a bunch of times
     */
    private void append(StringBuilder builder, char character, int numToAdd) {
        for(int i = 0; i < numToAdd; i++) {
            builder.append(character);
        }
    }

    /**
     * return only the numerical maximum allowed for an ABC string
     */
    private int maxABC(int N) {
        int third = N / 3;
        int remainder = N % 3;

        int As = third + ((remainder >= 1) ? 1 : 0);
        int Bs = third + ((remainder >= 2) ? 1 : 0);
        int Cs = third;

        return ((Bs + Cs) * As) + (Bs * Cs);
    }
}
