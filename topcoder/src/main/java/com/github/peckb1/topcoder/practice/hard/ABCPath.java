package com.github.peckb1.topcoder.practice.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * You will be given a 2-dimensional grid of letters. Write a method to find the length of the longest path of
 * consecutive letters, starting at 'A'. Paths can step from one letter in the grid to any adjacent letter
 * (horizontally, vertically, or diagonally).
 * <p>
 * For example, in the following grid, there are several paths from 'A' to 'D', but none from 'A' to 'E':
 * <p>
 * { "ABE",
 * "CFG",
 * "BDH",
 * "ABC" }
 * One such path is:
 * <p>
 * A B .
 * C . .
 * . D .
 * . . .
 * (spaces are for clarity only)
 * so, for this grid, your method should return 4.
 */
public class ABCPath {

    public int length(String[] gridArray) {
        if (gridArray.length == 0) {
            return 0;
        }

        boolean containsA = false;
        Grid grid = new Grid(gridArray.length);
        for (int i = 0; i < gridArray.length; i++) {
            String rowString = gridArray[i];
            containsA = containsA || rowString.contains("A");
            grid.insertRow(i, rowString);
        }

        if (!containsA) {
            return 0;
        }

        int maxLength = 0;
        for (int w = 0; w < grid.width(); w++) {
            for (int h = 0; h < grid.height(); h++) {
                int length = grid.getLength(w, h);
                if (length == 26) {
                    return 26;
                } else {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }


    private class Grid {
        private final List<List<Node>> rows;

        private Grid(int height) {
            this.rows = new ArrayList<>(height);
        }

        private void insertRow(int rowIndex, String rowString) {
            final List<Node> nodes = new ArrayList<>(rowString.length());
            for (int i = 0; i < rowString.length(); i++) {
                char nodeValue = rowString.charAt(i);

                Optional<Node> trueCenter = Optional.of(new Node(nodeValue));
                Optional<Node> upperLeft   = getOrNull(rowIndex - 1, i - 1);
                Optional<Node> upperCenter = getOrNull(rowIndex - 1, i);
                Optional<Node> upperRight  = getOrNull(rowIndex - 1, i + 1);
                Optional<Node> centerLeft  = i > 0 ? Optional.of(nodes.get(i - 1)) : Optional.empty();

                trueCenter.ifPresent(node -> node.addNeighbor(upperLeft));
                trueCenter.ifPresent(node -> node.addNeighbor(upperCenter));
                trueCenter.ifPresent(node -> node.addNeighbor(upperRight));
                trueCenter.ifPresent(node -> node.addNeighbor(centerLeft));

                upperLeft.ifPresent(node -> node.addNeighbor(trueCenter));
                upperCenter.ifPresent(node -> node.addNeighbor(trueCenter));
                upperRight.ifPresent(node -> node.addNeighbor(trueCenter));
                centerLeft.ifPresent(node -> node.addNeighbor(trueCenter));

                nodes.add(i, trueCenter.get());
            }
            this.rows.add(rowIndex, nodes);
        }

        private Optional<Node> getOrNull(int rowIndex, int nodeIndex) {
            if (0 <= rowIndex && rowIndex < height()) {
                if (0 <= nodeIndex && nodeIndex < width()) {
                    return Optional.of(this.rows.get(rowIndex).get(nodeIndex));
                }
            }
            return Optional.empty();
        }

        private int width() {
            return rows.get(0).size();
        }

        private int height() {
            return rows.size();
        }

        private int getLength(int width, int height) {
            Node node = this.rows.get(height).get(width);
            if (node.getValue() == 'A') {
                return node.getLength();
            } else {
                return 0;
            }
        }
    }

    private class Node {

        private final char value;
        private final List<Node> nextLetterNodes;

        private Node(char value) {
            this.value = value;
            this.nextLetterNodes = new LinkedList<>();
        }

        private int getLength() {
            return 1 + this.nextLetterNodes.stream()
                    .map(Node::getLength)
                    .reduce(0, Math::max);
        }

        private char getValue() {
            return value;
        }

        private void addNeighbor(Optional<Node> neighborMaybe) {
            neighborMaybe.ifPresent(node -> {
                if (this.value + 1 == node.getValue()) {
                    nextLetterNodes.add(node);
                }
            });
        }
    }
}
