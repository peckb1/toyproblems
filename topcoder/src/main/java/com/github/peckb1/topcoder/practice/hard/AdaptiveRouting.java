package com.github.peckb1.topcoder.practice.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A network consists of routers and links. Each link directly connects two routers.
 * Links can transfer data in both directions, and have unlimited bandwidth but limited transfer speed.
 * We know how many time units it takes for each link to transmit a packet from one end to the other.
 * <p>
 * The routers know the layout of the network and relay data packets so that the packet reaches its destination
 * in the shortest possible time. Suppose a router wants to send a packet to some other router.
 * <p>
 * The source router will calculate the shortest path to the destination router and send the packet to the
 * first router on that path.
 * <p>
 * That router will then proceed in the same way, and so on until the packet reaches its destination.
 * If a router can send to more than one neighboring router and have the packet delivered in the same minimal time,
 * it will send to the lowest-numbered of those routers.
 * <p>
 * When a link fails, the two routers it connected know about it immediately, but the other routers do not.
 * The two routers generate control packets containing information about the failed link and distribute the control
 * packets to all their immediate neighbors (over links that haven't failed themselves).
 * <p>
 * When a router receives a control packet, it updates its internal layout of the network and passes copies of the
 * control packet to its neighbors.
 * <p>
 * If a router receives more than one packet at the same time, it will analyze all the incoming
 * packets before generating any outgoing traffic.
 * <p>
 * At time index 0, a number of links failed and a single data packet was sent from router A to router B.
 * You are given the initial layout of the network as an array 'layout', the list of failed links as a and the integers A and B.
 * <p>
 * The routers are labelled with integers between 1 and 99. Links in layout will be formatted as "ROUTER1 ROUTER2 TIME",
 * meaning that the link connects routers labelled ROUTER1 and ROUTER2 and it takes TIME time units for
 * packets to be sent over it.
 * <p>
 * A value of x in failed means that the link described by element x of layout has failed (index is 0-based).
 * <p>
 * Return an int, the number of time units needed for the data packet to reach router B.
 * If the packet can never reach the destination, return -1.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AdaptiveRouting {

    public int deliveryTime(String[] layout, int[] failedConnectionIndices, int sourceRouterId, int destinationRouterId) {
        // create our initial network
        Network network = new Network(layout);

        Router destinationRouter = network.idRouterMap.get(destinationRouterId);
        Router sourceRouter = network.idRouterMap.get(sourceRouterId);

        // generate a shortest path for each not to the end node
        Dijkstra.computePaths(destinationRouter, Collections.emptySet());
        network.idRouterMap.values().forEach(Router::saveCalculationPath);

        PriorityQueue<Event> eventPriorityQueue = new PriorityQueue<>(new EventComparator());
        eventPriorityQueue.add(new DataEvent(sourceRouter, destinationRouter, 0));
        for (int failedIndex : failedConnectionIndices) {
            BiDirectionConnection biDirectionConnection = network.indexConnectionMap.get(failedIndex);
            eventPriorityQueue.add(new DeadConnectionEvent(failedIndex, biDirectionConnection.connectionOne.source, 0));
            eventPriorityQueue.add(new DeadConnectionEvent(failedIndex, biDirectionConnection.connectionOne.destination, 0));
        }

        List<Event> newEvents = new ArrayList<>();
        while (!eventPriorityQueue.isEmpty()) {
            Event event = eventPriorityQueue.poll();

            switch (event.getEventType()) {
                case DATA:
                    DataEvent dataEvent = (DataEvent) event;
                    if (dataEvent.sourceRouter.equals(destinationRouter)) {
                        return event.getTimeActive();
                    } else {
                        forwardDataConnectionEvent(dataEvent).ifPresent(newEvents::add);
                    }
                    break;

                case DEAD_CONNECTION:
                    handleDeadConnectionEvent(network, (DeadConnectionEvent) event, destinationRouter).forEach(newEvents::add);
                    break;
            }

            Event peek = eventPriorityQueue.peek();
            if (peek == null || peek.getTimeActive() > event.getTimeActive()) {
                newEvents.forEach(eventPriorityQueue::add);
                newEvents.clear();
            }
        }

        return -1;
    }

    private Optional<Event> forwardDataConnectionEvent(DataEvent event) {
        Router startOfJump = event.sourceRouter;
        Router endOfJump = startOfJump.previous;
        Connection connectionWeWouldTraverse = startOfJump.connectionsByRouter.get(endOfJump);

        // make sure we have not run into a case where we cannot traverse anywhere
        if (connectionWeWouldTraverse == null) {
            return Optional.empty();
        }

        if (startOfJump.knownFailures.contains(connectionWeWouldTraverse)) {
            Connection connection = endOfJump.connectionsByRouter.get(startOfJump);
            return Optional.of(new DataEvent(endOfJump, startOfJump, connection.cost + event.getTimeActive()));
        } else {
            return Optional.of(new DataEvent(endOfJump, endOfJump, connectionWeWouldTraverse.cost + event.getTimeActive()));
        }

    }

    private List<Event> handleDeadConnectionEvent(Network network, DeadConnectionEvent event, Router finalDestinationRouter) {
        Connection deadConnectionOne = network.indexConnectionMap.get(event.connectionIndex).connectionOne;
        Connection deadConnectionTwo = network.indexConnectionMap.get(event.connectionIndex).connectionTwo;
        Router messageDestination = event.getDestination();

        // If we already know about the failure, then don't handle it again
        if (messageDestination.knownFailures.contains(deadConnectionOne) || messageDestination.knownFailures.contains(deadConnectionTwo)) {
            return Collections.emptyList();
        }

        // otherwise ... let this router know about the dead connection
        messageDestination.knownFailures.add(deadConnectionOne);
        messageDestination.knownFailures.add(deadConnectionTwo);

        // regenerate the shortest path from THIS NODE to the final destination
        network.idRouterMap.values().forEach(router -> {
            router.calculationMinDistance = Integer.MAX_VALUE;
            router.calculationPrevious = null;
        });
        // but only not including dead nodes that this particular router knows about
        Dijkstra.computePaths(finalDestinationRouter, messageDestination.knownFailures);
        messageDestination.saveCalculationPath();

        // and generate the dead connection message to the neighbors
        return messageDestination.connections.stream()
                .filter(connection -> !messageDestination.knownFailures.contains(connection))
                .map(connection -> new DeadConnectionEvent(event.connectionIndex, connection.destination, event.getTimeActive() + connection.cost))
                .collect(Collectors.toList());
    }

    private enum EventType {
        DEAD_CONNECTION(0), DATA(1);

        private final Integer priority;

        EventType(Integer priority) {
            this.priority = priority;
        }
    }

    private static class Router implements Comparable<Router> {

        private final List<Connection> connections;
        private final Map<Router, Connection> connectionsByRouter;
        private final Integer id;
        private Set<Connection> knownFailures;
        private Integer calculationMinDistance = Integer.MAX_VALUE;
        private Router calculationPrevious;

        private Integer minDistance = Integer.MAX_VALUE;
        private Router previous;

        private Router(int id) {
            this.id = id;
            this.connections = new ArrayList<>();
            this.knownFailures = new HashSet<>();
            this.connectionsByRouter = new HashMap<>();
        }

        @Override
        public int compareTo(Router other) {
            return Double.compare(minDistance, other.minDistance);
        }

        @Override
        public String toString() {
            return String.format("(%s -> %s [%s])", id, connections.stream().map(conn -> conn.destination.id).collect(Collectors.toList()), minDistance);
        }

        private void saveCalculationPath() {
            this.minDistance = calculationMinDistance;
            this.previous = calculationPrevious;
        }

        private void addConnection(Connection connection) {
            this.connections.add(connection);
            this.connectionsByRouter.put(connection.destination, connection);
        }
    }

    private static class Connection {
        private final Router source;
        private final Router destination;
        private final Integer cost;

        private Connection(Router source, Router destination, Integer cost) {
            this.source = source;
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return String.format("(%s <-> %s)", source.id, destination.id);
        }
    }

    private static class BiDirectionConnection {

        private final Connection connectionOne;
        private final Connection connectionTwo;

        private BiDirectionConnection(Connection connectionOne, Connection connectionTwo) {
            this.connectionOne = connectionOne;
            this.connectionTwo = connectionTwo;
        }
    }

    private interface Event {
        EventType getEventType();
        Integer getTimeActive();
    }

    private static class DeadConnectionEvent implements Event {

        private final Integer connectionIndex;
        private final Router destination;
        private final int timeActive;

        private DeadConnectionEvent(Integer connectionIndex, Router destination, int time) {
            this.connectionIndex = connectionIndex;
            this.destination = destination;
            this.timeActive = time;
        }

        @Override
        public EventType getEventType() {
            return EventType.DEAD_CONNECTION;
        }

        @Override
        public Integer getTimeActive() {
            return this.timeActive;
        }

        @Override
        public String toString() {
            return String.format("(%s : %s : %s : %s)", getEventType(), connectionIndex, getDestination().id, getTimeActive());
        }

        private Router getDestination() {
            return this.destination;
        }
    }

    private static class DataEvent implements Event {

        private final Router sourceRouter;
        private final Router destination;
        private final Integer timeActive;

        private DataEvent(Router sourceRouter, Router destination, Integer timeActive) {
            this.sourceRouter = sourceRouter;
            this.destination = destination;
            this.timeActive = timeActive;
        }

        @Override
        public EventType getEventType() {
            return EventType.DATA;
        }

        @Override
        public Integer getTimeActive() {
            return timeActive;
        }

        @Override
        public String toString() {
            return String.format("(%s : %s : %s : %s)", getEventType(), sourceRouter.id, destination.id, getTimeActive());
        }
    }

    private static class Network {

        private final Map<Integer, Router> idRouterMap;
        private final Map<Integer, BiDirectionConnection> indexConnectionMap;

        private Network(String[] layout) {
            this.idRouterMap = new HashMap<>();
            this.indexConnectionMap = new HashMap<>();

            for (int i = 0; i < layout.length; i++) {
                String connectionString = layout[i];
                String[] connectionDetails = connectionString.split(" ");
                Router sourceRouter = idRouterMap.computeIfAbsent(Integer.parseInt(connectionDetails[0]), Router::new);
                Router destinationRouter = idRouterMap.computeIfAbsent(Integer.parseInt(connectionDetails[1]), Router::new);
                Integer cost = Integer.parseInt(connectionDetails[2]);

                Connection connectionA = new Connection(sourceRouter, destinationRouter, cost);
                sourceRouter.addConnection(connectionA);

                Connection connectionB = new Connection(destinationRouter, sourceRouter, cost);
                destinationRouter.addConnection(connectionB);

                indexConnectionMap.put(i, new BiDirectionConnection(connectionA, connectionB));
            }
        }

        @Override
        public String toString() {
            return idRouterMap.values().toString();
        }
    }

    private static class Dijkstra {
        private static void computePaths(Router source, Set<Connection> knownFailures) {
            source.calculationMinDistance = 0;
            PriorityQueue<Router> routerQueue = new PriorityQueue<>();
            routerQueue.add(source);

            while (!routerQueue.isEmpty()) {
                Router router = routerQueue.poll();

                // Visit each connection exiting router
                for (Connection connection : router.connections) {
                    if (knownFailures.contains(connection)) {
                        continue;
                    }
                    Router v = connection.destination;
                    Integer weight = connection.cost;
                    Integer distanceThroughU = router.calculationMinDistance + weight;
                    if (distanceThroughU < v.calculationMinDistance) {
                        routerQueue.remove(v);

                        v.calculationMinDistance = distanceThroughU;
                        v.calculationPrevious = router;
                        routerQueue.add(v);
                    } else if (distanceThroughU.equals(v.calculationMinDistance) && v.id < router.id) {
                        // this extra if is to allow tie distance costs to instead of being
                        // chosen by who got there first, are now chosen by the lower ID winning
                        routerQueue.remove(v);

                        v.calculationMinDistance = distanceThroughU;
                        v.calculationPrevious = router;
                    }
                }
            }
        }
    }

    private class EventComparator implements Comparator<Event> {
        @Override
        public int compare(Event event1, Event event2) {
            int timeComparison = event1.getTimeActive().compareTo(event2.getTimeActive());
            if (timeComparison == 0) {
                return event1.getEventType().priority.compareTo(event2.getEventType().priority);
            } else {
                return timeComparison;
            }
        }
    }
}
