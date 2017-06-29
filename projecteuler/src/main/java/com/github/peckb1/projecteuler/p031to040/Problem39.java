package com.github.peckb1.projecteuler.p031to040;

/**
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly
 * three solutions for p = 120.
 * <p>
 * {20,48,52}, {24,45,51}, {30,40,50}
 * <p>
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Problem39 {

    public int maximumIntegralSolutions() {
        // a + b + c = p
        // c = p - a - b
        //
        // a^2 + b^2 = c^2
        // a^2 + b^2 = (p - a - b)^2
        // a^2 + b^2 = a^2 + 2ab + b^2 - 2ap - 2bp + p^2
        // cancel out the a^2 and b^2
        // 0 = 2ab - 2ap - 2bp + p^2
        // use wolframalpha
        // b = ((2 a - p) p)/(2 (a - p))
        // so we know b is a proper int if ((2 a - p) p) % (2 (a - p)) was 0
        // and if a and b are both whole integers, and p is a whole integer, we know
        // that c is also a whole integer
        int maxResults = 0;
        int maxP = 0;

        for (int p = 1; p <= 1000; p++) {
            int results = 0;
            for (int a = 1; a <= p - 2; a++) {
                boolean bIsWholeNumber = 0 == ((2 * a - p) * p) % (2 * (a - p));
                if (bIsWholeNumber) {
                    results++;
                }
            }
            if (results > maxResults) {
                maxP = p;
                maxResults = results;
            }
        }
        return maxP;
    }

}
