package com.github.peckb1.topcoder.practice.medium;

/**
 * Consider the following function:
 * f(X) = Waai + X + Akari + X + Daisuki
 * Here, X is a string and + denotes string concatenation. Waai, Akari and Daisuki are constant non-empty strings.
 * <p>
 * <p>
 * You are given 5 s Waai, Akari, Daisuki, S and F, and a k.
 * Compute how many times F occurs in f^k(S) as its substring. (The notation f^k(S) means that f is applied to S
 * exactly k times in a row. See Notes for a formal definition.) Since the number can be quite large, compute the
 * number modulo 1,000,000,007.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AkariDaisukiDiv1 {

    private static final long MODULE = 1_000_000_007;

    public int countF(String W, String A, String D, String S, String searchString, int iterations) {
        // perform the concatination function until either
        // our concatinated String is greater than the string we're looking
        // or our maximum number of iterations has completed
        while (iterations > 0 && S.length() < searchString.length()) {
            S = W + S + A + S + D;
            iterations--;
        }

        long count = 0;

        // count any found substrings
        for (int i = 0; i <= S.length() - searchString.length(); i++) {
            if (S.startsWith(searchString, i)) {
                count++;
            }
        }

        // if we finished all wanted iterations then our string was small
        // and we can just return our calculated results
        if (iterations == 0) {
            return (int) count;
        }

        // otherwise start loking at prefix and postfix data
        String pre = S.substring(0, searchString.length());
        String pos = S.substring(S.length() - searchString.length());
        // keep a running counter of how many new ones were added during the
        // concatination, but not including the running `count` itself
        long add = 0;

        // iterate through more K iterations, stopping additionally when our counter
        // value has hit the entire lenght of our search string
        for (int counter = 0; counter < searchString.length() && iterations > 0; ++counter) {
            String newPre = W + pre;
            String newPos = pos + D;
            add = 0;

            // check for substrings in our prefix string after it would have data added to it
            for (int i = 0; i < W.length(); i++) {
                if (newPre.startsWith(searchString, i)) {
                    add++;
                }
            }

            // check for substrings in our postfix data
            for (int i = 0; i < D.length(); i++) {
                if (newPos.startsWith(searchString, newPos.length() - searchString.length() - i)) {
                    add++;
                }
            }

            // check the mid way which has prefix and postfix data dded
            String mid = pos + A + pre;
            for (int o = pos.length() - searchString.length() + 1; o < pos.length() + A.length(); ++o) {
                if (mid.startsWith(searchString, o)) {
                    add++;
                }
            }

            // reset our prefix and postfix strings - but keep them short enough  to not explode memory
            // we can use the length of our search string as a nice limit - as we don't need to find anything
            // which is longer than that
            pre = newPre.substring(0, searchString.length());
            pos = newPos.substring(newPos.length() - searchString.length());
            // double the count because this technically is hitting both sides of the split
            // at the same time
            count = (count + count + add) % MODULE;

            iterations--;
        }

        while (iterations > 0) {
            // we got to the point where we iterated through our data
            // enough times to know how many counts there would be
            // so just perform the addition of new data assuming that
            // add will never additionally increase
            count = (count + count + add) % MODULE;
            iterations--;
        }

        return (int) (count % MODULE);
    }

}
