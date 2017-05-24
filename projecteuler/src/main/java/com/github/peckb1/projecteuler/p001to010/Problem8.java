package com.github.peckb1.projecteuler.p001to010;

import java.math.BigInteger;

public class Problem8 {

    private static final char ZERO = '0';

    public BigInteger largestProduct(String largeNumber, int maxDigits) {
        char[] chars = largeNumber.toCharArray();

        if (maxDigits >= chars.length) {
            return product(chars);
        }

        char[] data = new char[maxDigits];
        System.arraycopy(chars, 0, data, 0, data.length);

        BigInteger product = product(data);
        BigInteger max = product;
        for(int i = maxDigits; i < chars.length; i++) {
            data[i % maxDigits] = chars[i];
            product = product(data);
            max = max.max(product);
        }

        return max;
    }

    private static BigInteger product(char[] data) {
        BigInteger product = BigInteger.ONE;
        for(int i = 0; i < data.length && !product.equals(BigInteger.ZERO); i++) {
            product = product.multiply(BigInteger.valueOf(data[i] - ZERO));
        }
        return product;
    }

}
