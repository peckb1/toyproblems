package com.github.peckb1.topcoder.practice.medium;

/**
 * One day, Jamie noticed that many English words only use the letters A and B. Examples of such words include "AB"
 * (short for abdominal), "BAA" (the noise a sheep makes), "AA" (a type of lava), and "ABBA" (a Swedish pop sensation).
 *
 * Inspired by this observation, Jamie created a simple game. You are given two s: initial and target. The goal of the
 * game is to find a sequence of valid moves that will change initial into target. There are two types of valid moves:
 *
 * Add the letter A to the end of the string.
 * Reverse the string and then add the letter B to the end of the string.
 *
 * Return "Possible" (quotes for clarity) if there is a sequence of valid moves that will change initial into target.
 * Otherwise, return "Impossible".
 *
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class ABBA {
    static final String POSSIBLE = "Possible";
    static final String IMPOSSIBLE = "Impossible";

    public String canObtain(String initial, String target) {
        return obtainable(initial, target) ? POSSIBLE : IMPOSSIBLE;
    }

    private boolean obtainable(String initial, String target) {
        if (target.length() == initial.length()) {
            return target.equals(initial);
        }

        if (target.endsWith("A")) {
            // last step was to an an A
            return obtainable(initial, target.substring(0, target.length() - 1));
        } else {
            // our String can only contain 'A' or 'B'
            // last step was to reverse and add a 'B'
            return obtainableRevsere(initial, target.substring(0, target.length() - 1));
        }
    }

    /**
     * Reversing a string is expensive - so just treat the start as the end of the string for this one
     */
    private boolean obtainableRevsere(String initial, String target) {
        if (target.length() == initial.length()) {
            // ok - time to check equality - maybe actually reverse the string here
            // to avoid manually checking target[length] == initial[0] and meeting in the middle
            return target.equals(new StringBuilder(initial).reverse().toString());
        }

        if (target.startsWith("A")) {
            // last step was to ad an A
            return obtainableRevsere(initial, target.substring(1, target.length()));
        } else {
            // our String can only contain 'A' or 'B'
            // last step was to reverse and add a 'B'
            return obtainable(initial, target.substring(1, target.length()));
        }
    }
}
