package codefigths.daily;

import org.junit.Assert;
import org.junit.Test;

public class DailyChallengesTest {

    @Test
    public void pokerChips2Test() {
        Assert.assertEquals(3, DailyChallenges.pokerChips2(new int[]{4,5,6,10,5}));
        Assert.assertEquals(1, DailyChallenges.pokerChips2(new int[]{1,2,3}));
        Assert.assertEquals(1, DailyChallenges.pokerChips2(new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 2}));
        Assert.assertEquals(4, DailyChallenges.pokerChips2(new int[]{6,2,4,10,3}));
        Assert.assertEquals(3, DailyChallenges.pokerChips2(new int[]{8, 10, 2, 5, 5}));
        Assert.assertEquals(4, DailyChallenges.pokerChips2(new int[]{0, 3, 10, 6, 1}));
        Assert.assertEquals(7, DailyChallenges.pokerChips2(new int[]{2, 7, 4, 2, 4, 10, 5, 7, 2, 7}));
        Assert.assertEquals(8, DailyChallenges.pokerChips2(new int[]{0, 10, 0, 8, 3, 10, 7, 0, 9, 3}));
        Assert.assertEquals(8, DailyChallenges.pokerChips2(new int[]{13, 8, 28, 21, 30, 6, 13, 27, 23, 1}));
        Assert.assertEquals(13, DailyChallenges.pokerChips2(new int[]{6, 14, 22, 12, 6, 25, 15, 14, 29, 21, 11, 14, 25, 13, 13}));
        Assert.assertEquals(47, DailyChallenges.pokerChips2(new int[]{18, 22, 30, 21, 2, 20, 22, 8, 30, 30, 7, 23, 1, 22, 8, 23, 7, 22, 25, 26, 17, 30, 27, 6, 25, 29, 20, 9, 3, 25, 16, 16, 30, 30, 8, 15, 27, 25, 6, 22, 16, 10, 24, 14, 26, 0, 13, 28, 11, 5}));
    }


    @Test
    public void leastAppearanceTest() {
        int[] result = DailyChallenges.leastAppearance(new int[][]
                {
                        {1,2},
                        {3,4},
                        {1,2}
                });
        assertEntries(new int[]{1, 3, 2}, result);

        result = DailyChallenges.leastAppearance(new int[][]
                {
                        {1,2},
                        {3,4}
                });
        assertEntries(new int[]{1, 3}, result);

        result = DailyChallenges.leastAppearance(new int[][]
                {
                        {1,2},
                        {3,4},
                        {1,2},
                        {3,4}
                });
        assertEntries(new int[]{1, 3, 2, 4}, result);

        result = DailyChallenges.leastAppearance(new int[][]
                {
                        {4,8},
                        {92,92},
                        {9,53},
                        {44,48},
                        {2,67},
                        {3,3},
                        {60,93},
                        {18,37},
                        {7,15},
                        {2,4}
                });
        assertEntries(new int[]{4, 92, 9, 44, 2, 3, 60, 18, 7, 2}, result);

        result = DailyChallenges.leastAppearance(new int[][]
                {
                        {27,59},
                        {48,83},
                        {21,23},
                        {18,27},
                        {64,68},
                        {9,38},
                        {8,60},
                        {57,78},
                        {4,25},
                        {5,6},
                        {22,52},
                        {79,84},
                        {5,39},
                        {2,80},
                        {3,23}
                });
        assertEntries(new int[]{27, 48, 21, 18, 64, 9, 8, 57, 4, 5, 22, 79, 39, 2, 3}, result);

    }

    private void assertEntries(int[] expected, int[] actual) {
        Assert.assertEquals(expected.length, actual.length);
        for(int i=0; i<expected.length; i++) {
            Assert.assertEquals(expected[i], actual[i]);
        }
    }
}
