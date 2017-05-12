package com.github.peckb1.topcoder.practice.hard;

/**
 * The logician Charles Sanders Pierce proposed a procedure for generating and
 * ordering all of the positive rational numbers. A rational number is an integer
 * divided by an integer (n/m where both n and m are integers and m does not equal
 * zero).
 * <p>
 * The procedure proceeds as follows. Start with the two rationals 0/1 and 1/0
 * (disregarding the fact that 1/0 is not a valid number). Call this generation 1.
 * To produce the next generation, insert a new rational in between each pair of
 * rationals in the current generation by summing the numerators (the number being
 * divided) of the adjacent rationals to produce the new numerator, and by summing
 * the denominators (the number doing the dividing) of the adjacent rationals to
 * produce the new denominator. By repeating this procedure indefinitely, all of
 * the positive rational numbers will be produced in order in their simplest
 * rational form.
 * <p>
 * The first few generations proceed as follows:
 * <p>
 * G1: 0/1 1/0
 * G2: 0/1 1/1 1/0
 * G3: 0/1 1/2 1/1 2/1 1/0
 * G4: 0/1 1/3 1/2 2/3 1/1 3/2 2/1 3/1 1/0
 * G5: 0/1 1/4 1/3 2/5 1/2 3/5 2/3 3/4 1/1 4/3 3/2 5/3 2/1 5/2 3/1 4/1 1/0
 * <p>
 * Code a method that given a generation number and a zero based index, returns
 * the numerator and denominator of the rational number at the position indicated
 * by the index within the generation. If the index is not within the range of
 * values for the given generation, return the special error value having zero for
 * both the numerator and denominator.
 * <p>
 * DEFINITION
 * Class: AlephNull
 * Parameters: int, int
 * Returns: int[]
 * Method signature: int[] rational(int generation, int item)
 * <p>
 * (be sure your method is public)
 * <p>
 * TopCoder will ensure the validity of the inputs.  Inputs are valid if all of
 * the following criteria are met:
 * <p>
 * generation is from 1 to 30 inclusive.
 * item is from 0 to 999999999 inclusive.
 * <p>
 * HINT
 * The number of elements in a given generation can be computed as follows:
 * elements = (2 ^ (generation - 1)) + 1. (The '^' symbol indicates
 * exponentiation. For example:
 * Generation 1: 2^0 + 1 = 2
 * Generation 2: 2^1 + 1 = 3
 * Generation 3: 2^2 + 1 = 5
 * Generation 4: 2^3 + 1 = 9
 * Generation 9: 2^8 + 1 = 257
 * <p>
 * EXAMPLES
 * E1:  1,0        ==> [0,1]
 * E2:  1,1        ==> [1,0]
 * E3:  1,2        ==> [0,0]      //error value
 * E4:  4,1        ==> [1,3]
 * E5:  4,6        ==> [2,1]
 * E6:  5,11       ==> [5,3]
 * E7:  8,70       ==> [9,7]
 * E8:  10,467     ==> [43,12]
 * E9:  23,4190316 ==> [438,43]
 * E10: 30,100     ==> [7,157]
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AlephNull {

    public int[] rational(int generation, int item) {
        // what is our min index
        int min = 0;
        // what is our max index
        int max = (int) Math.pow(2, generation - 1);
        // the rational number at our min index
        Rational currentMin = new Rational(0, 1);
        // the rational number at our max index
        Rational currentMax = new Rational(1, 0);

        // handle the base cases
        if (item > max) { // is the index outside the range?
            return new int[]{0, 0};
        }
        if (item == min) { // is the index our min index?
            return currentMin.toArray();
        }
        if (item == max) { // is the index our max index?
            return currentMax.toArray();
        }

        // time to drill down; binary search style
        int mid = (max + min) / 2;
        // did we find our item yet?
        while (mid != item) {
            // guess not
            // should we raise our lower?
            if (item < mid) {
                max = mid;
                currentMax = currentMin.add(currentMax);

            // or should we lower our upper?
            } else { // item > mid
                min = mid;
                currentMin = currentMin.add(currentMax);
            }
            // reset mid, and try again
            mid = (max + min) / 2;
        }

        // the midway point is our index - create the item
        return currentMin.add(currentMax).toArray();
    }

    private class Rational {
        private final int n;
        private final int d;

        private Rational(int n, int d) {
            this.n = n;
            this.d = d;
        }

        @Override
        public String toString() {
            return String.format("%d/%d", n, d);
        }

        private Rational add(Rational other) {
            return new Rational(other.n + this.n, other.d + this.d);
        }

        private int[] toArray() {
            return new int[]{n, d};
        }
    }
}
