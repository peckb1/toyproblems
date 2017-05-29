package com.github.peckb1.projecteuler.p011to020;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem13 {

    public BigInteger bigSum(BigInteger[] numbers) {
        return Arrays.stream(numbers).reduce(BigInteger.ZERO, BigInteger::add);
    }

}
