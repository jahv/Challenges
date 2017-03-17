package hackerrank.ns.contest.w2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hackerranck.ns.contest.w2.MazePath;

/**
 * Created by ahernandez on 2/22/17.
 */
public class MazePathTest {

    private char[][] maze;

    @Before
    public void setUp() {
        maze = new char[0][0];
    }

    @After
    public void tearDown() {
        MazePath.printMaze(maze);
    }

    @Test
    public void isAllowToMoveTest() {
        Assert.assertTrue(MazePath.isAllowToMove('.'));

        Assert.assertFalse(MazePath.isAllowToMove('T'));
        Assert.assertFalse(MazePath.isAllowToMove('#'));
        Assert.assertFalse(MazePath.isAllowToMove('X'));
        Assert.assertFalse(MazePath.isAllowToMove('S'));
    }

    @Test
    public void moveUpTest() {
        maze = new char[][]{
            {'.','.','.','.'},
            {'.','S','.','#'},
            {'T','.','.','.'}
        };

        MazePath.startI = 1;
        MazePath.startJ = 1;

        Assert.assertTrue(MazePath.moveUp(maze));
        Assert.assertEquals(0, MazePath.startI);

        Assert.assertFalse(MazePath.moveUp(maze));
        Assert.assertFalse(MazePath.moveUp(maze));
        Assert.assertFalse(MazePath.moveUp(maze));
        Assert.assertEquals(0, MazePath.startI);
    }

    @Test
    public void moveUpTargetFoundTest() {
        maze = new char[][]{
                {'.','T','.','.'},
                {'.','.','.','#'},
                {'.','S','.','.'}
        };

        MazePath.startI = 2;
        MazePath.startJ = 1;

        Assert.assertTrue(MazePath.moveUp(maze));
        Assert.assertFalse(MazePath.moveUp(maze));
    }

    @Test
    public void moveDownTest() {
        maze = new char[][]{
                {'.','.','.','.'},
                {'.','S','.','#'},
                {'T','.','.','.'}
        };

        MazePath.startI = 1;
        MazePath.startJ = 1;

        Assert.assertTrue(MazePath.moveDown(maze));
        Assert.assertEquals(2, MazePath.startI);

        Assert.assertFalse(MazePath.moveDown(maze));
        Assert.assertFalse(MazePath.moveDown(maze));
        Assert.assertFalse(MazePath.moveDown(maze));
        Assert.assertEquals(2, MazePath.startI);
    }

    @Test
    public void moveLeftTest() {
        maze = new char[][]{
                {'.','.','.','.'},
                {'.','S','.','#'},
                {'T','.','.','.'}
        };

        MazePath.startI = 1;
        MazePath.startJ = 1;

        Assert.assertTrue(MazePath.moveLeft(maze));
        Assert.assertEquals(0, MazePath.startJ);

        Assert.assertFalse(MazePath.moveLeft(maze));
        Assert.assertFalse(MazePath.moveLeft(maze));
        Assert.assertFalse(MazePath.moveLeft(maze));
        Assert.assertEquals(0, MazePath.startJ);
    }

    @Test
    public void moveRightTest() {
        maze = new char[][]{
                {'.','.','.','.'},
                {'.','S','.','#'},
                {'T','.','.','.'}
        };

        MazePath.startI = 1;
        MazePath.startJ = 1;

        Assert.assertTrue(MazePath.moveRight(maze));
        Assert.assertEquals(2, MazePath.startJ);

        Assert.assertFalse(MazePath.moveRight(maze));
        Assert.assertFalse(MazePath.moveRight(maze));
        Assert.assertFalse(MazePath.moveRight(maze));
        Assert.assertEquals(2, MazePath.startJ);
    }

    @Test
    public void moveRightTargetFoundTest() {
        maze = new char[][]{
                {'.','.','.','.'},
                {'S','.','T','#'},
                {'#','.','.','.'}
        };

        MazePath.startI = 1;
        MazePath.startJ = 0;

        Assert.assertTrue(MazePath.moveRight(maze));
        Assert.assertEquals(1, MazePath.startJ);

        Assert.assertFalse(MazePath.moveRight(maze));
        Assert.assertEquals(1, MazePath.startJ);

        Assert.assertFalse(MazePath.moveRight(maze));
        Assert.assertFalse(MazePath.moveRight(maze));
        Assert.assertFalse(MazePath.moveRight(maze));
        Assert.assertEquals(1, MazePath.startJ);
    }

    @Test
    public void findPathTest() {
        maze = new char[][]{
                {'.','.','.','.'},
                {'.','S','.','#'},
                {'T','.','.','.'}
        };

        MazePath.startI = 1;
        MazePath.startJ = 1;

        MazePath.findPath(maze);
    }
}
