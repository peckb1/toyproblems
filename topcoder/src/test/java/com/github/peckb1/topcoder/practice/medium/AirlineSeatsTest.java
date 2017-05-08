package com.github.peckb1.topcoder.practice.medium;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AirlineSeatsTest {

    private AirlinerSeats airlinerSeats;

    @Before
    public void setUp() throws Exception {
        airlinerSeats = new AirlinerSeats();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertArrayEquals(new String[]{"..SS.S"}, this.airlinerSeats.mostAisleSeats(6, 3));

        Assert.assertArrayEquals(new String[]{"S.SS.S"}, this.airlinerSeats.mostAisleSeats(6, 4));

        Assert.assertArrayEquals(new String[]{"S.SS.SSSSSSS"}, this.airlinerSeats.mostAisleSeats(12, 10));

        Assert.assertArrayEquals(new String[]{".SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(11, 7));

        Assert.assertArrayEquals(new String[]{"SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "SS"}, this.airlinerSeats.mostAisleSeats(52, 52));

        Assert.assertArrayEquals(new String[]{"..................................................", "...............................................S.S"}, this.airlinerSeats.mostAisleSeats(200, 2));
    }

    @Test
    public void testTopcoderSystemTests() throws Exception {
        Assert.assertArrayEquals(new String[]{"..SS.S"}, this.airlinerSeats.mostAisleSeats(6, 3));
        Assert.assertArrayEquals(new String[]{"S.SS.S"}, this.airlinerSeats.mostAisleSeats(6, 4));
        Assert.assertArrayEquals(new String[]{"S.SS.SSSSSSS"}, this.airlinerSeats.mostAisleSeats(12, 10));
        Assert.assertArrayEquals(new String[]{".S"}, this.airlinerSeats.mostAisleSeats(2, 1));
        Assert.assertArrayEquals(new String[]{".SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(11, 7));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SSS"}, this.airlinerSeats.mostAisleSeats(11, 8));
        Assert.assertArrayEquals(new String[]{".SS.S"}, this.airlinerSeats.mostAisleSeats(5, 3));
        Assert.assertArrayEquals(new String[]{"S.SSS"}, this.airlinerSeats.mostAisleSeats(5, 4));
        Assert.assertArrayEquals(new String[]{"S.SSSS"}, this.airlinerSeats.mostAisleSeats(6, 5));
        Assert.assertArrayEquals(new String[]{"SSSSSS"}, this.airlinerSeats.mostAisleSeats(6, 6));
        Assert.assertArrayEquals(new String[]{"...SS.S"}, this.airlinerSeats.mostAisleSeats(7, 3));
        Assert.assertArrayEquals(new String[]{".S.SS.S"}, this.airlinerSeats.mostAisleSeats(7, 4));
        Assert.assertArrayEquals(new String[]{"S.SS.SS"}, this.airlinerSeats.mostAisleSeats(7, 5));
        Assert.assertArrayEquals(new String[]{"S.SSSSS"}, this.airlinerSeats.mostAisleSeats(7, 6));
        Assert.assertArrayEquals(new String[]{".SS.SS.S"}, this.airlinerSeats.mostAisleSeats(8, 5));
        Assert.assertArrayEquals(new String[]{"S.SS.SSS"}, this.airlinerSeats.mostAisleSeats(8, 6));
        Assert.assertArrayEquals(new String[]{"S.SSSSSS"}, this.airlinerSeats.mostAisleSeats(8, 7));
        Assert.assertArrayEquals(new String[]{"........"}, this.airlinerSeats.mostAisleSeats(8, 0));
        Assert.assertArrayEquals(new String[]{"SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "SS"}, this.airlinerSeats.mostAisleSeats(52, 52));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(111, 77));
        Assert.assertArrayEquals(new String[]{".S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(100000, 66666));
        Assert.assertArrayEquals(new String[]{"..................................................", ".................................................."}, this.airlinerSeats.mostAisleSeats(100000, 0));
        Assert.assertArrayEquals(new String[]{"."}, this.airlinerSeats.mostAisleSeats(1, 0));
        Assert.assertArrayEquals(new String[]{"S"}, this.airlinerSeats.mostAisleSeats(1, 1));
        Assert.assertArrayEquals(new String[]{".........................S.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(40, 10));
        Assert.assertArrayEquals(new String[]{"........................SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(40, 11));
        Assert.assertArrayEquals(new String[]{"..S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(41, 26));
        Assert.assertArrayEquals(new String[]{".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(41, 27));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSS"}, this.airlinerSeats.mostAisleSeats(41, 28));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSSSSS"}, this.airlinerSeats.mostAisleSeats(41, 29));
        Assert.assertArrayEquals(new String[]{".....SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(42, 25));
        Assert.assertArrayEquals(new String[]{"...S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(42, 26));
        Assert.assertArrayEquals(new String[]{"..SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(42, 27));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(42, 28));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSSS"}, this.airlinerSeats.mostAisleSeats(42, 29));
        Assert.assertArrayEquals(new String[]{"....S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(43, 26));
        Assert.assertArrayEquals(new String[]{"...SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(43, 27));
        Assert.assertArrayEquals(new String[]{".S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(43, 28));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS"}, this.airlinerSeats.mostAisleSeats(43, 29));
        Assert.assertArrayEquals(new String[]{"SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(47, 47));
        Assert.assertArrayEquals(new String[]{".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(50, 33));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSS"}, this.airlinerSeats.mostAisleSeats(50, 34));
        Assert.assertArrayEquals(new String[]{"S.SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(50, 49));
        Assert.assertArrayEquals(new String[]{"SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(50, 50));
        Assert.assertArrayEquals(new String[]{"...SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS", ".SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(64, 41));
        Assert.assertArrayEquals(new String[]{".S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS", ".SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(64, 42));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SS"}, this.airlinerSeats.mostAisleSeats(64, 43));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SSSSS"}, this.airlinerSeats.mostAisleSeats(64, 44));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SSSSSSSS"}, this.airlinerSeats.mostAisleSeats(64, 45));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(64, 46));
        Assert.assertArrayEquals(new String[]{"....SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S", "S.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(65, 41));
        Assert.assertArrayEquals(new String[]{"..S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S", "S.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(65, 42));
        Assert.assertArrayEquals(new String[]{".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S", "S.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(65, 43));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SSS"}, this.airlinerSeats.mostAisleSeats(65, 44));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SSSSSS"}, this.airlinerSeats.mostAisleSeats(65, 45));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(65, 46));
        Assert.assertArrayEquals(new String[]{".....SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(66, 41));
        Assert.assertArrayEquals(new String[]{"...S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(66, 42));
        Assert.assertArrayEquals(new String[]{"..SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(66, 43));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(66, 44));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SSSS"}, this.airlinerSeats.mostAisleSeats(66, 45));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SSSSSSS"}, this.airlinerSeats.mostAisleSeats(66, 46));
        Assert.assertArrayEquals(new String[]{".S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(100, 66));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS"}, this.airlinerSeats.mostAisleSeats(100, 67));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSSSS"}, this.airlinerSeats.mostAisleSeats(100, 68));
        Assert.assertArrayEquals(new String[]{"..S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(101, 66));
        Assert.assertArrayEquals(new String[]{".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(101, 67));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSS"}, this.airlinerSeats.mostAisleSeats(101, 68));
        Assert.assertArrayEquals(new String[]{"S.SS.SSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(14, 12));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SSSS"}, this.airlinerSeats.mostAisleSeats(21, 15));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS"}, this.airlinerSeats.mostAisleSeats(37, 25));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(28, 23));
        Assert.assertArrayEquals(new String[]{"..S"}, this.airlinerSeats.mostAisleSeats(3, 1));
        Assert.assertArrayEquals(new String[]{"...."}, this.airlinerSeats.mostAisleSeats(4, 0));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SSSSS"}, this.airlinerSeats.mostAisleSeats(13, 10));
        Assert.assertArrayEquals(new String[]{"...........................S"}, this.airlinerSeats.mostAisleSeats(28, 1));
        Assert.assertArrayEquals(new String[]{".SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(11, 7));
        Assert.assertArrayEquals(new String[]{"S.SSSSSSS"}, this.airlinerSeats.mostAisleSeats(9, 8));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(89, 69));
        Assert.assertArrayEquals(new String[]{"..................................................", ".................................S.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(92, 6));
        Assert.assertArrayEquals(new String[]{"..................................................", "...SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(72, 13));
        Assert.assertArrayEquals(new String[]{"............................SS.SS.SS.SS.SS.SS.SS.S", "S.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(71, 29));
        Assert.assertArrayEquals(new String[]{"...............................SS.SS.SS.SS.SS.SS.S", "S.S"}, this.airlinerSeats.mostAisleSeats(53, 15));
        Assert.assertArrayEquals(new String[]{"....................................S.SS.SS.SS.SS.", "SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(60, 16));
        Assert.assertArrayEquals(new String[]{"..................................................", "."}, this.airlinerSeats.mostAisleSeats(51, 0));
        Assert.assertArrayEquals(new String[]{"................................................S.", "SS.S"}, this.airlinerSeats.mostAisleSeats(54, 4));
        Assert.assertArrayEquals(new String[]{"..................................................", "...........................S.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(95, 12));
        Assert.assertArrayEquals(new String[]{"......SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(85, 53));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(93727, 62488));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSSSSSSSS", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(69295, 69281));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(24307, 18343));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(37298, 1324));
        Assert.assertArrayEquals(new String[]{"..................................................", ".................................................S"}, this.airlinerSeats.mostAisleSeats(31330, 1));
        Assert.assertArrayEquals(new String[]{"..................................................", ".................................................."}, this.airlinerSeats.mostAisleSeats(85737, 0));
        Assert.assertArrayEquals(new String[]{"..................................................", "...............................................S.S"}, this.airlinerSeats.mostAisleSeats(5201, 2));
        Assert.assertArrayEquals(new String[]{"..................................................", "..............................................SS.S"}, this.airlinerSeats.mostAisleSeats(81560, 3));
        Assert.assertArrayEquals(new String[]{"S.SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(62170, 62169));
        Assert.assertArrayEquals(new String[]{"S.SS.SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(62170, 62168));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(88159, 26509));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(98586, 4892));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(88855, 17330));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(83079, 64803));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(22944, 18585));
        Assert.assertArrayEquals(new String[]{".S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(95494, 63662));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(95494, 63678));
        Assert.assertArrayEquals(new String[]{"SS"}, this.airlinerSeats.mostAisleSeats(2, 2));
        Assert.assertArrayEquals(new String[]{"..................................................", "...............................................S.S"}, this.airlinerSeats.mostAisleSeats(200, 2));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(99999, 49999));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(100000, 75000));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(100000, 50));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(10000, 202));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS"}, this.airlinerSeats.mostAisleSeats(100000, 66667));
        Assert.assertArrayEquals(new String[]{"S.SS.SSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(14, 12));
        Assert.assertArrayEquals(new String[]{"SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(50, 50));
        Assert.assertArrayEquals(new String[]{".S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(100000, 66666));
        Assert.assertArrayEquals(new String[]{"S.SS.SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(99998, 99996));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS"}, this.airlinerSeats.mostAisleSeats(10, 7));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(100000, 50000));
        Assert.assertArrayEquals(new String[]{"S.SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(100000, 99999));
        Assert.assertArrayEquals(new String[]{"..................................................", ".................................................."}, this.airlinerSeats.mostAisleSeats(100000, 0));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(12345, 234));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSSS"}, this.airlinerSeats.mostAisleSeats(99999, 66667));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(100000, 99997));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(100000, 95000));
        Assert.assertArrayEquals(new String[]{"SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(100000, 100000));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(100000, 20000));
        Assert.assertArrayEquals(new String[]{"..................................................", "...................................S.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(99999, 10));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSSSSS"}, this.airlinerSeats.mostAisleSeats(10001, 6669));
        Assert.assertArrayEquals(new String[]{".."}, this.airlinerSeats.mostAisleSeats(2, 0));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(100000, 33329));
        Assert.assertArrayEquals(new String[]{"..................................................", ".........S"}, this.airlinerSeats.mostAisleSeats(60, 1));
        Assert.assertArrayEquals(new String[]{"..................................................", "...............................................S.S"}, this.airlinerSeats.mostAisleSeats(147, 2));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(86105, 17443));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(98345, 1345));
        Assert.assertArrayEquals(new String[]{"S.SS.SS"}, this.airlinerSeats.mostAisleSeats(7, 5));
        Assert.assertArrayEquals(new String[]{"..SS.S"}, this.airlinerSeats.mostAisleSeats(6, 3));
        Assert.assertArrayEquals(new String[]{".................................................."}, this.airlinerSeats.mostAisleSeats(50, 0));
        Assert.assertArrayEquals(new String[]{"S.SS"}, this.airlinerSeats.mostAisleSeats(4, 3));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SSSSSSSSSSSSSSSSSSSSSS"}, this.airlinerSeats.mostAisleSeats(111, 81));
        Assert.assertArrayEquals(new String[]{".............SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(50, 25));
        Assert.assertArrayEquals(new String[]{"."}, this.airlinerSeats.mostAisleSeats(1, 0));
        Assert.assertArrayEquals(new String[]{"..................................................", "............................................S.SS.S"}, this.airlinerSeats.mostAisleSeats(100000, 4));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SSSSSSSS"}, this.airlinerSeats.mostAisleSeats(10000, 6669));
        Assert.assertArrayEquals(new String[]{"..................................................", ".................................................S"}, this.airlinerSeats.mostAisleSeats(990, 1));
        Assert.assertArrayEquals(new String[]{"S.SS.SSSS"}, this.airlinerSeats.mostAisleSeats(9, 7));
        Assert.assertArrayEquals(new String[]{"SS"}, this.airlinerSeats.mostAisleSeats(2, 2));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SSS"}, this.airlinerSeats.mostAisleSeats(11, 8));
        Assert.assertArrayEquals(new String[]{".........S"}, this.airlinerSeats.mostAisleSeats(10, 1));
        Assert.assertArrayEquals(new String[]{"...SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(13, 7));
        Assert.assertArrayEquals(new String[]{"S.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.", "SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS"}, this.airlinerSeats.mostAisleSeats(10000, 6667));
        Assert.assertArrayEquals(new String[]{"S.SSSS"}, this.airlinerSeats.mostAisleSeats(6, 5));
        Assert.assertArrayEquals(new String[]{"..................................................", ".SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.SS.S"}, this.airlinerSeats.mostAisleSeats(91729, 33748));
        Assert.assertArrayEquals(new String[]{".S.S"}, this.airlinerSeats.mostAisleSeats(4, 2));
        Assert.assertArrayEquals(new String[]{".SS.S"}, this.airlinerSeats.mostAisleSeats(5, 3));
    }
}
