package com.github.peckb1.topcoder.practice.easy;

import java.math.BigInteger;

/**
 * Hero is playing a game with tokens.There are N places for tokens.The places are numbered 1through N.There are
 * also N arrows,each pointing from some place to some place.No two arrows start at the same place.It is possible
 * that multiple arrows point to the same place.Also,an arrow may start and end at the same place.
 * <p>
 * You are given the description of the game board:a a with N elements.For each i between 1and N,inclusive,the arrow
 * that starts at the place i points to the place a[i-1].
 * <p>
 * At the beginning of the game,Hero will take an arbitrary number of tokens between 0and N,inclusive,and he will
 * place them onto distinct places.He will then play K rounds of the game.In each round each token moves from its
 * current place along the arrow to the new place.After each round,Hero checks whether all tokens are still in
 * distinct places.If two or more tokens are in the same place,Hero loses the game.Hero wins the game if he does
 * not lose it during the K rounds he plays.
 * <p>
 * There may be multiple ways how Hero can win the game.Two ways are different if there is some i such that at the
 * beginning of the game place i did contain a token in one case but not in the other.Count those ways and return
 * their count modulo 1,000,000,007.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class Autogame {

    private static final BigInteger MOD = BigInteger.valueOf(1_000_000_007);

    /*
        An example
        4, 4, 3, 2, 1

        1->4
        2->4
        3->3
        4->2
        5->1

        tokens = 5

        tokenCounterAfterK[ 0, 0, 0, 0, 0 ]
        1 -> 4 -> 2 -> 4 -> 2
        tokenCounterAfterK[ 0, 1, 0, 0, 0 ]
        2 -> 4 -> 2 -> 4 -> 2
        tokenCounterAfterK[ 0, 2, 0, 0, 0 ]
        3 -> 3 -> 3 -> 3 -> 3
        tokenCounterAfterK[ 0, 2, 1, 0, 0 ]
        4 -> 2 -> 4 -> 2 -> 4
        tokenCounterAfterK[ 0, 2, 1, 1, 0 ]
        5 -> 1 -> 4 -> 2 -> 4
        tokenCounterAfterK[ 0, 2, 1, 2, 0 ]

        (0 + 1) * (2 + 1) * (1 + 1) * (2 + 1) * (0 + 1)

         1 * 3 * 2 * 3 * 1
             3 * 2 * 3 * 1
                 6 * 3 * 1
                    18 * 1
                        18

        18 % 1_000_000_007 == 18
     */


    public int wayscnt(int[] a, int K) {
        // how many tokens do we have?
        int tokens = a.length;

        // setup our rolling counter array for the token placements
        int[] tokenCountAfterK = new int[tokens];

        // iterate through the number of tokens we can place
        for (int i = 0; i < tokens; i++) {

            // where is the token starting ?
            int tokenLocation = i + 1;

            // for each iteration...
            for (int j = 0; j < K; j++) {
                // find out where the token ended up
                tokenLocation = a[tokenLocation - 1];
            }

            // after our K iterations, increment the counter for how many tokens are on a given location
            tokenCountAfterK[tokenLocation - 1]++;
        }

        BigInteger numberOfChoices = BigInteger.ONE; // there is always a single choice - for when no tokens are played
        for (int tokensAfterKOnSpot : tokenCountAfterK) {
            // multiply our current choice by the number of tokens on a given spot at the end
            // but add one to handle that if anything was 0, it would reset any calculations
            // and there is always one to add for when a single token exists
            numberOfChoices = numberOfChoices.multiply(BigInteger.valueOf(tokensAfterKOnSpot + 1));
        }

        // at the end of all those multiplications, don't forget to mod by our answer so we can
        // still return an actual int value
        numberOfChoices = numberOfChoices.mod(MOD);

        // and then return the primitive value to match our contract
        return numberOfChoices.intValue();
    }

}
