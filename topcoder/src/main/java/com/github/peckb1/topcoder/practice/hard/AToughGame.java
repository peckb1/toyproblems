package com.github.peckb1.topcoder.practice.hard;

/**
 * Allen is playing a very difficult game. The game has N levels, numbered 0 through N-1 in the order in which
 * they have to be completed. Each level can be described by two parameters: prob[i] and value[i]. The meaning
 * of these parameters is as follows:
 * <p>
 * Whenever Allen plays level i, he either completes it or dies. The probability that he completes the level is
 * always prob[i]/1000. (He always tries his best to complete each level.)
 * At the end of level i there is a treasure chest that contains value[i] units of gold. When Allen completes the
 * level, he picks up the gold from the chest.
 * At the beginning of a new game Allen starts in level 0 with no gold. For each valid i, whenever Allen completes
 * level i, he moves on to play level i+1. The game ends as soon as he completes level N-1.
 * <p>
 * Whenever Allen dies, several things happen in order:
 * <p>
 * All the gold that is currently neither in a treasure chest nor carried by Allen is removed from the game.
 * All the gold Allen is currently carrying is dropped at the beginning of the level where he died. As soon as
 * Allen reaches this level again, he will be able to pick it all up again, even before attempting to complete
 * the level. (Note that if he dies again before collecting it, this gold will be lost forever.)
 * <p>
 * New gold is added to all chests to refill them to the amounts they originally contained.
 * <p>
 * Allen is returned to the beginning of level 0. He is carrying no gold.
 * <p>
 * Hence, after Allen's death there is always at most one pile of gold that is not in a treasure chest. That
 * pile is at the beginning of the level where Allen most recently died.
 * <p>
 * You are given the s prob and value with N elements each. In order to avoid precision errors, prob will always
 * be such that the probability that Allen wins the entire game without ever dying will be at least 10^(-6).
 * Compute and return the expected amount of gold Allen will carry when he wins the game.
 * <p>
 * This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction
 * of this information without the prior written consent of TopCoder, Inc. is strictly prohibited.
 * (c)2003, TopCoder, Inc. All rights reserved.
 */
public class AToughGame {

    public double expectedGain(int[] prob, int[] value) {
        int dungeonLevels = prob.length;

        // initialize some of our mutable data //
        double chanceToLive = 1; //---------------------- our rolling chance to get past this level for any run
        double averageAdditionalGold = 0.0; //----------- The average gold that would be attained once a level is reached
        double minimumGoldAfterLevelCompletion = 0.0; //- The minimum amount of gold you can have after you beat a level
        // initialize some of our mutable data //

        // for each level ...
        for (int i = 0; i < dungeonLevels; i++) {
            // what is our chance to be dead at the end of this level for any given run
            double chanceToDie = chanceToLive * (1000 - prob[i]) / 1000;

            // for the next level we need subtract that data from our current running chance to live
            chanceToLive -= chanceToDie;

            // find out the gold gain for this level based on the minimum amount of gold we would have at
            // this point and average additional gold - divided by our chance to survive (inverse chance to die)
            double goldGainForThisLevel = (minimumGoldAfterLevelCompletion + averageAdditionalGold) / (1 - chanceToDie);

            // increment our average gold gain by the gold gain for this level, offset by our chance to die
            averageAdditionalGold += goldGainForThisLevel * chanceToDie;

            // add our base value to the minimum gold possible
            minimumGoldAfterLevelCompletion += value[i];
        }

        // our rolling average had not actually added the minimum amount we would have
        // so we add it in, and then return the result
        return averageAdditionalGold + minimumGoldAfterLevelCompletion;
    }

}
