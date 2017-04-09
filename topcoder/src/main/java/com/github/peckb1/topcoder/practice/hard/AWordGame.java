package com.github.peckb1.topcoder.practice.hard;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Consider the following game played between two players (let's call them Joe and Mary): Joe starts the game by
 * thinking of some English word. He doesn't tell Mary what word, but instead tells Mary the first letter in his word.
 * Now it's Mary's turn, who must think of a word that starts with the letter Joe has revealed. She then tells Joe the
 * first two letters of her word. Now Joe must think of some word again (which may or may not be the same as Joe's
 * original word), starting with the two letters of Mary's word, and tell Mary the first three letters in his word.
 * <p>
 * This procedure is repeated until the letters that are spoken by either Joe or Mary form a complete word. The player
 * who first forms a complete word loses the game. This means that even if Joe thinks of the word "fire" and tells Mary
 * the first three letters, "fir", he loses because "fir" is also a valid English word.
 * <p>
 * In reality, the player with the biggest word knowledge will most often win this game, but in this problem we will
 * assume that both players know exactly the same words (and that none of them bluff or cheat). If both players play
 * perfectly, it's possible to determine the outcome of the game. We define "perfect play" to be when a player strives
 * to win the game in as few turns as possible (knowing that his opponent also plays perfectly), but also, if he/she
 * can't win the game, to lose as slowly as possible. See examples 0 and 1 for clarification.
 * <p>
 * The outcome of the game is the final word said by the player who loses. Note that if the length of this word is odd,
 * it means the second player will win since the first player will always say sequences with an odd number of letters,
 * and vice versa. If at any point it doesn't matter which letter a player chooses, he/she will choose the one that is
 * alphabetically first (see example 2).
 * <p>
 * Create a class AWordGame containing the method outcome that takes a wordList containing the words that both players
 * know, and returns a , the final word said by the player that loses the game. Each element in wordList will contain a
 * space separated list of words.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AWordGame {

    public String outcome(String[] wordList) {
        // sort the input list as a single list of Strings
        SortedSet<String> words = new TreeSet<>();
        for (String word : wordList) {
            String[] subWords = word.split(" ");
            Collections.addAll(words, subWords);
        }

        // setup our decision tree
        Choice baseChoice = new Choice(new TreeSet<>(new ChoiceComparator()), "", 0);
        for (String word : words) {
            baseChoice.addWord(word, 0);
        }

        // ask the top level tree who wins the game
        return baseChoice.whoWins().word;
    }

    private enum Player {
        P1, P2
    }

    private static class Choice {
        private final SortedSet<Choice> choices;

        private Player player;
        private String myCharacters;
        private int letterCount;

        private Choice(SortedSet<Choice> choices, String myCharacters, int parentLetterCount) {
            this.choices = new TreeSet<>(new ChoiceComparator());
            this.choices.addAll(choices);
            this.myCharacters = myCharacters;
            this.letterCount = parentLetterCount + myCharacters.length();
            this.player = letterCount % 2 == 0 ? Player.P1 : Player.P2;
        }

        @Override
        public String toString() {
            return toString(1);
        }

        private String toString(int depth) {
            String closeTabs = "";
            for (int i = 0; i < depth - 1; i++) {
                closeTabs += "\t";
            }
            String tabs = closeTabs + "\t";

            String choicesString = "";
            if (!choices.isEmpty()) {
                choicesString += ", [\n";
                for (Choice choice : choices) {
                    choicesString += tabs + choice.toString(depth + 1) + "\n";
                }
                choicesString += closeTabs + "]}";
            }

            return String.format("{'%s', '%s', '%s'%s", myCharacters.toUpperCase(), letterCount, player, choicesString);
        }

        private boolean addWord(String newWord, int parentLetters) {
            String commonPrefix = commonPrefix(this.myCharacters, newWord);
            boolean someoneSplit = false;
            if (commonPrefix.isEmpty()) {
                // I'm not going to split, let's ask my kids ... if I have them
                if (this.myCharacters.isEmpty()) {
                    someoneSplit = choices.stream()
                            .map(choice -> choice.addWord(newWord, this.myCharacters.length() + parentLetters))
                            .reduce(false, (x, y) -> x || y);
                }
            } else {
                // I have a common prefix with the string; is it my entire length?
                int prefixLength = commonPrefix.length();
                if (prefixLength == this.myCharacters.length()) {
                    if (!choices.isEmpty()) {
                        someoneSplit = choices.stream()
                                .map(choice -> choice.addWord(newWord.substring(prefixLength), prefixLength + parentLetters))
                                .reduce(false, (x, y) -> x || y);
                        if (!someoneSplit) {
                            // none of my kids wanted the word, I guess it's another child for me
                            this.choices.add(new Choice(new TreeSet<>(new ChoiceComparator()), newWord.substring(commonPrefix.length()), this.letterCount));
                            someoneSplit = true;
                        }
                    } else {
                        someoneSplit = true;
                        // we have a full word ending with our prefix - the word can be thrown away
                        // as it will never be reached
                    }
                } else {
                    // my entire length did not match - this is meant for me
                    String originalSplit = this.myCharacters.substring(prefixLength);
                    String newSplit = newWord.substring(prefixLength);

                    // create the new choices
                    int newParrentLetterCount = parentLetters + prefixLength;
                    Choice originalBreakOff = new Choice(choices, originalSplit, newParrentLetterCount);
                    Choice newBreakOff = new Choice(new TreeSet<>(new ChoiceComparator()), newSplit, newParrentLetterCount);

                    // swap the choice list
                    this.choices.clear();
                    this.choices.add(originalBreakOff);
                    this.choices.add(newBreakOff);
                    this.myCharacters = commonPrefix;
                    this.letterCount = parentLetters + prefixLength;
                    this.player = letterCount % 2 == 0 ? Player.P1 : Player.P2;
                    someoneSplit = true;
                }
            }

            if (!someoneSplit && this.myCharacters.isEmpty()) {
                this.choices.add(new Choice(new TreeSet<>(new ChoiceComparator()), newWord, 0));
                someoneSplit = true;
            }
            return someoneSplit;
        }

        private Winner whoWins() {
            if (choices.isEmpty()) {
                return new Winner(player, this.myCharacters);
            } else {
                Map<Player, List<Winner>> options = choices.stream()
                        .map(Choice::whoWins)
                        .collect(Collectors.groupingBy(o -> o.player));

                List<Winner> myWinningChoices = options.get(player);
                if (myWinningChoices != null) {
                    // can I win?
                    myWinningChoices.sort(new MyWinnerComparator());
                    Winner shortestWinner = myWinningChoices.get(0);
                    return new Winner(player, this.myCharacters + shortestWinner.word);
                } else {
                    // if I didn't win, then I lost (at least at this level)
                    Player otherPlayer = this.player == Player.P1 ? Player.P2 : Player.P1;
                    List<Winner> enemyChoices = options.get(otherPlayer);
                    enemyChoices.sort(new MyEnemyComparator());
                    Winner longestLoser = enemyChoices.get(0);
                    return new Winner(otherPlayer, this.myCharacters + longestLoser.word);
                }
            }
        }
    }

    private static class Winner {
        private final Player player;
        private final String word;

        private Winner(Player player, String word) {
            this.player = player;
            this.word = word;
        }
    }

    private static class ChoiceComparator implements Comparator<Choice> {
        @Override
        public int compare(Choice choice1, Choice choice2) {
            return choice1.myCharacters.compareTo(choice2.myCharacters);
        }
    }


    private static class MyWinnerComparator implements Comparator<Winner> {
        @Override
        public int compare(Winner o1, Winner o2) {
            int wordLengthComparator = Integer.valueOf(o1.word.length()).compareTo(Integer.valueOf(o2.word.length()));
            if (wordLengthComparator == 0) {
                return o1.word.compareTo(o2.word);
            } else {
                return wordLengthComparator;
            }
        }
    }

    private static class MyEnemyComparator implements Comparator<Winner> {
        @Override
        public int compare(Winner o1, Winner o2) {
            int wordLengthComparator = Integer.valueOf(o2.word.length()).compareTo(Integer.valueOf(o1.word.length()));
            if (wordLengthComparator == 0) {
                return o1.word.compareTo(o2.word);
            } else {
                return wordLengthComparator;
            }
        }
    }

    /**
     * "Borrowed" from com.google.common.base.Strings since topcode can't use it
     */
    private static String commonPrefix(CharSequence a, CharSequence b) {
        int maxPrefixLength = Math.min(a.length(), b.length());

        int p;
        for(p = 0; p < maxPrefixLength && a.charAt(p) == b.charAt(p); ++p) {
            ;
        }

        if(validSurrogatePairAt(a, p - 1) || validSurrogatePairAt(b, p - 1)) {
            --p;
        }

        return a.subSequence(0, p).toString();
    }

    private static boolean validSurrogatePairAt(CharSequence string, int index) {
        return index >= 0 && index <= string.length() - 2 && Character.isHighSurrogate(string.charAt(index)) && Character.isLowSurrogate(string.charAt(index + 1));
    }
}
