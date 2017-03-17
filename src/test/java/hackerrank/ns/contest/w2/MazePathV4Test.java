package hackerrank.ns.contest.w2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hackerranck.ns.contest.w2.Graph;
import hackerranck.ns.contest.w2.MazePath;
import hackerranck.ns.contest.w2.MazePathV4;
import hackerranck.ns.contest.w2.Node;

/**
 * Created by ahernandez on 2/23/17.
 */
public class MazePathV4Test {
    private Node[][] nodes;
    Node n00, n01, n02, n10, n11, n12, n20, n21, n22;
    char[][] maze;

    @Before
    public void setUp() {
        n00 = new Node('.');
        n01 = new Node('.');
        n02 = new Node('#');

        n10 = new Node('S');
        n11 = new Node('#');
        n12 = new Node('T');

        n20 = new Node('.');
        n21 = new Node('.');
        n22 = new Node('.');

        nodes = new Node[][]{
                {n00, n01, n02},
                {n10, n11, n12},
                {n20, n21, n22},
        };

        maze = new char[][]{
                {'.','.','#'},
                {'S','#','T'},
                {'.','.','.'},
        };
    }

    @Test
    public void testDijkstra() {
        Node[][] nodes = MazePathV4.buildNodes(maze);
        Graph graph = MazePathV4.buildGraph(nodes);

        Graph newGraph = MazePathV4.calculateShortestPathFromSource(graph, n10);
        System.out.println(newGraph.getNodes());
    }

    @Test
    public void buildNodesTest() {
        Node[][] nodes = MazePathV4.buildNodes(maze);
        for(int i=0; i<nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                Assert.assertEquals(maze[i][j], nodes[i][j].getValue());
                System.out.println("["+i+","+j+"]" + nodes[i][j].getValue() + ": " + nodes[i][j].getAdjacentNodes());
            }
        }
    }

    @Test
    public void buildRelationsTest() {
        Node[][] nodes = MazePathV4.buildNodes(maze);
        MazePathV4.buildRelations(nodes);
        for(int i=0; i<nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                System.out.println("["+i+","+j+"]" + nodes[i][j].getValue() + ": " + nodes[i][j].getAdjacentNodes());
            }
        }
    }

    @Test
    public void addRightTest() {
        MazePathV4.addRight(n00, 0, 0, nodes);
        Assert.assertEquals(1, n00.getAdjacentNodes().size());
        System.out.println(n00.getAdjacentNodes());

        MazePathV4.addRight(n01, 0, 1, nodes);
        Assert.assertEquals(0, n01.getAdjacentNodes().size());
        System.out.println(n01.getAdjacentNodes());

        MazePathV4.addRight(n12, 1, 2, nodes);
        Assert.assertEquals(0, n12.getAdjacentNodes().size());
        System.out.println(n12.getAdjacentNodes());

        MazePathV4.addRight(n10, 1, 0, nodes);
        Assert.assertEquals(0, n10.getAdjacentNodes().size());
        System.out.println(n10.getAdjacentNodes());

        MazePathV4.addRight(n20, 2, 0, nodes);
        Assert.assertEquals(1, n20.getAdjacentNodes().size());
        System.out.println(n20.getAdjacentNodes());
    }

    @Test
    public void addLeftTest() {
        MazePathV4.addLeft(n00, 0, 0, nodes);
        Assert.assertTrue(n00.getAdjacentNodes().isEmpty());
        System.out.println(n00.getAdjacentNodes());

        MazePathV4.addLeft(n01, 0, 1, nodes);
        Assert.assertEquals(1, n01.getAdjacentNodes().size());
        System.out.println(n01.getAdjacentNodes());

        MazePathV4.addLeft(n12, 1, 1, nodes);
        Assert.assertTrue(n12.getAdjacentNodes().isEmpty());
        System.out.println(n12.getAdjacentNodes());
    }

    @Test
    public void addUpTest() {
        MazePathV4.addUp(n00, 0, 0, nodes);
        Assert.assertTrue(n00.getAdjacentNodes().isEmpty());
        System.out.println(n00.getAdjacentNodes());

        MazePathV4.addUp(n10, 1, 0, nodes);
        Assert.assertEquals(1, n10.getAdjacentNodes().size());
        System.out.println(n10.getAdjacentNodes());

        MazePathV4.addUp(n21, 2, 1, nodes);
        Assert.assertTrue(n00.getAdjacentNodes().isEmpty());
        System.out.println(n21.getAdjacentNodes());

        MazePathV4.addUp(n22, 2, 2, nodes);
        Assert.assertEquals(1, n22.getAdjacentNodes().size());
        System.out.println(n22.getAdjacentNodes());
    }

    @Test
    public void addDownTest() {
        MazePathV4.addDown(n00, 0,0, nodes);
        Assert.assertEquals(0, n00.getAdjacentNodes().size());
        System.out.println(n00.getAdjacentNodes());

        MazePathV4.addDown(n01, 0,1, nodes);
        Assert.assertEquals(0, n01.getAdjacentNodes().size());
        System.out.println(n01.getAdjacentNodes());

        MazePathV4.addDown(n10, 1,0, nodes);
        Assert.assertEquals(1, n10.getAdjacentNodes().size());
        System.out.println(n10.getAdjacentNodes());

        MazePathV4.addDown(n20, 2,0, nodes);
        Assert.assertEquals(0, n20.getAdjacentNodes().size());
        System.out.println(n20.getAdjacentNodes());
    }
}
