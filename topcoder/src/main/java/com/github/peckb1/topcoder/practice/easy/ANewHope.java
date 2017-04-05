package com.github.peckb1.topcoder.practice.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * In a galaxy far far away... each week has N days.
 * Luke Skywalker has exactly N shirts.
 * The shirts are numbered 1 through N.
 * Each day he wears one of those N shirts.
 * Each week he wears each shirt exactly once.
 * <p>
 * In different weeks Luke may wear his shirts in different orders.
 * However, not all orders are always possible.
 * Whenever Luke wears a shirt for a day, he has to wash it before he can use it again.
 * Washing and drying a shirt takes D-1 full days.
 * In other words, if he wears a shirt on day x, the earliest day when he can wear it again is day x+D.
 * <p>
 * Master Yoda recently sent Luke on a training mission that lasted for some unknown number of full N-day weeks.
 * He remembers the order in which he wore his shirts during the first week of the mission. He also remembers the
 * order in which he wore his shirts during the last week of the mission. You are given this information in s firstWeek
 * and lastWeek. Each of these s contains N elements: the numbers of shirts he wore during that week, in order.
 * You are also given the number of days D that it takes to wash a shirt.
 * <p>
 * For example, assume that N = 4, firstWeek = {1,2,3,4}, and lastWeek = {4,3,2,1} and D = 3. It is possible that this
 * particular mission took four weeks. One possible order in which Luke could have worn his shirts looks as follows:
 * week 1: {1,2,3,4}
 * week 2: {2,3,4,1}
 * week 3: {3,4,2,1}
 * week 4: {4,3,2,1}
 * Given firstWeek, lastWeek and D, compute and return the smallest number of weeks the mission could have taken.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class ANewHope {

    public int count(int[] firstWeek, int[] lastWeek, int D) {
        if (Arrays.equals(firstWeek, lastWeek)) {
            return 1; // first and last week
        }

        int numShirts = lastWeek.length;
        Map<Integer, Integer> lastWeekShirtIndexMap = new HashMap<>(numShirts);
        for (int i = 0; i < numShirts; i++) {
            lastWeekShirtIndexMap.put(lastWeek[i], i);
        }

        int maxWeeks = 0;
        for (int i = 0; i < numShirts; i++) {
            int firstWeekIndex = i;
            int shirt = firstWeek[firstWeekIndex];
            int lastWeekIndex = lastWeekShirtIndexMap.get(shirt);

            int weeksProgressed = 0;
            if (firstWeekIndex < lastWeekIndex) {
                // we are starting before our index, so as soon as we pass it, then we'll
                // know the next week would be an ok week
                while (firstWeekIndex < lastWeekIndex) {
                    firstWeekIndex += D;
                    weeksProgressed++;
                }
            } else { // firstWeekIndex >= lastWeekIndex
                // we are later in the week, we need to see if the next one loops us, and if so
                // are we <= to our value. otherwise we added and kept going so we're ok right away
                while (firstWeekIndex > lastWeekIndex) {
                    lastWeekIndex = lastWeekIndex + numShirts;
                    firstWeekIndex += D;
                    weeksProgressed++;
                }
            }
            maxWeeks = Math.max(maxWeeks, weeksProgressed);
        }

        return maxWeeks + 1;
    }

}
