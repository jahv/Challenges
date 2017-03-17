package hackerrank.ns.contest.w2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hackerranck.ns.contest.w2.MazePathV2;

/**
 * Created by ahernandez on 2/23/17.
 */
public class MazePathV2Test {

    private char[][] maze;

    @Before
    public void setUp() {
        maze = new char[][]{
                {'.','.','.','.'},
                {'.','S','.','#'},
                {'T','.','.','.'}
        };
    }

    @Test
    public void isValidTest() {
        maze = new char[][]{
                {'V','.','.','.'},
                {'.','S','.','#'},
                {'T','.','.','.'}
        };

        MazePathV2.printMaze(maze);

        Assert.assertFalse(MazePathV2.isValid(0,0, maze));
        Assert.assertTrue(MazePathV2.isValid(0,1, maze));
        Assert.assertTrue(MazePathV2.isValid(0,2, maze));
        Assert.assertTrue(MazePathV2.isValid(0,3, maze));

        Assert.assertTrue(MazePathV2.isValid(1,0, maze));
        Assert.assertFalse(MazePathV2.isValid(1,1, maze));
        Assert.assertTrue(MazePathV2.isValid(1,2, maze));
        Assert.assertFalse(MazePathV2.isValid(1,3, maze));

        Assert.assertTrue(MazePathV2.isValid(2,0, maze));
        Assert.assertTrue(MazePathV2.isValid(2,1, maze));
        Assert.assertTrue(MazePathV2.isValid(2,2, maze));
        Assert.assertTrue(MazePathV2.isValid(2,3, maze));

        Assert.assertFalse(MazePathV2.isValid(-1,1, maze));
        Assert.assertFalse(MazePathV2.isValid(1,-1, maze));
        Assert.assertFalse(MazePathV2.isValid(-1,-1, maze));
    }

    @Test
    public void isTargetTest() {
        MazePathV2.printMaze(maze);
        List<Integer> indexI = new ArrayList<>();
        List<Integer> indexJ = new ArrayList<>();
        for(int i=0; i<maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if(MazePathV2.isTarget(i,j,maze)) {
                    indexI.add(i);
                    indexJ.add(j);
                }
            }
        }
        Assert.assertEquals(1, indexI.size());
        Assert.assertEquals(1, indexJ.size());
        Assert.assertEquals(new Integer(2), indexI.get(0));
        Assert.assertEquals(new Integer(0), indexJ.get(0));
    }

    @Test
    public void visitTest() {
        MazePathV2.printMaze(maze);
        for(int i=0; i<maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if(MazePathV2.isValid(i, j, maze) && !MazePathV2.isTarget(i, j, maze)) {
                    MazePathV2.visit(i, j, maze);
                }
            }
        }
        MazePathV2.printMaze(maze);
    }

    @Test
    public void findPathTest() {
        MazePathV2.printMaze(maze);

        List<Integer> r = new ArrayList<>();
        int i = 1;
        int j = 1;
        int c = 0;

        MazePathV2.findPath(i+1, j, maze, c, r);
        MazePathV2.findPath(i-1, j, maze, c, r);
        MazePathV2.findPath(i, j+1, maze, c, r);
        MazePathV2.findPath(i, j-1, maze, c, r);

        MazePathV2.printMaze(maze);
    }

}
