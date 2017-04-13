package com.github.peckb1.topcoder.practice.medium;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

/**
 * Let's consider an infinite sequence S of non-negative integers defined as follows:
 * <p>
 * S0 = first;
 * S1 = second;
 * Si = |Si-2 - Si-1| for all i >= 2.
 * <p>
 * You will be given s first and second, representing the 0-th and the 1-st elements of the sequence S,
 * and a indices, each element of which represents a non-negative integer without extra leading zeros.
 * <p>
 * Return a containing as many elements as indices, where the i-th element is equal to the indices[i]-th element of
 * the sequence S (index is 0-based). No element of the return should contain extra leading zeros.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AbsSequence {

    public String[] getElements(String first, String second, String[] indices) {

        BigInteger SiMinus2 = new BigInteger(first);
        BigInteger SiMinus1 = new BigInteger(second);

        return Arrays.stream(indices)
                .map(BigInteger::new)
                .map(index -> findValue(SiMinus2, SiMinus1, index))
                .map(BigInteger::toString)
                .collect(Collectors.toList()).toArray(new String[indices.length]);
    }

    private BigInteger findValue(BigInteger SiMinus2, BigInteger SiMinus1, BigInteger index) {
        BigInteger Si = SiMinus2.subtract(SiMinus1).abs();
        while (index.compareTo(ZERO) > 0) {
            if (SiMinus1.compareTo(ZERO) == 0 && SiMinus2.compareTo(ZERO) == 0) {
                return ZERO;
            }
            SiMinus2 = SiMinus1;
            SiMinus1 = Si;
            Si = SiMinus2.subtract(SiMinus1).abs();
            index = index.subtract(ONE);
        }
        return SiMinus2;
    }
}
