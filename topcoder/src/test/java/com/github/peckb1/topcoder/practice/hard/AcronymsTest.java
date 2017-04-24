package com.github.peckb1.topcoder.practice.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AcronymsTest {

    private Acronyms acronyms;

    @Before
    public void setUp() throws Exception {
        this.acronyms = new Acronyms();
    }

    @Test
    public void testTopCoderExamples() throws Exception {
        Assert.assertEquals("We the people of the USA.",
                this.acronyms.acronize(new String[]{"We the people of the United States of America."}));

        Assert.assertEquals( "Don't worry. BH!",
                this.acronyms.acronize(new String[]{"Don't","worry.","Be","Happy!"}));

        Assert.assertEquals("Entering contests at TCI. is a good way to develop your skills.",
                this.acronyms.acronize(new String[]{"Entering contests at TopCoder, Inc.", "is a good way to develop your skills."}));

        Assert.assertEquals("Working at the USPS in the USA is a satisfying experience.",
                this.acronyms.acronize(new String[]{"Working at the United States Postal Service", "in the United States of America", "is a satisfying experience."}));

        Assert.assertEquals( "a A & a & a B",
                this.acronyms.acronize(new String[]{"a A & a & a B"}));

        Assert.assertEquals( "The First word can't be included. In A sequence, that is.",
                this.acronyms.acronize(new String[]{"The First word can't be included.  In","A sequence, that is."}));

        Assert.assertEquals( "A TT & & TEst",
                this.acronyms.acronize(new String[]{"A Test & Test & & TEst"}));

        Assert.assertEquals( "This is a TESTT. .Go Test",
                this.acronyms.acronize(new String[]{"This is a TEST tEST Test. ", ".Go Test"}));
    }
}
