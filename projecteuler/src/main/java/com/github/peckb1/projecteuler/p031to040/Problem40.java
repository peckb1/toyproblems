package com.github.peckb1.projecteuler.p031to040;

/**
 * An irrational decimal fraction is created by concatenating the positive integers:
 * <p>
 * 0.123456789101112131415161718192021...
 * <p>
 * It can be seen that the 12th digit of the fractional part is 1.
 * <p>
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 * <p>
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
public class Problem40 {

    public static void main(String[] args) {
        System.out.println(new Problem40().productOfDigits());
    }

    public int productOfDigits() {
        String base = "0.";
        StringBuilder sb = new StringBuilder(base);
        int i = 1;
        while(sb.length() < (1_000_000 + base.length())) {
            sb.append(i);
            i++;
        }
        //noinspection PointlessArithmeticExpression
        char c1 = sb.charAt(1 + base.length() - 1);
        char c2 = sb.charAt(10 + base.length() - 1);
        char c3 = sb.charAt(100 + base.length() - 1);
        char c4 = sb.charAt(1_000 + base.length() - 1);
        char c5 = sb.charAt(10_000 + base.length() - 1);
        char c6 = sb.charAt(100_000 + base.length() - 1);
        char c7 = sb.charAt(1_000_000 + base.length() - 1);

        int i1 = Integer.parseInt(String.valueOf(c1));
        int i2 = Integer.parseInt(String.valueOf(c2));
        int i3 = Integer.parseInt(String.valueOf(c3));
        int i4 = Integer.parseInt(String.valueOf(c4));
        int i5 = Integer.parseInt(String.valueOf(c5));
        int i6 = Integer.parseInt(String.valueOf(c6));
        int i7 = Integer.parseInt(String.valueOf(c7));

        return i1 * i2 * i3 * i4 * i5 * i6 * i7;
    }

}
