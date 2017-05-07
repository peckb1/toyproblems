package com.github.peckb1.topcoder.practice.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * You are working for a shipping company, TopShipper, that specializes in shipping products by air.
 * Your cargo jets transport items between a set of airports. From each airport, you can travel directly to some
 * subset of the other airports. (Some airports may be too far, or may not have a safe passageway.) The ability to
 * travel from one airport to another does not guarantee the ability to travel directly in the opposite direction.
 * <p>
 * You are about to send out a cargo plane on a trip to pick up a large shipment of a certain product. Unfortunately,
 * only one other airport has this product for pickup, and you aren't guaranteed that there is a safe, direct route to
 * the other airport. You may have to travel through one or more other airports to get to your final destination.
 * Nonetheless, you wish to ultimately end up at the airport that has your desired product, and which you can get to by
 * travelling the shortest possible distance.
 * <p>
 * You are to return a double indicating the number of miles travelled by the cargo plane along the optimal route
 * from the origin to the destination. If no such route exists, return -1.
 * <p>
 * Given two coordinates, (lat1, lon1) and (lat2, lon2), the shortest distance between them is across an arc known
 * as a great circle. The arclength along a great circle, between two points on the earth can be calculated as:
 * <p>
 * radius * acos(sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon1 - lon2))
 * For purposes of this problem, the radius of the earth is 4000 miles.
 * <p>
 * You are given the latitude and longitude coordinates of each airport in latitude and longitude. The i-th element
 * of latitude corresponds to the i-th element of longitude. You are also given String[] canTravel.
 * The i-th element of canTravel is a space-delimited list of the 0-based indices of the airports that
 * can be reached from airport i. Finally, you are given origin and destination, the indices of the airports
 * at which you start and end your trip.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AirTravel {

    private static final double RADIUS_OF_EARTH = 4000; // ...ish

    public double shortestTrip(int[] latitude, int[] longitude, String[] canTravel, int origin, int destination) {
        // create the "graph" of locations
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < latitude.length; i++) {
            int lat = latitude[i];
            int lon = longitude[i];

            Location location = new Location(lat, lon);

            locations.add(i, location);
        }
        for (int i = 0; i < canTravel.length; i++) {
            final int sourceIndex = i; // effectively final variable for our foreach below
            Arrays.stream(canTravel[i].split(" "))
                    .map(Integer::parseInt)
                    .forEach(destinationIndex -> {
                        Flight flight = new Flight(locations.get(sourceIndex), locations.get(destinationIndex));
                        locations.get(sourceIndex).addFlight(flight);
                    });
        }

        Location source = locations.get(origin);
        Location goal = locations.get(destination);

        // run a search algorithm
        return AStar(source, goal);
    }

    private static Double distance(Location a, Location b) {
        double lat1 = Math.toRadians(a.lat);
        double lat2 = Math.toRadians(b.lat);

        double lon1 = Math.toRadians(a.lon);
        double lon2 = Math.toRadians(b.lon);

        return (RADIUS_OF_EARTH * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2)));
    }

    private double AStar(Location start, Location goal) {
        PriorityQueue<Location> frontier = new PriorityQueue<>(new LocationComparator(goal));
        frontier.add(start);

        Map<Location, Double> costSoFar = new HashMap<>();

        costSoFar.put(start, 0.0);

        while (!frontier.isEmpty()) {
            Location current = frontier.poll();

            if (current.equals(goal)) {
                break;
            }

            for (Flight flight : current.flights) {
                Location destination = flight.destination;
                Double distance = flight.distance;

                double newCost = costSoFar.get(current) + distance;
                if (!costSoFar.containsKey(destination) || newCost < costSoFar.get(destination)) {
                    costSoFar.put(destination, newCost);
                    frontier.add(destination);
                }
            }
        }

        Double cost = costSoFar.get(goal);
        if (cost == null) {
            // no route found
            return -1.0;
        } else {
            return cost;
        }
    }

    private class Location {

        private final Integer lat;
        private final Integer lon;

        private final List<Flight> flights;

        private Location(int lat, int lon) {
            flights = new ArrayList<>(); // linked list? sorted set by distance?
            this.lat = lat;
            this.lon = lon;
        }

        @Override
        public String toString() {
            return String.format("(%s %s)", lat, lon);
        }

        private void addFlight(Flight flight) {
            this.flights.add(flight);
        }
    }

    private class Flight {

        private final Location source;
        private final Location destination;
        private final double distance;

        private Flight(Location source, Location destination) {
            this.source = source;
            this.destination = destination;
            this.distance = distance(source, destination);
        }

        @Override
        public String toString() {
            return String.format("%s -> %s", source, destination);
        }
    }

    private class LocationComparator implements Comparator<Location> {

        private final Location goal;

        private LocationComparator(Location goal) {
            this.goal = goal;
        }

        @Override
        public int compare(Location source, Location destination) {
            Double sourceDistance = distance(source, this.goal);
            Double destinationDistance = distance(destination, this.goal);

            return sourceDistance.compareTo(destinationDistance);
        }
    }
}
