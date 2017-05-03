package com.github.peckb1.topcoder.practice.easy;

/**
 * A sequence of integers a[0], a[1], ..., a[N-1], where N >= 3, is called an arithmetic progression if the
 * difference between any two successive terms in the sequence is a constant. More precisely, it is an
 * arithmetic progression if a[i] - a[i-1] = a[i+1] - a[i] for every integer i such that 0 < i < N-1.
 * <p>
 * Sasha and Pasha are students sharing the same room. Once, when Pasha had left the room, Sasha was in a good mood.
 * So he took a piece of chalk and wrote an arithmetic progression on the blackboard. The progression consisted of
 * at least 4 elements, all of which were positive integers. Then Sasha went to class, and Pasha came back.
 * <p>
 * Pasha is a very nice person, but there's one problem with him -- he's frightened of even numbers!
 * So, when he returned, he decided to make all the numbers on the board odd. He did this by repeatedly
 * finding an arbitrary even number X, erasing it, and writing X/2 in its place. He continued to perform this
 * step until no even numbers remained.
 * <p>
 * Your task is to help Sasha restore the initial progression. You will be given a seq, where the i-th element
 * is the i-th number in the sequence written on the blackboard after Pasha's actions.
 * <p>
 * Return an whose i-th element is the i-th number in a sequence that Sasha could have originally
 * written on the blackboard. The constraints will ensure that at least one such sequence exists.
 * If there are several such sequences, choose the one among them whose representation is lexicographically smallest.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AfraidOfEven {

    public int[] restoreProgression(int[] a) {
        int N = a.length;
        boolean foundProgression = false;

        for (int i = 1; i < N - 1; i++) {
            if (!foundProgression) {
                int second = a[i + 1] - a[i];
                int first = a[i] - a[i - 1];
                int difference = first - second;
                while (difference != 0) {
                    // if difference < 0 ; the second value was larger
                    // to close the gap in this direction ... double a[i]
                    if (difference < 0) {
                        a[i] = a[i] * 2;
                        first = a[i] - a[i - 1];
                        second = a[i + 1] - a[i];
                        difference = first - second;
                    } else {
                        // if difference > 0 ; the second value was smaller
                        // to close the gap in this direction ... double a[i-1] or a[i+1] - which to choose ...
                        // eventually multiplying any one of them, will give a difference that MUST be
                        // perfectly divisible by the other, with a factor of X
                        // for instance {7, 47, 5}
                        // if we started with the 7, we would take it to 14
                        // {14, 47 5} which would give a difference of 75, which is divisible by 5 and gives a value which is 5*3
                        // if we started with the 5, we would eventually take it to 80
                        // {7, 47, 80} which would give a difference of 7 which is divisible by 7 and gives a value which is 7*1
                        // we can therefore start at either of the values, and continue to change the number until
                        // we get a difference which leads to a nice factor of the other number

                        int aMinusOneRemainder = difference % a[i - 1];
                        int aPlusOneRemainder = difference % a[i + 1];

                        // they both can make a valid sequence
                        if (aMinusOneRemainder == 0 && aPlusOneRemainder == 0) {

                            int[] firstNewData = new int[]{a[i - 1], a[i], a[i + 1]};
                            int[] secondNewData = new int[]{a[i - 1], a[i], a[i + 1]};
                            // fill the firstNewData with the sequence at its termination
                            while (firstNewData[1] - firstNewData[0] != firstNewData[2] - firstNewData[1] && firstNewData[0] > 0) {
                                firstNewData[0] = firstNewData[0] * 2;
                            }
                            // fill the secondNewData with the sequence at its termination
                            while (secondNewData[1] - secondNewData[0] != secondNewData[2] - secondNewData[1] && secondNewData[2] > 0) {
                                secondNewData[2] = secondNewData[2] * 2;
                            }

                            // grab the next value for each of those two new arrays
                            int firstNextValue = firstNewData[2] - firstNewData[1] + firstNewData[2];
                            int secondNextValue = secondNewData[2] - secondNewData[1] + secondNewData[2];

                            // and our next (still may be wrong) value
                            int nextChangedValue = a[i + 2];

                            if (firstNextValue % nextChangedValue == 0) {
                                // and if the first one is a divisor - it's the winner
                                a[i - 1] = a[i - 1] * 2;

                            } else if (secondNextValue % nextChangedValue == 0) {
                                // or it could be our second divisor
                                a[i + 1] = a[i + 1] * 2;

                            } else {
                                // if it's neither, then our values are equal, and we need to increase them
                                // both and try again
                                a[i - 1] = a[i - 1] * 2;
                                a[i + 1] = a[i + 1] * 2;
                            }

                        } else if (aMinusOneRemainder == 0) {
                            // we hit a factor for the first value
                            a[i - 1] = a[i - 1] * 2;
                        } else if (aPlusOneRemainder == 0) {
                            // we hit a factor for the second value
                            a[i + 1] = a[i + 1] * 2;
                        } else {
                            // if not, just double the first one
                            a[i - 1] = a[i - 1] * 2;
                        }

                        first = a[i] - a[i - 1];
                        second = a[i + 1] - a[i];
                        difference = first - second;
                    }
                }
                foundProgression = true;
            } else {
                // after we found our first happy pattern; no need to do any more actual guess work
                // just fill out the rest of the item
                a[i + 1] = a[i] - a[i - 1] + a[i];
            }
        }

        return a;
    }
}
