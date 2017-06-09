package com.github.peckb1.projecteuler.p021to030;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits
 * 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 * <p>
 * 012   021   102   120   201   210
 * <p>
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Problem24 {

    public String lexicographic(int permutation, int[] digits) {
        int numPermutations = maxPermutations(digits.length);
        if (numPermutations < permutation) {
            return "IMPOSSIBLE";
        }

        int permutationOver = -1;
        for(int i = 1; i <= digits.length; i++) {
            if (maxPermutations(i) >= permutation) {
                permutationOver = i;
                break;
            }
        }

        List<Integer> items = Lists.newArrayList();
        for (final int digit : digits) {
            items.add(digit);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < digits.length - permutationOver; i++) {
            sb.append(items.get(0));
            items.remove(items.get(0));
        }

        int currentValue = 0;
        for(int i = permutationOver - 1; i > 0; i--) {
            int multiplier = maxPermutations(i);
            int digit = 0;
            for (int j = currentValue + multiplier; j < permutation; j += multiplier) {
                digit++;
                currentValue += multiplier;
            }
            sb.append(items.get(digit));
            items.remove(items.get(digit));
        }

        for (Integer item : items) {
            sb.append(item);
        }

        return sb.toString();
    }

    private int maxPermutations(int length) {
        if (length == 1) {
            return 1;
        } else {
            return length * maxPermutations(length - 1);
        }
    }

}
