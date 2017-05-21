package com.github.peckb1.projecteuler;

import java.math.BigInteger;
import java.util.List;

public class Problem5 {

    public long lcm(List<Long> values) {
        return values.stream().reduce(this::lcm).orElse(0L);
    }

    private long lcm(long a, long b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    private int gcd(long a, long b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}
