package com.github.peckb1.projecteuler.p031to040;

import java.util.HashSet;
import java.util.Set;

/**
 * The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.
 * <p>
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * <p>
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
public class Problem36 {

    public static void main(String[] args) {
        System.out.println(new Problem36().sumOfPalindromicNumbers(1_000_000));
    }

    public long sumOfPalindromicNumbers(int upperLimit) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < upperLimit; i++) {
            String base10String = String.valueOf(i);
            String base2String = Integer.toBinaryString(i);
            if (isPalindrome(base10String.toCharArray()) && isPalindrome(base2String.toCharArray())) {
                numbers.add(i);
            }
        }

        return numbers.stream().reduce(0, (x, y) -> x + y);
    }

    private boolean isPalindrome(char[] word) {
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }

}
