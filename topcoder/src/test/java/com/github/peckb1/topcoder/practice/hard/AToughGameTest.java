package com.github.peckb1.topcoder.practice.hard;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AToughGameTest {

    private AToughGame aToughGame;

    @Before
    public void setUp() throws Exception {
        this.aToughGame = new AToughGame();
    }

    @Test
    public void testCopcoderExamples() throws Exception {
        Assert.assertEquals(10.0, this.aToughGame.expectedGain(
                new int[]{1000, 500},
                new int[]{3, 4}),
                0.000001);

        Assert.assertEquals(3003.9999999999977, this.aToughGame.expectedGain(
                new int[]{1000, 1},
                new int[]{3, 4}),
                0.000001);

        Assert.assertEquals(16.626830517153095, this.aToughGame.expectedGain(
                new int[]{500, 500, 500, 500, 500},
                new int[]{1, 2, 3, 4, 5}),
                0.000001);

        Assert.assertEquals(1067.6666666666667, this.aToughGame.expectedGain(
                new int[]{250, 750},
                new int[]{1000, 1}),
                0.000001);

        Assert.assertEquals(54204.93356505282, this.aToughGame.expectedGain(
                new int[]{916, 932, 927, 988, 958, 996, 944, 968, 917, 939, 960, 965, 960, 998, 920, 990, 915, 972, 995, 916, 902, 968, 970, 962, 922, 959, 994, 915, 996, 996, 994, 986, 945, 947, 912, 946, 972, 951, 973, 965, 921, 910, 938, 975, 942, 950, 900, 983, 960, 998, 982, 980, 902, 974, 952, 938, 900, 962, 920, 931, 964, 974, 953, 995, 946, 946, 903, 921, 923, 985, 919, 996, 930, 915, 991, 967, 996, 911, 999, 936, 1000, 962, 970, 929, 966, 960, 930, 920, 958, 926, 983},
                new int[]{583, 428, 396, 17, 163, 815, 31, 536, 175, 165, 532, 781, 29, 963, 331, 987, 599, 497, 380, 180, 780, 25, 931, 607, 784, 613, 468, 140, 488, 604, 401, 912, 204, 785, 697, 173, 451, 849, 714, 914, 650, 652, 338, 336, 177, 147, 22, 652, 901, 548, 370, 9, 118, 487, 779, 567, 818, 440, 10, 868, 316, 666, 690, 714, 623, 269, 501, 649, 324, 773, 173, 54, 391, 745, 504, 578, 81, 627, 319, 301, 16, 899, 658, 586, 604, 83, 520, 81, 181, 943, 157}),
                0.000001);
    }
}
