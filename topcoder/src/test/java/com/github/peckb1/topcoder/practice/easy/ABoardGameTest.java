package com.github.peckb1.topcoder.practice.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ABoardGameTest {

    private ABoardGame aBoardGame;

    @Before
    public void setUp() throws Exception {
        this.aBoardGame = new ABoardGame();
    }

    @Test
    public void testTopcoderExamples() throws Exception {
        Assert.assertEquals(ABoardGame.ALICE, this.aBoardGame.whoWins(new String[]{".....A", "......", "..A...", "...B..", "......", "......"}));
        Assert.assertEquals(ABoardGame.BOB, this.aBoardGame.whoWins(new String[]{"AAAA", "A.BA", "A..A", "AAAA"}));
        Assert.assertEquals(ABoardGame.DRAW, this.aBoardGame.whoWins(new String[]{"..", ".."}));
        Assert.assertEquals(ABoardGame.ALICE, this.aBoardGame.whoWins(new String[]{"BBB..BAB...B.B", ".AAAAAAAAAAAA.", "AA.AA.AB..A.AB", "..........B.AB", ".A..BBAB.A.BAB", ".AB.B.......A.", ".A..A.AB.A..AB", ".ABAA.BA...BA.", "BAAAB.....ABA.", ".A....B..A..B.", "B...B....B..A.", "BA.B..A.ABA.A.", "BAAAA.AAAAA.A.", "B.B.B.BB.B...."}));
        Assert.assertEquals(ABoardGame.BOB, this.aBoardGame.whoWins(new String[]{"..A..AAA..AA", "ABABB..AAAAA", "ABBBBBBBBBA.", "AABBBABABBAA", "...BABABABBA", "B.BA..A.BBA.", "AA.A..B.AB.B", "..BA.B.AABAA", "..ABABBBABA.", ".ABB.BBBBBAA", "ABAAA.AA.A.A", "A..AAA.AAA.A"}));
        Assert.assertEquals(ABoardGame.DRAW, this.aBoardGame.whoWins(new String[]{"B..ABAABBB", "B.........", "A..A.AA..B", "A.BBBAA..A", "B.AAAAB...", "A..BBBBB.A", "B..ABAABBA", "A......B.B", "B......A.A", "BA.AABBB.A"}));
    }
}
