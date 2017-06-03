package com.github.peckb1.projecteuler.p011to020;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below,
 * the maximum total from top to bottom is 23.
 * <pre>
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 * </pre>
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p>
 * Find the maximum total from top to bottom of the triangle below:
 * <pre>
 *                75
 *               95 64
 *              17 47 82
 *             18 35 87 10
 *            20 04 82 47 65
 *           19 01 23 75 03 34
 *          88 02 77 73 07 63 67
 *         99 65 04 28 06 16 70 92
 *        41 41 26 56 83 40 80 70 33
 *       41 48 72 33 47 32 37 16 94 29
 *      53 71 44 65 25 43 91 52 97 51 14
 *     70 11 33 28 77 73 17 78 39 68 17 57
 *    91 71 52 38 17 14 91 43 58 50 27 29 48
 *   63 66 04 68 89 53 67 30 73 16 69 87 40 31
 *  04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * </pre>
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However,
 * Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force,
 * and requires a clever method! ;o)
 */
public class Problem18 {

    /*
              {03},
            {07, 04},
          {02, 04, 06},    <-- row to change
        {08, 05, 09, 03}   <-- row to inspect

              {03}
            {07, 04}       <-- row to change
          {10, 13, 15}     <-- row to inspect
        {08, 05, 09, 03}   <-- FINISHED

              {03}         <-- row to change
            {20, 19}       <-- row to inspect
          {10, 13, 15}     <-- FINISHED
        {08, 05, 09, 03}   <-- FINISHED

              {23}         <-- SOLUTION
            {20, 19}       <-- FINISHED
          {10, 13, 15}     <-- FINISHED
        {08, 05, 09, 03}   <-- FINISHED
     */

    public int triangleSum(int[][] triangle) {
        // starting at the bottom row
        for(int row = triangle.length - 1; row > 0; row--) {
            // going over each value in the row (except the last)
            for(int col = 0; col < triangle[row].length - 1; col++) {
                // modify the number by the largest path to that number taking from me or my neighbor
                triangle[row - 1][col] += Math.max(triangle[row][col], triangle[row][col + 1]);
            }
        }

        return triangle[0][0];
    }

}
