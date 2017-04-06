package com.github.peckb1.topcoder.practice.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * *** You may only submit a given problem once - no resubmissions will be accepted. ***
 * <p>
 * An arithmetic series consists of a sequence of terms such that each term minus its immediate predecessor gives
 * the same result. For example, the sequence 3,7,11,15 is the terms of the arithmetic series 3+7+11+15; each term
 * minus its predecessor equals 4. (Of course there is no requirement on the first term since it has no predecessor.)
 * <p>
 * Given a collection of integers, we want to find the longest arithmetic series that can be formed by choosing a
 * sub-collection (possibly the entire collection). Create a class ASeries that contains a method longest that is
 * given a values and returns the length of the longest arithmetic series that can be formed from values.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class ASeries {

    // example input = {3,8,4,5,6,2,2}
    public int longest(int[] values) {
        // after sorting =  {2,2,3,4,5,6,8}
        Arrays.sort(values);

        // we make half of, essentially, an adjacency matrix
        // with each entry being the distance and the node there
        //
        // g = 8 -> [ ]
        // f = 6 -> [ (2,g) ]
        // e = 5 -> [ (1,f), (3,g) ]
        // d = 4 -> [ (1,e), (2,f), (4,g) ]
        // c = 3 -> [ (1,d), (2,e), (3,f), (5,g) ]
        // b = 2 -> [ (1,c), (2,d), (3,e), (4,f), (6,8)]
        // a = 2 -> [ (0,b), (1,c), (2,d), (3,e), (4,f), (6,8)]
        //
        // `nodes`-> List(g, f, e, d, c, b, a)
        List<Node> nodes = new LinkedList<>();
        for (int index = values.length - 1; index >= 0; index--) {
            Node node = new Node(values[index]);
            node.link(nodes);
            nodes.add(node);
        }

        // we then go through our nodes list (max size = values.size)
        // and follow the trail of each adjacency matching the same depth
        final int[] max = {0};
        nodes.forEach(node -> {
            Map<Integer, Node> adjacentValues = node.adjacentValues;
            adjacentValues.keySet().forEach(key -> {
                int depth = node.depth(key);
                max[0] = Math.max(max[0], depth);
            });
        });

        // return the maximum depth found
        return max[0];
    }

    private class Node {
        private final int value;
        private final Map<Integer, Node> adjacentValues;

        private Node(int value) {
            this.value = value;
            this.adjacentValues = new HashMap<>();
        }

        private void link(List<Node> nodes) {
            nodes.forEach(node -> {
                int diff = node.value - this.value;
                this.adjacentValues.put(diff, node);
            });
        }

        private int depth(int comparison) {
            Node node = this.adjacentValues.get(comparison);
            if (node != null) {
                return 1 + node.depth(comparison);
            } else {
                return 1;
            }
        }
    }

}
