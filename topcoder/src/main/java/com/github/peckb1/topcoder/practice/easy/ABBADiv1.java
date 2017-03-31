package com.github.peckb1.topcoder.practice.easy;

/**
 * One day, Jamie noticed that many English words only use the letters A and B. Examples of such words include "AB"
 * (short for abdominal), "BAA" (the noise a sheep makes), "AA" (a type of lava), and "ABBA" (a Swedish pop sensation).
 * <p>
 * Inspired by this observation, Jamie created a simple game. You are given two s: initial and target. The goal of the
 * game is to find a sequence of valid moves that will change initial into target. There are two types of valid moves:
 * <p>
 * Add the letter A to the end of the string.
 * Add the letter B to the end of the string and then reverse the entire string. (After the reversal the newly-added
 * B becomes the first character of the string).
 * Return "Possible" (quotes for clarity) if there is a sequence of valid moves that will change initial into target.
 * Otherwise, return "Impossible".
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class ABBADiv1 {

    static final String POSSIBLE = "Possible";
    static final String IMPOSSIBLE = "Impossible";

    public String canObtain(String initial, String target) {
        return obtainable(initial, target) ? POSSIBLE : IMPOSSIBLE;
    }

    private boolean obtainable(String initial, String target) {
        if (initial.length() == target.length()) {
            return initial.equals(target);
        }

        // we can't use the same trick of just working backwards since both
        // end up touching the same 'end' of the String
        // so we need to try both approaches
        String aStep = initial + 'A';
        String bStep = reverse(initial + 'B');

        // however we can short circuit the recursion by seeing if the string
        // is a part of our target, or if the string reversed is in it as well
        if (target.contains(aStep) || target.contains(reverse(aStep))) {
            if (obtainable(aStep, target)) {
                return true;
            }
        }
        if (target.contains(bStep) || target.contains(reverse(bStep))) {
            if (obtainable(bStep, target)) {
                return true;
            }
        }
        return false;
    }


    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

}
