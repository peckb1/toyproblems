package com.github.peckb1.topcoder.practice.medium;

/**
 * Note: this problem statement contains an image that may not display properly if viewed outside the applet.
 * <p>
 * When on a long flight, it is often helpful to be in an aisle seat (a seat adjacent to an aisle). This way you don't
 * need to bother another passenger when you need to go to the restroom or take a walk. However, because large
 * airliners are built to hold as many passengers as possible, only a limited number of seats can be aisle seats.
 * <p>
 * A typical arrangement of 10 seats in a single row with 2 aisles is as follows:
 * <p>
 * [O O G] [G O O G] [G O O]
 * <p>
 * Aisle seats are colored green in the above example (there are four such seats), while center and window
 * seats are colored orange.
 * <p>
 * All of the seats are equally wide and each aisle has the same width as a single seat. If an airplane's
 * row is wide enough to fit width seats or aisles, and the airline wants exactly 'seats' seats to be fitted
 * in a row, find the arrangement which maximizes the number of aisle seats. A row should be formatted as
 * a string of characters so that seats and aisles are represented by 'S' and '.' (dot) characters, respectively.
 * If there are multiple arrangements which maximize the number of aisle seats, find the lexicographically
 * smallest one (the dot character comes before 'S' in the lexicographical order).
 * <p>
 * You are to return the required arrangement (or part of it) as a String[] containing no more than 2 Strings:
 * <p>
 * If width is 50 or less, return the entire arrangement as a single String inside the String[].
 * If width is between 51 and 100 (inclusive), return the entire arrangement as two Strings, split after the first 50 characters.
 * If width is more than 100, return two Strings containing the first and last 50 characters of the arrangement, respectively.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AirlinerSeats {

    public String[] mostAisleSeats(int width, int seats) {
        int bestAisleCount = width - seats;
        StringBuilder sb = new StringBuilder();

        int seatsFilled = 0;
        for(int i = 0; i < bestAisleCount; i++) {
            if (seatsFilled + 2 <= seats) {
                sb.insert(0, "S.S");
                seatsFilled += 2;
            } else if (seatsFilled + 1 <= seats) {
                sb.insert(0, ".S");
                seatsFilled += 1;
                i = bestAisleCount; // optimization - since no more aisles would have seats added around the, just bail
            }
        }

        if (seatsFilled < seats) { // optimization - only one while loop would actually run based on the problem

            while (seatsFilled < seats) {
                sb.append("S");
                seatsFilled += 1;
            }

        } else {

            // inserting to the front is expensive - so create another string and append to it
            StringBuilder dots = new StringBuilder();
            while (sb.length() + dots.length() < width) {
                dots.append(".");
            }
            // and then put those .(s) at the start of our string
            sb.insert(0, dots);

        }

        String arrangement = sb.toString();
        if (arrangement.length() <= 50) {
            return new String[]{arrangement};
        }

        if (arrangement.length() <= 100) {
            return new String[]{arrangement.substring(0, 50), arrangement.substring(50)};
        }

        return new String[]{arrangement.substring(0, 50), arrangement.substring(arrangement.length() - 50)};
    }

}
