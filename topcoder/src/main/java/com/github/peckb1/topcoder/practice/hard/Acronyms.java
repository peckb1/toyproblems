package com.github.peckb1.topcoder.practice.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/**
 * Acronyms are commonly used to make documents more concise. Your task in this problem is to develop a program that
 * automates the conversion of sequences of words into acronyms in a , document. A sequence of words must meet all of
 * the following criteria before it can be converted to an acronym:
 * <p>
 * The words in the sequence must all be within one sentence.
 * <p>
 * The sequence must not include the first word in a sentence.
 * <p>
 * At least two words in the sequence must begin with uppercase letters.
 * <p>
 * The first and last words in the sequence must begin with uppercase letters.
 * <p>
 * There may not be two adjacent words that do not begin with uppercase letters in the sequence.
 * <p>
 * The sequence must be as long as possible. It may not be a subsequence of any longer sequence meeting the five criteria above.
 * <p>
 * A word is defined as a sequence of characters surrounded on both sides by spaces or edges of the element of document.
 * Note that a word may include non-letter characters. A new sentence, in this problem, always starts at the beginning
 * of the input and after two consecutive spaces, where a new line (new element of document) counts as one space.
 * <p>
 * For each sequence of words meeting the criteria as defined above, you should convert it to an acronym by replacing
 * the whole sequence of words with all the uppercase letters in the words that start with uppercase letters (in order).
 * The only caveat to this is that if there are non-letter characters at the end of the last word in the sequence,
 * you should not replace them.
 * <p>
 * For example, "TopCoder, Inc." would become "TCI.". Note that the '.' at the end of "Inc." remains in the acronym but
 * the ',' at the end of "TopCoder," is removed. Also, "United States of America" would be converted to "USA"; there is
 * no 'o' because "of" does not start with an uppercase letter.
 * <p>
 * After inserting the acronyms, you should return a representing the entire document. A new line in the input always
 * counts as one space, and this should be represented in the output.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class Acronyms {

    private final Pattern UPPER_CASE = Pattern.compile("\\p{Upper}");
    private final Predicate<String> PUNCTUATION_PREDICATE = Pattern.compile("\\p{Punct}").asPredicate();
    private final Predicate<String> UPPER_CASE_PREDICATE = UPPER_CASE.asPredicate();

    public String acronize(String[] document) {
        // create a single sentence
        StringBuilder sb = new StringBuilder();
        for(String part: document) {
            sb.append(part).append(" ");
        }
        String sentence = sb.toString();

        // split the sentence on '  '
        String[] statements = sentence.split("  ");

        StringBuilder resultingDocument = new StringBuilder();

        // go through each sequence resulting from the split
        for(String statement : statements) {

            // look for a capital letter starting at not the first word
            String[] words = statement.split(" ");
            resultingDocument.append(words[0]).append(" ");

            for(int w = 1; w < words.length; w++) {
                String word = words[w];

                // start tracking a possible acronym
                if (UPPER_CASE_PREDICATE.test(word.substring(0, 1))) {

                    List<String> acronymWords = new ArrayList<>();
                    acronymWords.add(word);

                    // one lower case word allowed between upper case
                    // symbols are considered lower case words
                    List<String> lowerCaseWords = new ArrayList<>();

                    boolean lowerCaseFound = false;
                    for(int aw = w + 1; aw < words.length; aw++) {
                        String nextWord = words[aw];
                        w++;
                        if (UPPER_CASE_PREDICATE.test(nextWord.substring(0, 1))) {
                            lowerCaseFound = false;
                            lowerCaseWords.clear();
                            acronymWords.add(nextWord);
                        } else {
                            if (lowerCaseFound) {
                                lowerCaseWords.add(nextWord);
                                aw = words.length;
                            } else {
                                lowerCaseFound = true;
                                lowerCaseWords.add(nextWord);
                            }
                        }
                    }

                    if (acronymWords.size() > 1) {

                        // All upper case letters of words included in the acronym words are included
                        String acronymLetters = acronymWords.stream()
                                .map(wordToStrip -> wordToStrip.replaceAll("[^A-Z]", ""))
                                .reduce("", (x, y) -> x + y);
                        resultingDocument.append(acronymLetters);
                        String lastWord = acronymWords.get(acronymWords.size() - 1);
                        int lastWordLength = lastWord.length();

                        // punctuation removed from all but the last word in the acronym
                        if (PUNCTUATION_PREDICATE.test(lastWord.substring(lastWordLength - 1, lastWordLength))) {
                            resultingDocument.append(lastWord.charAt(lastWordLength - 1));
                        }

                        resultingDocument.append(" ");

                        lowerCaseWords.forEach(x -> resultingDocument.append(x).append(" "));

                    } else {
                        acronymWords.forEach(x -> resultingDocument.append(x).append(" "));
                        lowerCaseWords.forEach(x -> resultingDocument.append(x).append(" "));
                    }

                } else {
                    resultingDocument.append(word).append(" ");
                }
            }
        }

        return resultingDocument.toString().trim();
    }

}
