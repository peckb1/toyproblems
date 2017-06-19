package com.github.peckb1.projecteuler.p031to040;

import java.math.BigInteger;

/**
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may
 * incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 * <p>
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * <p>
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing
 * two digits in the numerator and denominator.
 * <p>
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class Problem33 {

    public static void main(String[] args) {
        System.out.println(new Problem33().digitCancelingFractions());
    }

    public int digitCancelingFractions() {
        int numeratorProduct = 1;
        int denominatorProduct = 1;

        for (int i = 1; i < 10; i++) {
            for (int denominator = 1; denominator < i; denominator++) {
                for (int numerator = 1; numerator < denominator; numerator++) {
                    if ((numerator * 10 + i) * denominator == numerator * (i * 10 + denominator)) {
                        denominatorProduct *= denominator;
                        numeratorProduct *= numerator;
                    }
                }
            }
        }

        return BigInteger.valueOf(denominatorProduct)
                         .divide(BigInteger.valueOf(numeratorProduct)
                                           .gcd(BigInteger.valueOf(denominatorProduct)))
                         .intValue();
    }

}
