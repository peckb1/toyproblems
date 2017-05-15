package com.github.peckb1.topcoder.practice.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Alberto is an aviation pioneer. He pilots an airplane called "14-bis". Initially, there are F units of fuel
 * in the fuel tank of his airplane.
 * <p>
 * There are some flight missions Alberto may take. The missions all start and end in the same location, and he
 * may do them in any order. However, he can only do each mission at most once. You are given two int[]s of the
 * same length: duration and refuel. For each valid i:
 * <p>
 * duration[i] is the amount of fuel consumed while running mission i
 * After Alberto completes mission i and gets paid, he will buy refuel[i] units of fuel. This amount will always
 * be strictly smaller than the amount consumed during the mission.
 * <p>
 * Alberto can only choose a mission if he has enough fuel for it. That is, at the beginning of the mission his
 * fuel tank must have at least duration[i] units of fuel.
 * <p>
 * Compute and return the maximum number of missions Alberto can take.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AlbertoTheAviator {

    public int MaximumFlights(int F, int[] duration, int[] refuel) {
        // create the list of missions
        List<Mission> missions = new ArrayList<>();
        for (int i = 0; i < duration.length; ++i) {
            // only bother to count missions which we have a change of flying
            if (duration[i] <= F) {
                missions.add(new Mission(duration[i], refuel[i]));
            }
        }
        // sort the missions by their refuel data
        // as the lower the refuel cost, the less fuel
        // that is possible to have in the tank after we're done
        // and we want to start with the missions that are guaranteed to
        // leave extra fuel in the tank after it's been completed
        missions.sort((o1, o2) -> o2.refuel.compareTo(o1.refuel));

        // create an array of fuel levels
        int[] flightsAtFuelLevels = new int[F + 1];

        // keep track for each mission
        for (Mission mission : missions) {
            // for each fuel increment starting at our fuel cost and going until the maximum fuel cost
            for (int fuel = mission.duration; fuel <= F; fuel++) {
                // calculate the fuel cost of the mission
                int fuelCost = mission.duration - mission.refuel;
                // and how much fuel would be remaining after we took the mission
                int remainingFuel = fuel - fuelCost;
                // keep track of the number of missions which were able to create the fuel level
                // for instance:
                // mission 6 cost 1 refuel
                // - would have        [0, 1, 1, 1, 1, 0, 0, 0, 0, 0]
                // as there were no previous flights, and after it ran we could be at fuel 1, 2, 3, 4, 5 but no others
                // mission 4 cost 0 refuel
                // - would then create [2, 1, 1, 1, 1, 1, 0, 0, 0, 0]
                // as at fuel 0 two flights could have flown {max(fuel[4] + 1, fuel[0]}
                flightsAtFuelLevels[remainingFuel] = Math.max(flightsAtFuelLevels[remainingFuel], flightsAtFuelLevels[fuel] + 1);
            }
        }

        // at the end of the mission details we just need to find the max value in our
        // list of fuel levels
        return Arrays.stream(flightsAtFuelLevels).reduce(0, Math::max);
    }

    private static class Mission {
        private final Integer duration;
        private final Integer refuel;

        private Mission(int duration, int refuel) {
            this.duration = duration;
            this.refuel = refuel;
        }

        @Override
        public String toString() {
            return String.format("(%s %s)", duration, refuel);
        }
    }

}
