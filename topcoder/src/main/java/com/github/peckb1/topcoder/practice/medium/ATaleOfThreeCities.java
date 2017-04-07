package com.github.peckb1.topcoder.practice.medium;

import java.util.Arrays;

/**
 * As a result of ever increasing traffic jams, subway transportation in big cities has become a must. A train can
 * actually take you from your home to your office faster than a car can. But what happens if you have your office
 * in another city? In this problem we consider three different cities: A, B and C. Each of these cities has its own
 * subway transportation system and you can go from a station to any other in the same city without having to leave
 * the underground. A big project is now underway, and the goal is to merge the subway lines such that transportation
 * between these cities becomes available soon. In order to achieve this, it was decided that two tunnels would be
 * constructed, each of them connecting two subway stations in two different cities. This has to be done at a minimal
 * cost, so it is important which subway stations are chosen. Also consider that the only factor in determining the
 * cost is the distance between the two subway stations connected by a tunnel.
 * <p>
 * You will be given a int[] ax, a int[] ay, a int[] bx, a int[] by, a int[] cx and a int[] cy with the following signification:
 * ax and ay represent the coordinates of the subway stations in city A i.e (ax[i],ay[i]) is the point denoting the place of the i-th station
 * bx and by represent the coordinates of the subway stations in city B i.e (bx[i],by[i]) is the point denoting the place of the i-th station
 * cx and cy represent the coordinates of the subway stations in city C i.e (cx[i],cy[i]) is the point denoting the place of the i-th station
 * <p>
 * Return the minimal added distance of the two tunnels such that all three cities become connected.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class ATaleOfThreeCities {

    public double connect(int[] ax, int[] ay, int[] bx, int[] by, int[] cx, int[] cy) {
        // find the shortest distance between A and C
        double AtoB = shortestDistance(ax, ay, bx, by);
        // find the shortest distance between A and B
        double AtoC = shortestDistance(ax, ay, cx, cy);
        // find the shortest distance between B and C
        double BtoC = shortestDistance(bx, by, cx, cy);

        double[] distances = new double[]{AtoB, AtoC, BtoC};
        Arrays.sort(distances);

        return distances[0] + distances[1];

        // find the two shortest distances of those three distances
    }

    //  Distance = ((x2−x1)^2+(y2−y1)^2)^1/2
    private double shortestDistance(int[] x1, int[] y1, int[] x2, int[] y2) {
        double shortest = Double.MAX_VALUE;
        for (int c1i = 0; c1i < x1.length; c1i++) {
            for (int c2i = 0; c2i < x2.length; c2i++) {
                double distance = Math.sqrt(Math.pow(x2[c2i] - x1[c1i], 2) + Math.pow(y2[c2i] - y1[c1i], 2));
                shortest = Math.min(shortest, distance);
            }
        }
        return shortest;
    }

}
