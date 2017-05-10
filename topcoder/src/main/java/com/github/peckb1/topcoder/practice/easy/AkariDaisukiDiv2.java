package com.github.peckb1.topcoder.practice.easy;

/**
 * Consider the following function:
 * f(X) = Waai + X + Akari + X + Daisuki
 * Here, X is a string and + denotes string concatenation. Waai, Akari and Daisuki are constant non-empty strings.
 * <p>
 * <p>
 * You are given a S. Compute and return the number of different tuples (Waai,Akari,Daisuki,X) such that f(X) equals S.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AkariDaisukiDiv2 {

    public int countTuples(String S) {
        int stringLength = S.length();
        int count = 0;

        // how many tuples can exist such that
        // W + X + A + X + D == S
        // iterate through all possible substrings of S, and count the times when our X == X;

        for (int i = 1; i < stringLength; i++) {
            for (int j = i + 1; j < stringLength; j++) {
                for (int k = j + 1; k < stringLength; k++) {
                    for (int l = k + 1; l < stringLength; l++) {
                        // String s1 = S.substring(0, i);
                        String s2 = S.substring(i, j);
                        // String s3 = S.substring(j, k);
                        String s4 = S.substring(k, l);
                        // String s5 = S.substring(l);

                        if (s2.equals(s4)) {
                            count++;
                        }

                    }
                }
            }
        }

        return count;
    }

    /*
        For example:
        'foxciel' has 15 checks for the five columns - sadly column 2 is never equal to column 4
        f o x c iel
        f o x ci el
        f o x cie l
        f o xc i el
        f o xc ie l
        f o xci e l
        f ox c i el
        f ox c ie l
        f ox ci e l
        f oxc i e l
        fo x c i el
        fo x c ie l
        fo x ci e l
        fo xc i e l
        fox c i e l

        'magicalgirl' has 210 checks for the five columns - and matches four times
        m a g i calgirl
        m a g ic algirl
        m a g ica lgirl
        m a g ical girl
        m a g icalg irl
        m a g icalgi rl
        m a g icalgir l
        m a gi c algirl
        m a gi ca lgirl
        m a gi cal girl
        m a gi calg irl
        m a gi calgi rl
        m a gi calgir l
        m a gic a lgirl     MATCH #1 'a' === 'a'
        m a gic al girl
        m a gic alg irl
        m a gic algi rl
        m a gic algir l
        m a gica l girl
        m a gica lg irl
        m a gica lgi rl
        m a gica lgir l
        m a gical g irl
        m a gical gi rl
        m a gical gir l
        m a gicalg i rl
        m a gicalg ir l
        m a gicalgi r l
        m ag i c algirl
        m ag i ca lgirl
        m ag i cal girl
        m ag i calg irl
        m ag i calgi rl
        m ag i calgir l
        m ag ic a lgirl
        m ag ic al girl
        m ag ic alg irl
        m ag ic algi rl
        m ag ic algir l
        m ag ica l girl
        m ag ica lg irl
        m ag ica lgi rl
        m ag ica lgir l
        m ag ical g irl
        m ag ical gi rl
        m ag ical gir l
        m ag icalg i rl
        m ag icalg ir l
        m ag icalgi r l
        m agi c a lgirl
        m agi c al girl
        m agi c alg irl
        m agi c algi rl
        m agi c algir l
        m agi ca l girl
        m agi ca lg irl
        m agi ca lgi rl
        m agi ca lgir l
        m agi cal g irl
        m agi cal gi rl
        m agi cal gir l
        m agi calg i rl
        m agi calg ir l
        m agi calgi r l
        m agic a l girl
        m agic a lg irl
        m agic a lgi rl
        m agic a lgir l
        m agic al g irl
        m agic al gi rl
        m agic al gir l
        m agic alg i rl
        m agic alg ir l
        m agic algi r l
        m agica l g irl
        m agica l gi rl
        m agica l gir l
        m agica lg i rl
        m agica lg ir l
        m agica lgi r l
        m agical g i rl
        m agical g ir l
        m agical gi r l
        m agicalg i r l
        ma g i c algirl
        ma g i ca lgirl
        ma g i cal girl
        ma g i calg irl
        ma g i calgi rl
        ma g i calgir l
        ma g ic a lgirl
        ma g ic al girl
        ma g ic alg irl
        ma g ic algi rl
        ma g ic algir l
        ma g ica l girl
        ma g ica lg irl
        ma g ica lgi rl
        ma g ica lgir l
        ma g ical g irl     MATCH #2 'g' === 'g'
        ma g ical gi rl
        ma g ical gir l
        ma g icalg i rl
        ma g icalg ir l
        ma g icalgi r l
        ma gi c a lgirl
        ma gi c al girl
        ma gi c alg irl
        ma gi c algi rl
        ma gi c algir l
        ma gi ca l girl
        ma gi ca lg irl
        ma gi ca lgi rl
        ma gi ca lgir l
        ma gi cal g irl
        ma gi cal gi rl     MATCH #3 'gi' === 'gi'
        ma gi cal gir l
        ma gi calg i rl
        ma gi calg ir l
        ma gi calgi r l
        ma gic a l girl
        ma gic a lg irl
        ma gic a lgi rl
        ma gic a lgir l
        ma gic al g irl
        ma gic al gi rl
        ma gic al gir l
        ma gic alg i rl
        ma gic alg ir l
        ma gic algi r l
        ma gica l g irl
        ma gica l gi rl
        ma gica l gir l
        ma gica lg i rl
        ma gica lg ir l
        ma gica lgi r l
        ma gical g i rl
        ma gical g ir l
        ma gical gi r l
        ma gicalg i r l
        mag i c a lgirl
        mag i c al girl
        mag i c alg irl
        mag i c algi rl
        mag i c algir l
        mag i ca l girl
        mag i ca lg irl
        mag i ca lgi rl
        mag i ca lgir l
        mag i cal g irl
        mag i cal gi rl
        mag i cal gir l
        mag i calg i rl     MATCH #4 'i' === 'i'
        mag i calg ir l
        mag i calgi r l
        mag ic a l girl
        mag ic a lg irl
        mag ic a lgi rl
        mag ic a lgir l
        mag ic al g irl
        mag ic al gi rl
        mag ic al gir l
        mag ic alg i rl
        mag ic alg ir l
        mag ic algi r l
        mag ica l g irl
        mag ica l gi rl
        mag ica l gir l
        mag ica lg i rl
        mag ica lg ir l
        mag ica lgi r l
        mag ical g i rl
        mag ical g ir l
        mag ical gi r l
        mag icalg i r l
        magi c a l girl
        magi c a lg irl
        magi c a lgi rl
        magi c a lgir l
        magi c al g irl
        magi c al gi rl
        magi c al gir l
        magi c alg i rl
        magi c alg ir l
        magi c algi r l
        magi ca l g irl
        magi ca l gi rl
        magi ca l gir l
        magi ca lg i rl
        magi ca lg ir l
        magi ca lgi r l
        magi cal g i rl
        magi cal g ir l
        magi cal gi r l
        magi calg i r l
        magic a l g irl
        magic a l gi rl
        magic a l gir l
        magic a lg i rl
        magic a lg ir l
        magic a lgi r l
        magic al g i rl
        magic al g ir l
        magic al gi r l
        magic alg i r l
        magica l g i rl
        magica l g ir l
        magica l gi r l
        magica lg i r l
        magical g i r l
     */
}
