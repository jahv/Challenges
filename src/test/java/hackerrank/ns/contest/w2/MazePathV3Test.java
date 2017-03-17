package hackerrank.ns.contest.w2;


import org.junit.Before;
import org.junit.Test;

import hackerranck.ns.contest.w2.MazePathV3;
import hackerranck.ns.contest.w2.Node;

/**
 * Created by ahernandez on 2/23/17.
 */
public class MazePathV3Test {

    private MazePathV3 mazePath3;
    private char[][] maze;

    @Before
    public void setUp() {
        mazePath3 = new MazePathV3();
        maze = new char[][]{
                {'.','.','.','.'},
                {'.','S','.','#'},
                {'T','.','.','.'}
        };
    }

    @Test
    public void buildNodesTest() {
        Node[][] nodes = mazePath3.buildNodes(maze);
        mazePath3.printNodeMatrix(nodes);
    }

    @Test
    public void buildRelationsTest() {
        Node[][] nodes = mazePath3.buildNodes(maze);
        mazePath3.printNodeMatrix(nodes);

        for(int i=0; i<maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                mazePath3.buildRelations(mazePath3.UP, i, j, nodes, maze);
                mazePath3.buildRelations(mazePath3.DOWN, i, j, nodes, maze);
                mazePath3.buildRelations(mazePath3.LEFT, i, j, nodes, maze);
                mazePath3.buildRelations(mazePath3.RIGTH, i, j, nodes, maze);
            }
        }

        mazePath3.printMaze(maze);
    }

}
