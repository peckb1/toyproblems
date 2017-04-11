package com.github.peckb1.topcoder.practice.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Two phrases are anagrams if they are permutations of each other, ignoring spaces and capitalization. For example,
 * "Aaagmnrs" is an anagram of "anagrams", and "TopCoder" is an anagram of "Drop Cote". Given a phrases, remove each
 * phrase that is an anagram of an earlier phrase, and return the remaining phrases in their original order.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class Aaagmnrs {

    public String[] anagrams(String[] phrases) {
        Map<Data, Void> anagramMap = new HashMap<>();

        for (int i = 0; i < phrases.length; i++) {
            anagramMap.put(new Data(phrases[i], i), null);
        }

        return anagramMap.keySet().stream()
                .sorted(Comparator.comparing(o -> o.index))
                .map(d -> d.phrase)
                .collect(Collectors.toList())
                .toArray(new String[anagramMap.size()]);
    }

    private static class Data {
        private final String phrase;
        private final String sortedCharacters;
        private final Integer index;

        private Data(String phrase, Integer index) {
            this.phrase = phrase;
            this.index = index;
            char[] chars = phrase.toLowerCase().toCharArray();
            Arrays.sort(chars);
            sortedCharacters = new String(chars).trim();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            final Data data = (Data) o;

            return sortedCharacters != null ? sortedCharacters.equals(data.sortedCharacters) : data.sortedCharacters == null;
        }

        @Override
        public int hashCode() {
            return sortedCharacters != null ? sortedCharacters.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "phrase='" + phrase + '\'' +
                    ", sortedCharacters='" + sortedCharacters + '\'' +
                    ", index=" + index +
                    '}';
        }
    }
}
