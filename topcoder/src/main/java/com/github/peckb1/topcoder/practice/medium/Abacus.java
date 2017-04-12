package com.github.peckb1.topcoder.practice.medium;

/**
 * An abacus can be used to do arithmetic. The version that we have has 6 horizontal threads, each with nine
 * beads on it. The beads on each thread are always arranged with just one gap, possibly at one of the ends.
 * However many beads are adjacent and at the right end of the thread is the digit value of the thread. The
 * value on the abacus is read by taking the digits in order from top thread to bottom thread and arranging
 * them from left to right (so the top thread is the one that contains the most significant digit).
 * <p>
 * Create a class Abacus that contains a method add that is given a String[] original and a number val and that
 * returns a String[] showing the abacus after val has been added to the original abacus.
 * <p>
 * Both in original and in the return, the String[] will contain exactly 6 elements representing the 6 threads in
 * order from top thread to bottom thread. Each element will contain a lowercase 'o' to represent each bead and
 * three consecutive hyphens '-' to indicate the empty part of the thread. Each element will thus contain
 * exactly 12 characters.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class Abacus {

    private final int ROW_LENGTH = 12;
    private final String BREAK = "---";
    private final String BEAD = "o";

    public String[] add(String[] original, int val) {
        int originalAbacusValue = 0;
        for(int i = 0; i < original.length; i++) {
            String digitString = original[i];
            int value = ROW_LENGTH - digitString.indexOf(BREAK) - BREAK.length();
            double multiplier = Math.pow(10, original.length - i - 1);
            originalAbacusValue += (value * multiplier);
        }

        return createAbacus(originalAbacusValue + val, original.length);
    }

    private String[] createAbacus(int value, int arraySize) {
        String[] result = new String[arraySize];
        for(int i = 0; i < arraySize; i++) {
            double multiplier = Math.pow(10, i + 1);
            double digit = value % multiplier;
            result[arraySize - 1 - i] = createAbacusString(digit / (multiplier / 10));
            value -= digit;
        }
        return result;
    }

    private String createAbacusString(double digit) {
        int prefixOs = ROW_LENGTH - BREAK.length() - (int) digit;
        int suffixOs = (int) digit;

        String abacusRow = "";
        for(int i = 0; i < prefixOs; i++) {
            abacusRow += BEAD;
        }
        abacusRow += BREAK;
        for(int i = 0; i < suffixOs; i++) {
            abacusRow += BEAD;
        }
        return abacusRow;
    }

}
