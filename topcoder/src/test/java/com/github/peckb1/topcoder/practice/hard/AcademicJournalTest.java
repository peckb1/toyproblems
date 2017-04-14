package com.github.peckb1.topcoder.practice.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AcademicJournalTest {

    private AcademicJournal academicJournal;

    @Before
    public void setUp() throws Exception {
        this.academicJournal = new AcademicJournal();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertArrayEquals(
                new String[]{"A", "B", "C"},
                this.academicJournal.rankByImpact(new String[]{"A.", "B. 0", "C. 1 0 3", "C. 2"}));

        Assert.assertArrayEquals(
                new String[]{"RESPECTED JOURNAL", "RESPECTED SPECIFIC JOURNAL", "MEDIOCRE JOURNAL", "MEDIOCRE SPECIFIC JOURNAL", "LOUSY JOURNAL", "LOUSY SPECIFIC JOURNAL"},
                this.academicJournal.rankByImpact(new String[]{"RESPECTED JOURNAL.", "MEDIOCRE JOURNAL. 0", "LOUSY JOURNAL. 0 1", "RESPECTED JOURNAL.", "MEDIOCRE JOURNAL. 3", "LOUSY JOURNAL. 4 3 3 4", "RESPECTED SPECIFIC JOURNAL.", "MEDIOCRE SPECIFIC JOURNAL. 6", "LOUSY SPECIFIC JOURNAL. 6 7"}));

        Assert.assertArrayEquals(
                new String[]{"COMPLETELY ORIGINAL", "NO CITATIONS"},
                this.academicJournal.rankByImpact(new String[]{"NO CITATIONS.", "COMPLETELY ORIGINAL."}));

        Assert.assertArrayEquals(
                new String[]{"REV MODERN PHYSICS", "EUROPHYSICS LETTERS", "PHYSICS TODAY", "REP PROGRESS PHYSICS", "PHYSICS REPORTS", "PHYSICS LETTERS B", "PHYSICAL REVIEW LETTERS", "CONTEMPORARY PHYSICS", "J PHYS CHEM REF D", "J PHYS SOC JAPAN"},
                this.academicJournal.rankByImpact(new String[]{"CONTEMPORARY PHYSICS. 5 4 6 8 7 1 9", "EUROPHYSICS LETTERS. 9", "J PHYS CHEM REF D. 5 4 6 8 7 1 9", "J PHYS SOC JAPAN. 5 4 6 8 7 1 9", "PHYSICAL REVIEW LETTERS. 5 6 8 7 1 9", "PHYSICS LETTERS B. 6 8 7 1 9", "PHYSICS REPORTS. 8 7 1 9", "PHYSICS TODAY. 1 9", "REP PROGRESS PHYSICS. 7 1 9", "REV MODERN PHYSICS."}));
    }
}
