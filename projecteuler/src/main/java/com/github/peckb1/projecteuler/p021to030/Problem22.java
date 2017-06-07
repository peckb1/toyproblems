package com.github.peckb1.projecteuler.p021to030;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;

/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first
 * names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a name score.
 * <p>
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53,
 * is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 * <p>
 * What is the total of all the name scores in the file?
 */
public class Problem22 {

    public long totalScores(List<String> list) {
        Collections.sort(list);

        long total = 0;
        for(int i = 0; i < list.size(); i++) {
            int num = num(list.get(i));
            total += num * (i + 1);
        }

        return total;
    }

    private int num(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum += (s.charAt(i) - 'A') + 1; // i 'B' so that 'A' is 1
        }
        return sum;
    }

}
