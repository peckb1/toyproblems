package com.github.peckb1.topcoder.practice.easy;

import java.util.Optional;

/**
 * You are given an electrical circuit for a home, with a number of nodes possibly connected by wires.
 * Any pair of nodes may be connected by at most one wire, and a node can't be connected to itself.
 * Each node on the circuit is either an electrical outlet for the house or a connection to the main electrical grid.
 * The wires tells you the wires that are already in place; the xth character of the yth element is '1' (one)
 * if nodes x and y have a wire between them, '0' (zero) otherwise. The gridConnections lists the indices of the
 * nodes that are connections to the main electrical grid.
 * <p>
 * You'd like to make the circuit safer and more redundant by adding as many extra wires to it as possible.
 * The one complication is that no two main grid connections are currently wired together (directly or indirectly),
 * and you must preserve this, or else disaster will result. Determine the maximum number of new wires you can add to the circuit.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AddElectricalWires {

    public int maxNewWires(String[] wires, int[] gridConnections) {
        Node[] nodes = new Node[wires.length];

        for (int w = 0; w < wires.length; w++) {
            nodes[w] = new Node(wires.length);
        }

        for (int w = 0; w < wires.length; w++) {
            for (int w2 = w + 1; w2 < wires.length; w2++) {
                if (wires[w].charAt(w2) == 49) {
                    nodes[w].connect(w2, nodes[w2]);
                    nodes[w2].connect(w, nodes[w]);
                }
            }
        }

        for (final int gridConnection : gridConnections) {
            nodes[gridConnection].markAsGridNode();
        }

        int additionalWires = 0;

        for (int w = 0; w < nodes.length; w++) {
            Node node = nodes[w];
            for (int w2 = w + 1; w2 < nodes.length; w2++) {
                Node nextNode = nodes[w2];

                if (node.connections[w2] == null && canConnect(node, nextNode)) {
                    additionalWires++;
                    node.connect(w2, nextNode);
                    nextNode.connect(w, node);
                }
            }
        }

        return additionalWires;
    }

    private boolean canConnect(Node nodeA, Node nodeB) {
        // we already know that the nodeA, and nodeB are not connected
        // so we just need to return if connecting them would cause
        // two grid nodes to become connected
        //
        // So we check if node A has a connection
        return nodeA.gridConnection.isPresent()
                // and if node B has a connection
                && !(nodeB.gridConnection.isPresent()
                // and if those connections are not to the same grid point
                && nodeB.gridConnection.get() != nodeA.gridConnection.get());
    }

    class Node {

        final Node[] connections;

        Optional<Node> gridConnection;

        private Node(int possibleNeighbors) {
            connections = new Node[possibleNeighbors];
            gridConnection = Optional.empty();
        }

        private void markAsGridNode() {
            this.gridConnection = Optional.of(this);
            for (Node node : this.connections) {
                if (node != null) {
                    node.setGridConnection(this);
                }
            }
        }

        private void setGridConnection(Node node) {
            if (this.gridConnection.isPresent() && this.gridConnection.get() != node) {
                throw new IllegalArgumentException("Invalid input, grid is connected");
            } else {
                if (!this.gridConnection.isPresent()) {
                    this.gridConnection = Optional.of(node);
                    for (Node connection : connections) {
                        if (connection != null) {
                            connection.setGridConnection(node);
                        }
                    }
                }
            }
        }

        private void connect(int index, Node node) {
            this.connections[index] = node;
            if (node.gridConnection.isPresent()) {
                setGridConnection(node.gridConnection.get());
            }
        }
    }
}
