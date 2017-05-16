package com.github.peckb1.topcoder.practice.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlgoHillTest {

    private AlgoHill algoHill;

    @Before
    public void setUp() throws Exception {
        this.algoHill = new AlgoHill();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(5,
                this.algoHill.astar(new String[]{"34567", "23456", "12345", "23456", "34567"}, 0, 2, 2, 2));

        Assert.assertEquals(25,
                this.algoHill.astar(new String[]{"55555", "54555", "55355", "55525", "55551"}, 0, 0, 4, 4));

        Assert.assertEquals(21,
                this.algoHill.astar(new String[]{"55555", "54445", "54345", "54445", "55555"}, 0, 1, 4, 3));

        Assert.assertEquals(13,
                this.algoHill.astar(new String[]{"99999", "89992", "76543", "99992", "99991"}, 0, 0, 4, 0));

        Assert.assertEquals(1,
                this.algoHill.astar(new String[]{"68233335836531", "57244363483169", "92744511826738", "76864574378195", "39927887799237", "89447973623642", "19758793475135", "33857155647757", "82987352116383", "18813823791825", "91772225881964", "46692256258431", "41961397519198", "48265328441524", "31422961925492", "17844758382392", "47549368526297", "27955796939522", "59699922792416", "56366572279148", "26884644728715", "98234493558879", "38984599399327", "66812381124583", "73833939626911", "13681831986111", "69237772565286", "34347792857462"}, 8, 2, 8, 2));

        Assert.assertEquals(13,
                this.algoHill.astar(new String[]{"44435", "44425", "44445", "32445", "55555"}, 0, 0, 2, 2));
    }
}
