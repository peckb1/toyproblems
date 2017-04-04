package com.github.peckb1.topcoder.practice.easy;

/**
 * Your friends Alice and Bob are playing a board game. They have asked you to help them to determine the winner.
 * The game is played on a square board with 2N rows and 2N columns. The exact rules of the game itself are not
 * important for this problem. Once the game is over, each cell of the board is either empty or contains a single
 * piece that belongs to either Alice or Bob. You are given board, where the j-th character in i-th element
 * (0-based indices) describes the contents of the cell in row i, column j: '.' represents an empty cell, 'A' a
 * cell with Alice's piece and 'B' a cell with Bob's piece.
 * <p>
 * The entire board is divided into N regions. Region 1 occupies the 4 central cells of the board. Each next region
 * contains all cells that are horizontally, vertically or diagonally adjacent to cells of the immediately previous
 * region and do not belong to any of the previous regions. For example, when N = 4, here is how the regions look:
 * 44444444
 * 43333334
 * 43222234
 * 43211234
 * 43211234
 * 43222234
 * 43333334
 * 44444444
 * The winner is determined as follows. Consider the lowest numbered region that contains a different number of
 * Alice's and Bob's pieces. The player who has more pieces in this region is the winner. If all regions contain
 * the same number of Alice's and Bob's pieces, the game ends in a draw.
 * <p>
 * Return "Alice" if Alice wins the given game, "Bob" if Bob wins and "Draw" if the game ends in a draw.
 * Note that return values are case-sensitive.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class ABoardGame {

    static final String ALICE = "Alice";
    static final String BOB = "Bob";
    static final String DRAW = "Draw";

    public String whoWins(String[] board) {
        int regions = board.length / 2;
        int[][] scores = new int[regions][2]; // 2 = players

        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {
            String rowString = board[rowIndex];
            for (int columnIndex = 0; columnIndex < rowString.length(); columnIndex++) {
                int region = findRegion(rowIndex, columnIndex, regions);
                char player = rowString.charAt(columnIndex);

                // if we're not '.'
                if (player != 46) {
                    scores[region - 1][player - 65]++;
                }
            }
        }

        for (int i = 0; i < regions; i++) {
            int aliceScores = scores[i][0];
            int bobScores = scores[i][1];
            if (aliceScores > bobScores) {
                return ALICE;
            }
            if (bobScores > aliceScores) {
                return BOB;
            }
        }

        return DRAW;
    }

    private int findRegion(int rowIndex, int columnIndex, int regions) {
        int maxIndex = (regions * 2) - 1;
        // handle the top and bottom rows, they are easy peasy
        if (rowIndex == 0 || rowIndex == maxIndex) {
            return regions;
        }

        if (rowIndex < regions) {
            if (columnIndex < regions) {
                // upper left quadrant
                return regions - Math.min(columnIndex, rowIndex);
            } else {
                // upper right quadrant
                return regions - Math.min(maxIndex - columnIndex, rowIndex);
            }
        } else {
            if (columnIndex < regions) {
                // lower left quadrant
                return regions - Math.min(columnIndex, maxIndex - rowIndex);

            } else {
                // lower right quadrant
                return regions - Math.min(maxIndex - columnIndex, maxIndex - rowIndex);
            }
        }
    }

}
