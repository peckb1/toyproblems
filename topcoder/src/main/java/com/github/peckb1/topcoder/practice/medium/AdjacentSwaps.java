package com.github.peckb1.topcoder.practice.medium;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Cat Taro has N cards. He arranged the cards in a row and wrote numbers 0 through N-1 on them from left to right.
 * He wants to rearrange them so that p[i] is written on the i-th (0-indexed) card from the left.
 * <p>
 * He asked N-1 rabbits to rearrange the cards. The rabbits are numbered from 0 to N-2, and the i-th rabbit can swap
 * the i-th and the (i+1)-th card from the left. A permutation of rabbits q[0], ..., q[N-2] is called good if having
 * the rabbits performed exactly their operations in this order, p[i] is written on the i-th card from the left.
 * <p>
 * Return the number of good permutations of rabbits, modulo 1,000,000,007.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AdjacentSwaps {

    private static final BigInteger MODULO = BigInteger.valueOf(1_000_000_007);

    private List<List<BigInteger>> maximumSplitCombinations;

    public int theCount(int[] p) {
        this.maximumSplitCombinations = generateMaximumCombinations(p.length);

        BigInteger combinations = swap(p, 0, p.length, 0);
        return combinations.mod(MODULO).intValue();
    }

    /**
     * Pre generate the maximum number of combinations that a rabbit's split
     * could have
     * <p>
     * starting at the base of length 2 - we know that we can have a single split [a, b] --> [a] & [b]
     * so we start our list of known values
     * [1]
     * <p>
     * with length 3 we have two splits [a, b, c] -> [a, b] & [c] && [a, b] and [c]
     * we already know that [a, b] has a value of 1 so we use 1 for that, and ignore any one length elements
     * our list of values then becomes
     * [[1],
     *  [1 1]]
     * <p>
     * with a length 4 we have three splits [a, b, c, d] -> [a, b, c] & [d] && [a, b] & [c, d] && [a, b, c] & [d]
     * the first split has a value of 1 and then an ignored single item - ignored items reset the entire thing to 1
     * the second split has two values of 1
     * the last split is again a single value of 1, and an ignored value
     * our list then becomes
     * [[1],
     *  [1 1],
     *  [1 2 1]]
     * <p>
     * The rest of the data can be filled out using what we know about the previous values
     * Length 5
     * [[1],
     *  [1 1],
     *  [1 2 1],
     *  [1 3 3 1]] - the edges are ignored with a split value of 0 being found
     *             - the two in the middle end up with a 2/3 and a 3/2 split - and since [3] is a 2 and [2] is a 1; 1 + 2 == 3
     * <p>
     * This list is generated for however large the list of entries is
     * so that we can easily reference it later
     * </pre>
     */
    private static List<List<BigInteger>> generateMaximumCombinations(int length) {
        List<List<BigInteger>> maximumCombinations = new ArrayList<>();
        maximumCombinations.add(new ArrayList<>());
        maximumCombinations.get(0).add(ONE);

        for (int i = 1; i < length - 1; i++) {
            List<BigInteger> data = new ArrayList<>();

            maximumCombinations.add(i, data);
            data.add(ONE);

            for (int j = 1; j < maximumCombinations.get(i - 1).size() + 1; j++) {
                data.add(loadCombination(maximumCombinations, i - 1, j).add(loadCombination(maximumCombinations, i - 1, j - 1)));
            }
        }
        return maximumCombinations;
    }

    /**
     * Helper function for creating the maximum number of combinations.
     */
    private static BigInteger loadCombination(List<List<BigInteger>> maximumCombinations, int i, int j) {
        try {
            return maximumCombinations.get(i).get(j);
        } catch (IndexOutOfBoundsException e) {
            return ZERO;
        }
    }

    private BigInteger swap(int[] p, int start, int length, int depth) {
        // if there is only a single element just return
        // that there is a single permutation which will correctly sort the list
        if (length == 1) {
            return ONE;
        }

        BigInteger res = ZERO;

        // iterate over our known rabbits and see if swapping each rabbit (first) would
        // help, or harm our overall status of getting to a correct solution
        for (int rabbit = 0; rabbit < length - 1; rabbit++) {
            // have the rabbit swap his values
            int tmp = p[rabbit];
            p[rabbit] = p[rabbit + 1];
            p[rabbit + 1] = tmp;

            boolean betterSortOrder = true;

            // check that the rabbit half of the list would be in sorted order
            for (int i = 0; i <= rabbit; i++) {
                if (p[i] > rabbit) {
                    betterSortOrder = false;
                }
            }

            // check that the second half of the list would be in sorted order
            for (int i = rabbit + 1; i < length; i++) {
                if (p[i] <= rabbit) {
                    betterSortOrder = false;
                }
            }

            if (betterSortOrder) {
                // split the array into two pieces
                // the (0, rabbit] section
                int[] a = new int[rabbit + 1];
                for (int i = 0; i <= rabbit; i++) {
                    a[i] = p[i];
                }
                // the (rabbit, length) section
                // DEVELOPER NOTE: normalized as if were a normal array
                // (0, 2, 3, 1) -> (0) , (2, 3, 1) would be a valid split
                // but we normalized the second array as if it were a valid three length array giving us
                // (0, 2, 3, 1) -> (0) , (1, 2, 0)
                int[] b = new int[length - rabbit - 1];
                for (int i = rabbit + 1; i < length; i++) {
                    b[i - rabbit - 1] = p[i] - rabbit - 1;
                }

                // our result is equal to the result of any existing dynamic programming we've done
                // multiplied by the number of options for each child half
                // multiplied by the precalculated sum of the child splits
                BigInteger firstPart = swap(a, start, rabbit + 1, depth + 1);
                BigInteger secondPart = swap(b, start + rabbit + 1, length - rabbit - 1, depth + 1);
                BigInteger preCalculatedSumOfChildSplits = maximumSplitCombinations.get(length - 2).get(rabbit);

                BigInteger additionalCombinations = firstPart
                        .multiply(secondPart)
                        .multiply(preCalculatedSumOfChildSplits);

                res = res.add(additionalCombinations);
            }

            // swap back the work the rabbit did, so that the next rabbit can be
            // treated as if he were the first rabbit to swap
            tmp = p[rabbit];
            p[rabbit] = p[rabbit + 1];
            p[rabbit + 1] = tmp;
        }

        // return the result
        return res;
    }

}
