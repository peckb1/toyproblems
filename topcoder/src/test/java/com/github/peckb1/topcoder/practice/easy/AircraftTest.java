package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AircraftTest {

    private Aircraft aircraft;

    @Before
    public void setUp() throws Exception {
        this.aircraft = new Aircraft();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(Aircraft.NEAR_MISS,
                this.aircraft.nearMiss(new int[]{15, 50, 5}, new int[]{25, 1, 0}, new int[]{161, 102, 9}, new int[]{-10, -10, -1}, 10));

        Assert.assertEquals(Aircraft.NEAR_MISS,
                this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{2, 2, 0}, new int[]{9, 0, 5}, new int[]{-2, 2, 0}, 5));

        Assert.assertEquals(Aircraft.SAFE,
                this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{-2, 2, 0}, new int[]{9, 0, 5}, new int[]{2, 2, 0}, 5));

        Assert.assertEquals(Aircraft.NEAR_MISS,
                this.aircraft.nearMiss(new int[]{-2838, -7940, -2936}, new int[]{1, 1, -2}, new int[]{532, 3850, 9590}, new int[]{1, 0, -3}, 3410));

        Assert.assertEquals(Aircraft.NEAR_MISS,
                this.aircraft.nearMiss(new int[]{-8509, 9560, 345}, new int[]{-89, -33, 62}, new int[]{-5185, -1417, 2846}, new int[]{-58, 24, 26}, 8344));

        Assert.assertEquals(Aircraft.SAFE,
                this.aircraft.nearMiss(new int[]{-7163, -371, -2459}, new int[]{-59, -41, -14}, new int[]{-2398, -426, -5487}, new int[]{-43, 27, 67}, 5410));

        Assert.assertEquals(Aircraft.NEAR_MISS,
                this.aircraft.nearMiss(new int[]{1774, -4491, 7810}, new int[]{-12, 19, -24}, new int[]{2322, 3793, 9897}, new int[]{-12, 19, -24}, 10000));

        Assert.assertEquals(Aircraft.SAFE,
                this.aircraft.nearMiss(new int[]{3731, 8537, 5661}, new int[]{-70, 71, 32}, new int[]{8701, -1886, -5115}, new int[]{28, -13, 7}, 9766));
    }
    
    @Test
    public void testTopcoderSystemTests() throws Exception {
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{15, 50, 5}, new int[]{25, 1, 0}, new int[]{161, 102, 9}, new int[]{-10, -10, -1}, 10), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{2, 2, 0}, new int[]{9, 0, 5}, new int[]{-2, 2, 0}, 5), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{-2, 2, 0}, new int[]{9, 0, 5}, new int[]{2, 2, 0}, 5), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-4921, 250, 5852}, new int[]{-2, 1, -2}, new int[]{-2, -1729, -9307}, new int[]{-2, 0, 0}, 9864), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-6987, -881, -5232}, new int[]{0, -2, -2}, new int[]{9835, -872, 8837}, new int[]{-1, -2, -4}, 8755), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{7492, 131, -2802}, new int[]{0, 1, 1}, new int[]{602, -9362, 9112}, new int[]{1, 3, 0}, 6444), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-9760, -689, 6267}, new int[]{2, 2, -2}, new int[]{7881, -1423, 4867}, new int[]{0, 1, -2}, 8660), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-2838, -7940, -2936}, new int[]{1, 1, -2}, new int[]{532, 3850, 9590}, new int[]{1, 0, -3}, 3410), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-4921, 250, 5852}, new int[]{-2, 1, -2}, new int[]{-2, -1729, -9307}, new int[]{-2, 0, 0}, 9863), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-6987, -881, -5232}, new int[]{0, -2, -2}, new int[]{9835, -872, 8837}, new int[]{-1, -2, -4}, 8754), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{7492, 131, -2802}, new int[]{0, 1, 1}, new int[]{602, -9362, 9112}, new int[]{1, 3, 0}, 6443), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-9760, -689, 6267}, new int[]{2, 2, -2}, new int[]{7881, -1423, 4867}, new int[]{0, 1, -2}, 8659), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-2838, -7940, -2936}, new int[]{1, 1, -2}, new int[]{532, 3850, 9590}, new int[]{1, 0, -3}, 3409), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-8509, 9560, 345}, new int[]{-89, -33, 62}, new int[]{-5185, -1417, 2846}, new int[]{-58, 24, 26}, 8343), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-8509, 9560, 345}, new int[]{-89, -33, 62}, new int[]{-5185, -1417, 2846}, new int[]{-58, 24, 26}, 8344), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-8837, -2570, -3892}, new int[]{22, 45, -29}, new int[]{9503, 1162, 7241}, new int[]{-95, -9, -66}, 7116), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-8837, -2570, -3892}, new int[]{22, 45, -29}, new int[]{9503, 1162, 7241}, new int[]{-95, -9, -66}, 7117), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{872, -4636, -3909}, new int[]{68, 46, 11}, new int[]{7185, 703, 1529}, new int[]{-88, -7, 96}, 8890), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{872, -4636, -3909}, new int[]{68, 46, 11}, new int[]{7185, 703, 1529}, new int[]{-88, -7, 96}, 8891), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-7163, -371, -2459}, new int[]{-59, -41, -14}, new int[]{-2398, -426, -5487}, new int[]{-43, 27, 67}, 5410), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-7163, -371, -2459}, new int[]{-59, -41, -14}, new int[]{-2398, -426, -5487}, new int[]{-43, 27, 67}, 5411), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{7448, -4019, 7503}, new int[]{80, 81, -74}, new int[]{9487, 320, 7057}, new int[]{30, -17, 80}, 3643), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{7448, -4019, 7503}, new int[]{80, 81, -74}, new int[]{9487, 320, 7057}, new int[]{30, -17, 80}, 3644), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-3524, -430, 9848}, new int[]{-82, -72, 55}, new int[]{-7590, -8706, 9853}, new int[]{-97, -33, 37}, 7204), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-3524, -430, 9848}, new int[]{-82, -72, 55}, new int[]{-7590, -8706, 9853}, new int[]{-97, -33, 37}, 7205), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{4431, -7298, 3341}, new int[]{34, 71, 35}, new int[]{906, 69, 2117}, new int[]{72, -81, 83}, 2010), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{4431, -7298, 3341}, new int[]{34, 71, 35}, new int[]{906, 69, 2117}, new int[]{72, -81, 83}, 2011), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{4274, -3305, 1209}, new int[]{-19, 97, -57}, new int[]{-14, 5972, 857}, new int[]{8, -47, -56}, 2521), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{4274, -3305, 1209}, new int[]{-19, 97, -57}, new int[]{-14, 5972, 857}, new int[]{8, -47, -56}, 2522), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1645, 4417, 6355}, new int[]{-14, 29, -85}, new int[]{9948, 3104, 2174}, new int[]{-13, -6, -3}, 8813), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{3884, -748, 6705}, new int[]{58, -52, -5}, new int[]{-4571, -1177, 6318}, new int[]{58, -52, -5}, 8474), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{3884, -748, 6705}, new int[]{58, -52, -5}, new int[]{-4571, -1177, 6318}, new int[]{58, -52, -5}, 8475), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{2865, -8636, -5491}, new int[]{-72, -79, 55}, new int[]{1887, -5387, -6267}, new int[]{-72, -79, 55}, 3480), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{2865, -8636, -5491}, new int[]{-72, -79, 55}, new int[]{1887, -5387, -6267}, new int[]{-72, -79, 55}, 3481), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1774, -4491, 7810}, new int[]{-12, 19, -24}, new int[]{2322, 3793, 9897}, new int[]{-12, 19, -24}, 8560), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1774, -4491, 7810}, new int[]{-12, 19, -24}, new int[]{2322, 3793, 9897}, new int[]{-12, 19, -24}, 10000), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-4628, 859, 6322}, new int[]{-64, -61, -20}, new int[]{5633, 7426, 9547}, new int[]{20, -58, 75}, 8432), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-4628, 859, 6322}, new int[]{-64, -61, -20}, new int[]{5633, 7426, 9547}, new int[]{20, -58, 75}, 8433), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-7593, 579, -9146}, new int[]{56, -21, 55}, new int[]{3668, -8134, 795}, new int[]{-56, 82, 49}, 9451), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-7593, 579, -9146}, new int[]{56, -21, 55}, new int[]{3668, -8134, 795}, new int[]{-56, 82, 49}, 9452), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-2611, 6642, 4107}, new int[]{-95, 9, -53}, new int[]{-3365, 276, -9263}, new int[]{-73, -15, 52}, 9320), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-2611, 6642, 4107}, new int[]{-95, 9, -53}, new int[]{-3365, 276, -9263}, new int[]{-73, -15, 52}, 9321), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-13, -9966, -7414}, new int[]{-64, -33, 52}, new int[]{-7920, -5123, -1713}, new int[]{-66, 45, 89}, 8335), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-13, -9966, -7414}, new int[]{-64, -33, 52}, new int[]{-7920, -5123, -1713}, new int[]{-66, 45, 89}, 8336), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-777, 2791, -952}, new int[]{-65, 98, -21}, new int[]{6929, -7286, 1573}, new int[]{-10, -69, 99}, 6257), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-777, 2791, -952}, new int[]{-65, 98, -21}, new int[]{6929, -7286, 1573}, new int[]{-10, -69, 99}, 6258), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-748, -3746, -65}, new int[]{41, -8, -82}, new int[]{-3872, 9801, 4798}, new int[]{-34, 94, 59}, 8330), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-748, -3746, -65}, new int[]{41, -8, -82}, new int[]{-3872, 9801, 4798}, new int[]{-34, 94, 59}, 8331), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-9100, -5265, -8023}, new int[]{73, -89, 95}, new int[]{-7372, -1078, 659}, new int[]{11, -94, -59}, 4251), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-9100, -5265, -8023}, new int[]{73, -89, 95}, new int[]{-7372, -1078, 659}, new int[]{11, -94, -59}, 4252), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-1605, -7199, -4764}, new int[]{62, -7, -89}, new int[]{-2897, -2402, -5350}, new int[]{-29, -72, 4}, 4701), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-1605, -7199, -4764}, new int[]{62, -7, -89}, new int[]{-2897, -2402, -5350}, new int[]{-29, -72, 4}, 4702), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{3731, 8537, 5661}, new int[]{-70, 71, 32}, new int[]{8701, -1886, -5115}, new int[]{28, -13, 7}, 9766), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{3731, 8537, 5661}, new int[]{-70, 71, 32}, new int[]{8701, -1886, -5115}, new int[]{28, -13, 7}, 9767), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{1, 0, 0}, new int[]{0, 0, 1}, new int[]{0, 1, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{1, 0, 0}, new int[]{0, 0, 1}, new int[]{1, 0, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 1, -1}, new int[]{3, -3, 3}, new int[]{1, -1, 1}, new int[]{3, 3, -3}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 2856, -2856}, new int[]{98, -9996, 9996}, new int[]{10000, -2856, 2856}, new int[]{98, 9996, -9996}, 10000), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 10000, -10000}, new int[]{3, -3, 3}, new int[]{10000, -10000, 10000}, new int[]{3, 3, -3}, 10000), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 10000, -10000}, new int[]{7, -7, 7}, new int[]{10000, -10000, 10000}, new int[]{7, 7, -7}, 10000), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-2838, -7940, -2936}, new int[]{1, 1, -2}, new int[]{532, 3850, 9590}, new int[]{1, 0, -3}, 3410), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-7163, -371, -2459}, new int[]{-59, -41, -14}, new int[]{-2398, -426, -5487}, new int[]{-43, 27, 67}, 5410), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{2, 2, 0}, new int[]{9, 0, 5}, new int[]{-2, 2, 0}, 5), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{15, 50, 5}, new int[]{25, 1, 0}, new int[]{161, 102, 9}, new int[]{-10, -10, -1}, 10), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-8509, 9560, 345}, new int[]{-89, -33, 62}, new int[]{-5185, -1417, 2846}, new int[]{-58, 24, 26}, 8344), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-10000, 0, 0}, new int[]{10000, 0, 0}, new int[]{1, 0, 0}, new int[]{0, 0, 0}, 0), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-1000, 0, 0}, new int[]{1, 0, 1000}, new int[]{1000, 0, 0}, new int[]{-1, 0, 1000}, 0), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{3731, 8537, 5661}, new int[]{-70, 71, 32}, new int[]{8701, -1886, -5115}, new int[]{28, -13, 7}, 9766), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{1, 1, 1}, new int[]{10000, 10000, 10000}, new int[]{-1, -1, -1}, 0), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{2, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{-2, 2, 0}, new int[]{9, 0, 5}, new int[]{2, 2, 0}, 5), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{10, 10, 0}, new int[]{-1, 0, 0}, new int[]{-10, -10, 0}, new int[]{0, 0, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{2, 2, 2}, new int[]{0, 0, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{-1, -1, -1}, new int[]{-1, -1, -1}, 10000), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-2837, -7940, -2936}, new int[]{1, 1, -2}, new int[]{532, 3850, 9590}, new int[]{1, 0, -3}, 3410), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{9999, 9999, 0}, new int[]{4, 0, 0}, new int[]{-5555, 5555, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{10000, 0, 0}, new int[]{-10000, 0, 0}, new int[]{-10000, 0, 0}, new int[]{1, 0, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{100, 1000, 10000}, new int[]{15, 9, 8}, new int[]{1200, 1300, 100}, new int[]{9, 8, 17}, 135), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 1000}, new int[]{0, 0, 2}, new int[]{0, 0, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{25, 1, 0}, new int[]{0, 0, 0}, new int[]{-10, -10, -1}, 0), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1, 1, 0}, new int[]{0, 10000, 0}, new int[]{1, 3, 0}, new int[]{0, -10000, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{0, 0, 0}, new int[]{1, 1, 1}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, 5), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{1, 0, 0}, new int[]{0, 0, 2}, new int[]{1, 0, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-7136, -371, -2459}, new int[]{-59, -41, -14}, new int[]{-2398, -426, -5487}, new int[]{-43, 27, 67}, 5410), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{1, 0, 0}, new int[]{10, 0, 2}, new int[]{-1, 0, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, 0), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1, 1, 1}, new int[]{0, 0, 0}, new int[]{2, 1, 1}, new int[]{0, 0, 0}, 10), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 1}, new int[]{0, 0, 0}, 0), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-2838, -7940, -2936}, new int[]{1, 1, -2}, new int[]{5323, 3850, 9590}, new int[]{1, 0, -3}, 3), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{2001, 2000, 0}, new int[]{9000, 0, 5000}, new int[]{-2000, 2000, 0}, 5000), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{2, 0, 0}, new int[]{0, 1, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-10000, 0, 0}, new int[]{0, 0, 0}, new int[]{10000, 0, 0}, new int[]{-1, 0, 0}, 0), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{10000, 10000, 10000}, new int[]{-10000, -10000, -10000}, new int[]{-10000, -10000, -10000}, new int[]{10000, 10000, 10000}, 10000), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{-2, 2, 0}, new int[]{9, 0, 5}, new int[]{2, 2, 0}, 100), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{-2, 0, 0}, new int[]{10000, 0, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{3731, 8537, 5661}, new int[]{70, 71, 32}, new int[]{8701, -1886, -5115}, new int[]{28, 80, 7}, 10000), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{15, 50, 5}, new int[]{25, 1, 0}, new int[]{161, 102, 9}, new int[]{25, 1, 0}, 10), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1, 0, 0}, new int[]{1, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{-5, 0, 0}, new int[]{5, 0, 0}, new int[]{5, 0, 0}, 5), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{1, 1, 1}, new int[]{10, 0, 0}, new int[]{1, 1, 1}, 5), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-10000, 0, 0}, new int[]{1, 0, 0}, new int[]{10000, 0, 0}, new int[]{0, 0, 0}, 0), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{10000, 0, 0}, new int[]{10, 0, 0}, new int[]{-10000, 0, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{4, 11, 0}, new int[]{0, -1, 0}, 2), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{10, 10, 10}, new int[]{-1, -1, -1}, 2), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{10, 0, 0}, new int[]{1, 0, 0}, 10), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1, 2, 3}, new int[]{1, 2, 3}, new int[]{100, 200, 300}, new int[]{1, 2, 3}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{10000, 0, 0}, new int[]{1000, 0, 0}, new int[]{-10000, 0, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{2, 2, 2}, new int[]{1, 1, 1}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{2, -1, 0}, new int[]{0, 2, 0}, 2), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{-1, 1, 0}, new int[]{10000, 0, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{1, 0, 0}, new int[]{1, 0, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 1, 0}, new int[]{0, -100, 0}, new int[]{0, 4000, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{10000, 0, 0}, new int[]{10, 0, 0}, new int[]{0, 0, 0}, 2), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{1, 0, 0}, new int[]{1, 0, 0}, 2), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{1, 1, 0}, new int[]{-200, 0, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1771, -1491, 7830}, new int[]{-12, 19, -24}, new int[]{2322, 3793, 9897}, new int[]{-12, 19, -24}, 1000), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-10000, -10000, -10000}, new int[]{0, 0, 1}, new int[]{10000, 10000, 10000}, new int[]{0, 0, 1}, 10000), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{10, 10, 10}, new int[]{10, 10, 10}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, 100), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-8509, 9560, 345}, new int[]{1, 2, 3}, new int[]{-5185, -1417, 2846}, new int[]{1, 2, 3}, 8344), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1774, -4491, 7810}, new int[]{-12, 19, -24}, new int[]{2322, 3793, 9897}, new int[]{-12, 19, -24}, 10), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{5, 5, 5}, new int[]{1, 0, 0}, new int[]{0, 0, 0}, new int[]{1, 0, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{3, 2, 3}, new int[]{1, 2, 3}, new int[]{1, 2, 3}, new int[]{1, 2, 3}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{1, 0, 0}, new int[]{0, 1, 0}, new int[]{1, 1, 0}, 2), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{50, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, 10), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{4, 2, 0}, new int[]{2, 0, 0}, new int[]{0, 2, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{3, 0, 0}, new int[]{0, 0, 0}, 2), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 1, 1}, new int[]{0, 0, 1}, new int[]{0, 1, -1}, 0), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 2, 0}, new int[]{2, 0, 0}, new int[]{-5, 2, 0}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{2, 2, 0}, new int[]{9, 0, 5}, new int[]{2, 2, 0}, 5), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1774, -4491, 7810}, new int[]{-12, 19, -24}, new int[]{2322, 3793, 9897}, new int[]{-12, 19, -24}, 5000), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{10, 0, 2}, new int[]{0, 0, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{22, 22, 22}, new int[]{1, 1, 1}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{10, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{31, 87, -51}, new int[]{121, 23, -323}, new int[]{23, -45, -10}, new int[]{28, -13, 7}, 10000), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-5000, -5000, 0}, new int[]{1, 1, 1}, new int[]{5000, -5000, 0}, new int[]{1, 1, 1}, 10), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 10}, new int[]{0, 0, 0}, 2), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{10000, 10000, 10000}, new int[]{-9999, -9999, -9999}, new int[]{-10000, -10000, -10000}, new int[]{9998, 9998, 9998}, 100), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 10}, new int[]{0, 0, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1, 1, 1}, new int[]{1, 1, 1}, new int[]{2, 2, 2}, new int[]{1, 1, 1}, 10), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-2838, -7940, -2936}, new int[]{1, 1, -2}, new int[]{532, 3850, 9590}, new int[]{1, 0, -3}, 5410), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{100, 0, 0}, new int[]{100, 0, 0}, 100), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 1}, new int[]{0, 0, 2}, new int[]{0, 0, 5}, new int[]{0, 0, 1}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{1, 1, 1}, new int[]{0, 0, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{10000, 10000, 1000}, new int[]{10000, -10000, 10000}, new int[]{10000, 10000, -1000}, new int[]{10000, -10000, -10000}, 1999), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 10000}, new int[]{0, 0, 500}, new int[]{0, 0, -10000}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{2, 2, 0}, new int[]{9, 0, 5}, new int[]{0, 2, 0}, 5), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{1774, 4491, 7810}, new int[]{0, 0, 0}, new int[]{-2322, 5793, 9897}, new int[]{0, 0, 0}, 10000), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{1000, 0, 0}, new int[]{0, 0, 0}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{1000, 1000, 1000}, new int[]{0, 0, 0}, new int[]{-1000, -1000, -1000}, 1), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{-10000, -10000, -10000}, new int[]{0, 0, 0}, new int[]{10000, 10000, 10000}, 10000), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{4336, 46, -2571}, new int[]{5882, 3100, 9715}, new int[]{121, 1734, -5770}, new int[]{5593, 7870, 6705}, 9755), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{1, 1, 1}, new int[]{0, 0, 100}, new int[]{1, 1, 1}, 1), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{100, 100, 0}, new int[]{442, 0, 10}, new int[]{-100, 100, 0}, 10), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{10000, 10000, 10000}, new int[]{-10000, -10000, -10000}, new int[]{-10000, -10000, -10000}, new int[]{10000, 10000, 10000}, 0), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-579, -553, -631}, new int[]{-782, -729, -833}, new int[]{-784, -774, -588}, new int[]{-605, -962, -701}, 309), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{0, 0, 0}, new int[]{5, 5, 5}, new int[]{4, 4, 0}, new int[]{5, 5, 5}, 5), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{5, 7, 8}, new int[]{4, 1, -7}, new int[]{-4, 5, 7}, new int[]{4, 1, -7}, 4), "NO");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{10000, 10000, 1000}, new int[]{10000, -10000, 10000}, new int[]{10000, 10000, -1000}, new int[]{10000, -10000, -10000}, 2000), "YES");
        Assert.assertEquals(this.aircraft.nearMiss(new int[]{-1, -1, 0}, new int[]{10000, 10000, 0}, new int[]{1, -1, 0}, new int[]{-10000, 10000, 0}, 0), "YES");
    }
}
