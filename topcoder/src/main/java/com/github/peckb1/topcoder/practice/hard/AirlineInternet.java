package com.github.peckb1.topcoder.practice.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * An airline wishes to supply passengers with Internet access on its flights. To do so, it is going to to install
 * powerful radio transceivers on all of its aircraft and at the airports it operates from. The airports will be
 * connected to the Internet and the aircraft will be able to access the connection via a radio link to any airport
 * that is within the range of its tranceiver. Aircraft will also be able to relay the Internet connection on to other
 * aircraft that are within range, so even if an aircraft cannot communicate directly with an airport, it may be able
 * to access the Internet via another aircraft. The cost of the radio equipment is proportional to its range and the
 * airline wishes to supply the Internet connection at minimal cost. It therefore wants your help in determining the
 * minimum transceiver range required such that all of the aircraft can access the Internet all of the time.
 * <p>
 * The area that the airline operates in is represented as a 2-D cartesian plane. You are given a airports containing
 * the locations of the airports that the airline operates from. Each element will contain two space-separated integers,
 * formatted without leading zeros, giving the x- and y-coordinates of an airport. You are also given the
 * flight-schedule in a flights. Each element of flights describes a single flight and will be formatted
 * "<start> <destination> <take-off time> <landing time>" (quotes for clarity). All elements are integers formatted
 * without leading zeros. <start> and <destination> reference zero-based indexes of airports in airports. The aircraft
 * starts out at the airport referenced by <start> at time <take-off time>, and flies in a straight line at constant
 * speed to the airport referenced in <destination>, arriving at <landing time>. All radio tranceivers have the same
 * range R and an aircraft can communicate with an airport or another aircraft if the in-plane distance between the
 * two is no greater than R. An aircraft can access the Internet if it can either communicate with an airport, or it
 * can communicate with another aircraft that can access the Internet (directly or indirectly). Return a double
 * containing the minimum value of R which ensures that all aircraft can access the Internet at all times.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AirlineInternet {

    /**
     * The algorithm here leverages the code from {@link com.github.peckb1.topcoder.practice.easy.Aircraft} ... somewhat
     * <p>
     * Basically we start with a large radius needed, and start shrinking the radius until
     * we get to a radius which no longer connects all the flights
     * <p>
     * Then we just bounce back and forth around that number until we're accurate within a range will
     * pass the topcoder tests
     */
    public double minimumRange(String[] airportLocations, String[] flightsArray) {
        List<Airport> allAirports = new ArrayList<>();
        List<Flight> flights = new ArrayList<>();

        for (String airport : airportLocations) {
            Scanner scanner = new Scanner(airport);
            allAirports.add(new Airport(scanner.nextInt(), scanner.nextInt()));
        }

        for (String flight : flightsArray) {
            Scanner scanner = new Scanner(flight);
            Airport src = allAirports.get(scanner.nextInt());
            Airport dst = allAirports.get(scanner.nextInt());
            int takeOff = scanner.nextInt();
            int landing = scanner.nextInt();

            flights.add(new Flight(src, dst, takeOff, landing));
        }

        double lowerEnd = 0;
        double upperEnd = 5000;
        while ((upperEnd - lowerEnd) / upperEnd > 1e-11) {
            double middle = (lowerEnd + upperEnd) / 2;
            List<Double> important = new ArrayList<>();
            important.add(0.0);    // lower bound from Topcoder as to the minimum possible takeOff time
            important.add(1000.0); // upper bound from Topcoder as to the maximum possible landing time
            for (int i = 0; i < flights.size(); i++) { //for (int i = 0; i < n; ++i) {
                Flight myFlight = flights.get(i);
                important.add((double) myFlight.takeOff);//important.add(start[i] + 0.0);
                important.add((double) myFlight.landing);//important.add(finish[i] + 0.0);
                for (Airport airport : allAirports) {//for (int j = 0; j < m; ++j) {
                    //addImportants(important, x[src[i]] - x[j], y[src[i]] - y[j], vx[i], vy[i], finish[i] - start[i], middle, start[i]);
                    double flightTime = myFlight.landing - myFlight.takeOff;
                    double xDistanceFromAirport = myFlight.startLocation.x - airport.x;
                    double yDistanceFromAirport = myFlight.startLocation.y - airport.y;
                    addImportants(important, xDistanceFromAirport, yDistanceFromAirport, myFlight.deltaX, myFlight.deltaY, flightTime, middle, myFlight.takeOff);
                }

                for (int j = i + 1; j < flights.size(); j++) {
                    Flight theirFlight = flights.get(j);
                    int myTakeOff = myFlight.takeOff;
                    int myLanding = myFlight.landing;
                    int theirTakeOff = theirFlight.takeOff;
                    int theirLanding = theirFlight.landing;
                    if (myTakeOff < theirLanding && theirTakeOff < myLanding) { // if (start[i] < finish[j] && start[j] < finish[i]) {
                        double latestTakeOff = Math.max(myTakeOff, theirTakeOff);//Math.max(start[i], start[j]);
                        double earliestLanding = Math.min(myLanding, theirLanding);//Math.min(finish[i], finish[j]);
                        double xi = myFlight.startLocation.x + myFlight.deltaX * (latestTakeOff - myTakeOff);//x[src[i]] + vx[i] * (latestTakeOff - start[i]);
                        double yi = myFlight.startLocation.y + myFlight.deltaY * (latestTakeOff - myTakeOff);//y[src[i]] + vy[i] * (latestTakeOff - start[i]);
                        double xj = theirFlight.startLocation.x + theirFlight.deltaX * (latestTakeOff - theirTakeOff);//x[src[j]] + vx[j] * (latestTakeOff - start[j]);
                        double yj = theirFlight.startLocation.y + theirFlight.deltaY * (latestTakeOff - theirTakeOff);//y[src[j]] + vy[j] * (latestTakeOff - start[j]);

                        double doubleTimeInAir = earliestLanding - latestTakeOff;
                        double distanceBetweenX = xi - xj;
                        double distanceBetweenY = yi - yj;
                        double deltaXBetweenFlights = myFlight.deltaX - theirFlight.deltaX;
                        double deltaYBetweenFlights = myFlight.deltaY - theirFlight.deltaY;

                        addImportants(important, distanceBetweenX, distanceBetweenY, deltaXBetweenFlights, deltaYBetweenFlights, doubleTimeInAir, middle, latestTakeOff);
                    }
                }
            }
            Collections.sort(important);
            boolean ok = true;
            for (int i = 0; i < important.size() - 1; i++) {
                List<Boolean> flightConnected = new ArrayList<>();
                List<Location> connectionLocations = new ArrayList<>();
                double t = (important.get(i) + important.get(i + 1)) / 2.0;

                // setup our airplane connection spots
                for (Flight flight : flights) {
                    flightConnected.add(false);
                    Location startLocation = flight.startLocation;

                    if (t < flight.takeOff) {
                        connectionLocations.add(startLocation);
                    } else if (t > flight.landing) {
                        connectionLocations.add(flight.endLocation);
                    } else {
                        double x = startLocation.x + flight.deltaX * (t - flight.takeOff);
                        double y = startLocation.y + flight.deltaY * (t - flight.takeOff);
                        connectionLocations.add(new Location(x, y));
                    }
                }

                // check to see if we are connected to an airport, or another flight
                for (Airport airport : allAirports) {
                    mark(airport.x, airport.y, -1, flightConnected, connectionLocations, flights.size(), middle);//mark(x[j], y[j], -1, conn, cx, cy, n, middle);
                }

                // if we have something not connected then `ok` is gonna be false
                for (int j = 0; j < flights.size(); ++j) {
                    if (!flightConnected.get(j)) {
                        ok = false;
                        break;
                    }
                }

                // we already hit a bad case, so just bail
                if (!ok) {
                    break;
                }
            }

            // if the radius was ok, shrink the upper end
            if (ok) {
                upperEnd = middle;
            } else {
                // otherwise shrink the lower end to increase the radius 'middle' next iteration
                lowerEnd = middle;
            }
        }

        return upperEnd;
    }

    private void mark(double x, double y, int id, List<Boolean> conn, List<Location> c, int n, double r) {
        // since we start at -1, if we have a valid id - mark it as connected
        if (id >= 0) {
            conn.set(id, true);
        }
        // for all of the flights if we can connect to another flight, mark it valid
        for (int i = 0; i < n; i++) {
            Location location = c.get(i);
            double dx = x - location.x;
            double dy = y - location.y;
            if (!conn.get(i) && (dx * dx + dy * dy <= r * r)) {
                mark(location.x, location.y, i, conn, c, n, r);
            }
        }
    }

    private void addImportants(List<Double> important, double x, double y, double vx, double vy, double t, double r, double delta) {
        if (t == 0) {
            return;
        }
        double x2 = x + vx * t;
        double y2 = y + vy * t;
        int s1 = (int) Math.signum(x * x + y * y - r * r);
        int s2 = (int) Math.signum(x2 * x2 + y2 * y2 - r * r);
        if (s1 <= 0 && s2 <= 0) {
            return;
        }
        if (s1 > 0 && s2 > 0) {
            if (x * vx + y * vy >= 0 || x2 * vx + y2 * vy <= 0) {
                return;
            }
            double z = -(x * vx + y * vy) / (vx * vx + vy * vy);
            double x3 = x + vx * z;
            double y3 = y + vy * z;
            int s3 = (int) Math.signum(x3 * x3 + y3 * y3 - r * r);
            if (s3 > 0) {
                return;
            }
            important.add(getImportant(x, y, vx, vy, z, r) + delta);
            important.add(delta + t - getImportant(x2, y2, -vx, -vy, t - z, r));
        } else if (s2 <= 0) {
            important.add(getImportant(x, y, vx, vy, t, r) + delta);
        } else if (s1 <= 0) {
            important.add(delta + t - getImportant(x2, y2, -vx, -vy, t, r));
        }
    }

    private double getImportant(double x, double y, double vx, double vy, double t, double rad) {
        double l = 0;
        double r = t;
        while ((r - l) / r > 1e-12) {
            double m = (r + l) / 2;
            double cx = x + vx * m;
            double cy = y + vy * m;
            if (cx * cx + cy * cy - rad * rad > 0) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }

    private class Flight {
        final Location startLocation;
        final Location endLocation;
        final int takeOff;
        final int landing;
        final double deltaX;
        final double deltaY;

        Flight(Airport source, Airport destination, int takeOff, int landing) {
            this.startLocation = source;
            this.endLocation = destination;
            this.takeOff = takeOff;
            this.landing = landing;
            deltaX = (endLocation.x - startLocation.x) / (landing - takeOff);
            deltaY = (endLocation.y - startLocation.y) / (landing - takeOff);
        }
    }

    private class Airport extends Location {
        private Airport(int x, int y) {
            super(x, y);
        }
    }

    private class Location {
        final double x;
        final double y;

        Location(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

}
