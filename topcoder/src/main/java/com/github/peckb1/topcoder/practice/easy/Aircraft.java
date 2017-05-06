package com.github.peckb1.topcoder.practice.easy;

/**
 * In aviation, a "near miss" occurs if the distance between two aircraft at some point in time is less than or
 * equal to some threshold distance R. At a moment in time, the positions and velocities of two aircraft are
 * known exactly. Assuming that each aircraft continues to fly with constant speed and direction, you need to
 * work out if the aircraft will undergo a near miss now or at some point in the future.
 * <p>
 * You will be given the threshold distance R and the positions and velocities of the aircraft in 4 s: p1, v1,
 * p2 and v2. The position of the first aircraft in 3-D cartesian space is given by (p1[0] , p1[1] , p1[2])
 * and its velocity vector by (v1[0] , v1[1] , v1[2]) and similarly the second aircraft's position and velocity
 * are given by (p2[0] , p2[1] , p2[2]) and (v2[0] , v2[1] , v2[2]). So, if an aircraft's initial position is the
 * vector p and its velocity vector is v, the position of this aircraft at some future time t will be p + v * t.
 * You should return a String containing "YES" if the aircraft will undergo a near miss now or in the future or
 * "NO" if they won't (quotes for clarity).
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class Aircraft {

    static final String NEAR_MISS = "YES";
    static final String SAFE = "NO";

    public String nearMiss(int[] p1, int[] v1, int[] p2, int[] v2, int R) {
        long deltaVx = v1[0] - v2[0];
        long deltaVy = v1[1] - v2[1];
        long deltaVz = v1[2] - v2[2];

        long initialDeltaX = p1[0] - p2[0];
        long initialDeltaY = p1[1] - p2[1];
        long initialDeltaZ = p1[2] - p2[2];

        if (equivalentVelocities(deltaVx, deltaVy, deltaVz)) { // the distances will
            return (distance(initialDeltaX, initialDeltaY, initialDeltaZ) <= Math.pow(R, 2)) ? NEAR_MISS : SAFE;
        }

        double timeAtClosestIntersection = - (double) (initialDeltaX * deltaVx + initialDeltaY * deltaVy + initialDeltaZ * deltaVz) / (deltaVx * deltaVx + deltaVy * deltaVy + deltaVz * deltaVz);

        if (timeAtClosestIntersection < 0) { // we're at the closest spot now so just see if we're within range
            return (distance(initialDeltaX, initialDeltaY, initialDeltaZ) <= Math.pow(R, 2)) ? NEAR_MISS : SAFE;
        }

        // find out the distance at our closest point in time
        double distance = distance(deltaVx * timeAtClosestIntersection + initialDeltaX,
                                   deltaVy * timeAtClosestIntersection + initialDeltaY,
                                   deltaVz * timeAtClosestIntersection + initialDeltaZ);

        return distance <= R * R ? NEAR_MISS : SAFE;
    }

    private boolean equivalentVelocities(long deltaVx, long deltaVy, long deltaVz) {
        return deltaVx * deltaVx + deltaVy * deltaVy + deltaVz * deltaVz == 0;
    }

    private double distance(double deltaX, double deltaY, double deltaZ) {
        return Math.pow(deltaX, 2) + Math.pow(deltaY, 2) + Math.pow(deltaZ, 2);
    }
}
