package com.github.peckb1.topcoder.practice.hard;

/**
 * Given a map of a hill, there are many ways for an agent to get from one point to another point. Many different
 * algorithms have been developed to find the best, or reasonably good ways to get from a starting location to an
 * ending location. One such method is the breadth-first-search (BFS) algorithm, where the agent always expands
 * the location with the least accumulated cost. Another method is called A*, which involves predicting the total
 * cost to the goal based on the cost so far, and a heuristic which calculates the expected cost to come, and then
 * expanding the nodes in a BFS-fashion based on this expected, rather than already accumulated, cost.
 * <p>
 * When a search method expands a node, it assigns a new cost to each neighbor, unless that neighbor already has an
 * equal or lesser cost assigned. In BFS, this cost is the cost to get to the current node plus the cost of moving
 * from the current node to the given neighboring node. In A*, this is the total cost as in BFS plus the predicted
 * cost based on the heuristic function. The search ends when the goal node is expanded, and not when its cost is
 * calculated. This is because different neighboring nodes can assign different costs to the goal, so terminating
 * before the goal node itself is expanded can give a sub-optimal solution. Once the goal is expanded, however, you
 * are guaranteed that no neighbor will assign it a lower cost than the one it currently has, and thus it is optimal.
 * <p>
 * BFS (for reference): For BFS, the agent starts at the starting location (hereafter referred to as S) with a cost
 * of 0. The agent expands this location (also referred to as a node), calculating the cost for all of its neighbors.
 * It then expands all nodes with a calculated cost of 1, then all nodes with a calculated cost of 2, and so forth,
 * until it has expanded the goal node. Notice that a given node may be assigned different costs by different neighbors,
 * but this is okay because we assume that the cost is always increasing, so it should be assigned the lowest cost
 * possible and expanded in turn.
 * <p>
 * A*: For A*, the agent starts at S, with a so-far cost of 0. The heuristic function our agent uses will be the
 * "Manhattan Distance" from the current node to the goal node (hereafter referred to as G), that is, the positive
 * difference in X values plus the positive difference in Y values. The agent expands S, assigning all of its
 * neighbors a cost as with BFS, but with an additional predicted cost (the Manhattan Distance to the goal).
 * It then expands the nodes in a BFS-fashion using these total predicted costs. A* should NOT expand a node
 * that it has already expanded previously.
 * <p>
 * For this problem, the agent can move across the hill in any of the four cardinal directions (north, east, west
 * and south.) The cost of moving down the hill is 1, of moving across a plateau (between 2 squares of equal altitude)
 * is 2, and of moving up the hill is 3. The hill is represented by a String[] hill, which represents the altitudes
 * as 1 through 9 (with 9 being the highest altitude). The x and y coordinates of S and G are represented respectively
 * by int sx sy gx and gy. The y coordinate is the 0-indexed element in hill, and the x coordinate is the 0-indexed
 * location in the element of hill. Use the A* method to search for G starting from S, and return the number of nodes
 * expanded. Expand all nodes that share the same predicted cost as G. For example, if you expand G with a predicted
 * cost of 10, make sure that all other nodes with a predicted cost of 10 are also expanded, to avoid ambiguities.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AlgoHill {

    /**
     * DEV NOTE: although technically we're called A* this problem wants all nodes with the same
     * cost as the goal node; so we're actually exploring more than we have to, to ensure that
     * we don't miss any nodes which would end up with the same cost as our goal node ...
     */
    public int astar(String[] hillStrings, int startY, int startX, int goalY, int goalX) {
        int X = hillStrings.length;
        int Y = hillStrings[0].length();

        int hill[][] = new int[X][Y];
        int exploredCells[][] = new int[X][Y];

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                hill[i][j] = hillStrings[i].charAt(j);
                exploredCells[i][j] = 9001;
            }
        }

        exploredCells[startX][startY] = 0;

        // iterate over all the nodes
        for (int i = 0; i < X * Y; i++) {
            // for each node - or, more the maximum number of relaxations
            // we check to see if the x/y are valid nodes and start finding
            // out if we can get a node for cheaper than what we have
            for (int x = 0; x < X; x++) {
                for (int y = 0; y < Y; y++) {
                    if (x > 0) {
                        exploreCell(hill, exploredCells, x - 1, y, x, y);
                    }
                    if (x < X - 1) {
                        exploreCell(hill, exploredCells, x + 1, y, x, y);
                    }
                    if (y > 0) {
                        exploreCell(hill, exploredCells, x, y - 1, x, y);
                    }
                    if (y < Y - 1) {
                        exploreCell(hill, exploredCells, x, y + 1, x, y);
                    }
                }
            }
        }

        // count all the cells with the same value as our goal node
        int cellsEqualToGoalCount = 0;
        for (int x = 0; x < X; x++) {
            for (int y = 0; y < Y; y++) {
                if (exploredCells[x][y] + Math.abs(x - goalX) + Math.abs(y - goalY) <= exploredCells[goalX][goalY]) {
                    cellsEqualToGoalCount++;
                }
            }
        }

        return cellsEqualToGoalCount;
    }

    private void exploreCell(int[][] hill, int[][] exploredCells, int modX, int modY, int baseX, int baseY) {
        final int j;
        if (hill[modX][modY] > hill[baseX][baseY]) {
            // going up hill?
            j = 3;
        } else if (hill[modX][modY] < hill[baseX][baseY]) {
            // going down hill?
            j = 1;
        } else {
            // we must be on equal footing
            j = 2;
        }
        exploredCells[modX][modY] = Math.min(exploredCells[modX][modY], exploredCells[baseX][baseY] + j);
    }

}
