package com.github.peckb1.projecteuler.p031to040;

import java.util.HashSet;
import java.util.Set;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * <p>
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the
 * concatenated product of 192 and (1,2,3)
 * <p>
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital,
 * 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 * <p>
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of
 * an integer with (1,2, ... , n) where n > 1?
 */
public class Problem38 {

    public int largestPandigital() {
        // since n > 1 we can try with just (1, 2)
        //
        // since we were already given 918273645 as one, but not the actual answer
        // our number must be larger than that
        //
        // also since we're trying 1, 2 we know we can't have a five digit number
        // since that would give us a 10 digit number after concatination
        for (int i = 9876; i >= 9182; i--) {
            int possibleAnswer = Integer.parseInt("" + i + (2 * i));
            if (isPandigital(possibleAnswer)) {
                return possibleAnswer;
            }
        }

        return -1;
    }

    private boolean isPandigital(int possibleAnswer) {
        Set<Integer> digits = new HashSet<>();
        char[] charArray = String.valueOf(possibleAnswer).toCharArray();
        for (char c : charArray) {
            digits.add((int) c);
        }
        return !digits.contains((int) '0') && digits.size() == 9;
    }

}
