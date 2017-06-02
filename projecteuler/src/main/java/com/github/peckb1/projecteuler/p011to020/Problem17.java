package com.github.peckb1.projecteuler.p011to020;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are
 * 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <p>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * <p>
 * <p>
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two)
 * contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and"
 * when writing out numbers is in compliance with British usage.
 */
public class Problem17 {

    public int letterCounts(int upperInclusive) {
        if ( !(0 <= upperInclusive) || !(upperInclusive <= 1_000_000)) {
            return -1;
        }

        String[] firstTwenty = new String[]{
                "", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE",
                "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN", "TWENTY"
        };
        String[] tens = new String[]{
            "", "TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"
        };
        String hundred = "HUNDRED";
        String thousand = "THOUSAND";
        String and = "AND";

        int letterCount = 0;
        for(int i = 1; i <= Math.min(upperInclusive, 20); i++) {
            int numberWordCount = firstTwenty[i].length();
            letterCount += numberWordCount;
        }

        for(int i = 21; i <= Math.min(upperInclusive, 99); i++) {
            int T = i / 10;
            int O = i % 10;

            int numberWordCount = tens[T].length() + firstTwenty[O].length();
            letterCount += numberWordCount;
        }

        for(int i = 100; i <= Math.min(upperInclusive, 999); i++) {
            int H = i / 100;
            int T = (i % 100) / 10;
            int O = i % 10;

            int numberWordCount = 0;
            numberWordCount += firstTwenty[H].length() + hundred.length();
            if (T != 0 || O != 0) {
                numberWordCount += and.length();
            }
            if (T == 1) {
                numberWordCount += firstTwenty[T*10 + O].length();
            } else {
                numberWordCount += tens[T].length();
                numberWordCount += firstTwenty[O].length();
            }

            letterCount += numberWordCount;
        }

        for(int i = 1000; i <= Math.min(upperInclusive, 9999); i++) {
            int Th = i / 1000;
            int H = i / 1000 / 100;
            int T = (i % 100) / 10;
            int O = i % 10;

            int numberWordCount = 0;

            numberWordCount += firstTwenty[Th].length() + thousand.length();
            if (H != 0) {
                numberWordCount += firstTwenty[H].length() + hundred.length();
            }
            if (T != 0 || O != 0) {
                numberWordCount += and.length();
            }
            if (T == 1) {
                numberWordCount += firstTwenty[T*10 + O].length();
            } else {
                numberWordCount += tens[T].length();
                numberWordCount += firstTwenty[O].length();
            }

            letterCount += numberWordCount;
        }

        return letterCount;
    }

}
