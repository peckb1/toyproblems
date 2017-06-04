package com.github.peckb1.projecteuler.p011to020;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 * <p>
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * <p>
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class Problem19 {

    public int sundays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        int sundays = 0;

        LocalDate localDate = startDateInclusive;
        while (localDate.isBefore(endDateExclusive)) {
            if (localDate.getDayOfMonth() == 1 && localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                sundays++;
            }
            localDate = localDate.plusDays(1);
        }

        return sundays;
    }

}
