package codefight.arcade;

import org.junit.Assert;
import org.junit.Test;

public class $5_IslandOfKnowledgeTest {

    @Test
    public void areEquallyStrongTest() {
        Assert.assertTrue($5_IslandOfKnowledge.areEquallyStrong(10, 15, 15, 10));
        Assert.assertTrue($5_IslandOfKnowledge.areEquallyStrong(15, 10, 15, 10));
        Assert.assertFalse($5_IslandOfKnowledge.areEquallyStrong(15, 10, 15, 9));
        Assert.assertTrue($5_IslandOfKnowledge.areEquallyStrong(10, 5, 5, 10));
        Assert.assertFalse($5_IslandOfKnowledge.areEquallyStrong(10, 15, 5, 20));
    }

    @Test
    public void isIPv4AddressTest() {
        Assert.assertTrue($5_IslandOfKnowledge.isIPv4Address("172.016.254.1"));
    }

    @Test
    public void avoidObstaclesTest() {
        Assert.assertEquals(3, $5_IslandOfKnowledge.avoidObstacles(new int[]{19, 32, 11, 23}));
    }

    @Test
    public void boxBlurTest() {

        Assert.assertTrue(matrixesEqual(new int[][]{{1}},$5_IslandOfKnowledge.boxBlur(new int[][]{{1,1,1},{1,7,1},{1,1,1}})));

        Assert.assertTrue(matrixesEqual(new int[][]{{28}},$5_IslandOfKnowledge.boxBlur(new int[][]{{0,18,9}, {27,9,0}, {81,63,45}})));

        Assert.assertTrue(matrixesEqual(new int[][]{{40, 30}},$5_IslandOfKnowledge.boxBlur(new int[][]{{36,0,18,9}, {27,54,9,0}, {81,63,72,45}})));

        Assert.assertTrue(matrixesEqual(new int[][]{{39,30,26,25,31},
                {34,37,35,32,32},
                {38,41,44,46,42},
                {22,24,31,39,45},
                {37,34,36,47,59}},$5_IslandOfKnowledge.boxBlur(new int[][]{{36,0,18,9,9,45,27},
                {27,0,54,9,0,63,90},
                {81,63,72,45,18,27,0},
                {0,0,9,81,27,18,45},
                {45,45,27,27,90,81,72},
                {45,18,9,0,9,18,45},
                {27,81,36,63,63,72,81}})));
    }

    @Test
    public void minesweeperTest() {
        Assert.assertTrue(matrixesEqual(new int[][]{{1, 2, 1}, {2, 1, 1}, {1, 1, 1}},
                $5_IslandOfKnowledge.minesweeper(new boolean[][]{{true, false, false}, {false, true, false}, {false, false, false}})));

        Assert.assertTrue(matrixesEqual(new int[][]{{1, 2},
                        {2, 3},
                        {2, 1},
                        {1, 1},
                        {0, 0}},
                $5_IslandOfKnowledge.minesweeper(new boolean[][]{{true, false},
                        {true, false},
                        {false, true},
                        {false, false},
                        {false, false}})));

        Assert.assertTrue(matrixesEqual(new int[][]{{3, 3, 3, 2},
                        {2, 4, 5, 2},
                        {2, 3, 2, 2}},
                $5_IslandOfKnowledge.minesweeper(new boolean[][]{{false, true, true, false},
                        {true, true, false, true},
                        {false, false, true, false}})));
    }

    private boolean matrixesEqual(int[][]a, int[][]b){
        if(a.length == b.length & a[0].length == b[0].length) {
            for(int i=0; i<a.length; i++) {
                for (int j=0; j<a[i].length; j++) {
                    if(a[i][j] != b[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
