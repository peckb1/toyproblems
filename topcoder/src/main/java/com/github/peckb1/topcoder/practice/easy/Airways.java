package com.github.peckb1.topcoder.practice.easy;

/**
 * Air traffic control requires that the routes of aircraft be restricted. We want to investigate the costs of
 * requiring aircraft to fly only in a few directions. For example, we could require them to fly only north,
 * east, south, or west.
 * It makes sense to distribute the allowable directions evenly. If we allow only n directions, one will be
 * east and the others will be evenly distributed among all other possible directions. So if n is 3, the
 * three directions are east, 30 degrees west of north, and 30 degrees west of south. Adjacent directions then
 * differ by 120 degrees. Notice that if a direction is legal the opposite direction may not necessarily be legal.
 * <p>
 * The following picture shows a minimum way to fly to a destination which is 5 east and 3 north of the starting
 * point when n is 8. The 8 allowable directions are shown in blue. By flying a distance of 3*sqrt(2) northeast,
 * and then 2 east (or 2 east, and then 3*sqrt(2) northeast) we can get to our destination by travelling a total
 * distance of 3*sqrt(2) + 2. Notice that for any n and destination the minimal distance can be achieved using no
 * more than two directions.
 * <p>
 * Create a class Airways that contains a method distance that is given n (the number of legal directions),
 * east (the distance eastward to our destination), and north (the distance northward to our destination).
 * It returns the minimum distance we will have to fly to get to our destination under these requirements.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class Airways {

    public double distance(int n, int east, int north) {

        double angleDiffDegrees = 360.0 / n;
        // point is always between two of the vectors
        double[] anglesDegrees = new double[n];
        for (int i = 0; i < n; i++) {
            anglesDegrees[i] = angleDiffDegrees * (i);
        }

        // find out which two it's between
        double angleToPointDegrees = Math.toDegrees(Math.atan2(north, east));
        if (angleToPointDegrees < 0) {
            angleToPointDegrees += 360.0;
        }
        int upperIndex = 1;
        double lowerBound = anglesDegrees[upperIndex - 1];
        double upperBound = anglesDegrees[upperIndex];
        while (angleToPointDegrees > upperBound) {
            upperIndex++;
            lowerBound = anglesDegrees[upperIndex - 1];
            upperBound = anglesDegrees[upperIndex];
        }

        // find the distances traveled along each angle
        double distanceBetweenBounds = upperBound - lowerBound;

        double distanceBetweenAngleAndUpper = upperBound - angleToPointDegrees;
        double distanceBetweenAngleAndLower = angleToPointDegrees - lowerBound;
        double missingAngle = 180 - distanceBetweenBounds;

        double directDistanceToPoint = Math.sqrt(Math.pow(east, 2) + Math.pow(north, 2));

        // law of sin(s)
        double edgeB = directDistanceToPoint / Math.sin(Math.toRadians(missingAngle)) * Math.sin(Math.toRadians(distanceBetweenAngleAndUpper));
        double edgeA = directDistanceToPoint / Math.sin(Math.toRadians(missingAngle)) * Math.sin(Math.toRadians(distanceBetweenAngleAndLower));

        return edgeA + edgeB;
    }

}
