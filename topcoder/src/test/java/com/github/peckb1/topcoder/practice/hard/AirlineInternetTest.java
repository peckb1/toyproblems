package com.github.peckb1.topcoder.practice.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirlineInternetTest {

    private AirlineInternet airlineInternet;

    @Before
    public void setUp() throws Exception {
        this.airlineInternet = new AirlineInternet();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
              assertEquals(50.0,
                this.airlineInternet.minimumRange(new String[]{"0 0", "100 0"}, new String[]{"0 1 0 100"}),
                1e-8);

        assertEquals(25.0,
                this.airlineInternet.minimumRange(new String[]{"0 0", "100 0"}, new String[]{"0 1 0 100", "0 1 25 125", "0 1 50 150", "0 1 75 175"}),
                1e-8);

        assertEquals(64.28201130009927,
                this.airlineInternet.minimumRange(new String[]{"25 100", "0 50", "90 150", "22 22", "60 1", "95 8", "12 40"}, new String[]{"0 1 0 500", "2 5 10 300", "2 0 100 200", "3 6 150 400", "4 5 50 450", "5 1 0 300", "2 6 10 100"}),
                1e-8);

        assertEquals(25.0,
                this.airlineInternet.minimumRange(new String[]{"0 0", "50 0", "100 0"}, new String[]{"0 1 0 100"}),
                1e-8);

        assertEquals(246.618769031594,
                this.airlineInternet.minimumRange(new String[]{"417 262", "519 592", "941 778"}, new String[]{"0 1 376 534", "0 2 603 763", "1 0 137 431", "0 1 525 583", "2 1 367 551", "0 1 953 996", "0 1 668 886"}),
                1e-8);

        assertEquals(298.18759041416865,
                this.airlineInternet.minimumRange(new String[]{"101 591", "283 183", "346 696", "436 638", "738 46"}, new String[]{"3 0 855 890", "2 0 260 698", "3 4 229 743", "1 2 519 898", "3 1 863 955", "4 0 407 993", "2 4 872 969", "0 3 320 663"}),
                1e-8);

        assertEquals(358.8652253980556,
                this.airlineInternet.minimumRange(new String[]{"152 998", "656 487", "75 999", "913 535"}, new String[]{"1 0 347 530", "0 3 75 819", "3 1 893 935", "1 0 971 992", "2 0 471 887", "2 0 924 955"}),
                1e-8);
    }
}
