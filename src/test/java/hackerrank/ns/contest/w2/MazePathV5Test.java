package hackerrank.ns.contest.w2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import hackerranck.ns.contest.w2.MazePathV5;

/**
 * Created by ahernandez on 2/23/17.
 */
public class MazePathV5Test {

    private char[][] maze;
    private double[][] distance;
    private char[][] visited;

    @Before
    public void setUp() {
        maze = new char[][]{
                {'.','.','.','.'},
                {'.','S','.','#'},
                {'T','.','.','.'}
        };

        distance = new double[maze.length][maze[0].length];
        visited = new char[maze.length][maze[0].length];
        for(int i=0; i<distance.length; i++) {
            for (int j=0; j<distance[i].length; j++) {
                if(maze[i][j]!='#') {
                    distance[i][j] = Double.POSITIVE_INFINITY;
                    visited[i][j] = '-';
                } else {
                    distance[i][j] = -1;
                    visited[i][j] = 'X';
                }
            }
        }
    }

    @Test
    public void dijsktraTest() {
        List<Map<String, Integer>> nonVisited = new ArrayList<>();
        Map<String, Integer> first = new HashMap<>();
        first.put("i", 1);
        first.put("j", 1);
        nonVisited.add(first);
        distance[1][1] = 0;
        MazePathV5.dijkstra(1,1,maze, distance, visited, nonVisited);

        System.out.println("\n\n###########");
        MazePathV5.print(distance);
        MazePathV5.print(visited);
    }

    @Test
    public void adjacentTest() {
        Map<String, Integer> up = new HashMap<>();
        Map<String, Integer> down = new HashMap<>();
        Map<String, Integer> left = new HashMap<>();
        Map<String, Integer> right = new HashMap<>();
        List<Map<String, Integer>> expected = new ArrayList<>();

        up.put("i", 0); up.put("j", 1);
        down.put("i", 2); down.put("j", 1);
        left.put("i", 1); left.put("j", 0);
        right.put("i", 1); right.put("j", 2);
        expected.add(up); expected.add(down);
        expected.add(left); expected.add(right);

        List<Map<String, Integer>> adjacent = MazePathV5.adjacent(1, 1, maze, visited);
        Assert.assertEquals(expected, adjacent);

        expected.clear();
        down.put("i", 1); down.put("j", 0);
        right.put("i", 0); right.put("j", 1);
        expected.add(down); expected.add(right);
        adjacent = MazePathV5.adjacent(0, 0, maze, visited);
        Assert.assertEquals(expected, adjacent);

    }

    @Test
    public void upTest() {
        Map<String, Integer> up = MazePathV5.up(2, 1, maze, visited);
        Map<String, Integer> expected = new HashMap<>();

        expected.put("i", 1);
        expected.put("j", 1);
        Assert.assertEquals(expected, up);

        up = MazePathV5.up(2, 3, maze, visited);
        Assert.assertEquals(null, up);

        up = MazePathV5.up(0, 0, maze, visited);
        Assert.assertEquals(null, up);

        expected.put("i", 1);
        expected.put("j", 0);
        up = MazePathV5.up(2, 0, maze, visited);
        Assert.assertEquals(expected, up);

    }

    @Test
    public void downTest() {
        Map<String, Integer> down;
        Map<String, Integer> expected = new HashMap<>();

        down = MazePathV5.down(2, 1, maze, visited);
        Assert.assertEquals(null, down);

        down = MazePathV5.down(2, 3, maze, visited);
        Assert.assertEquals(null, down);

        down = MazePathV5.down(0, 0, maze, visited);
        expected.put("i", 1);
        expected.put("j", 0);
        Assert.assertEquals(expected, down);

        down = MazePathV5.down(2, 0, maze, visited);
        Assert.assertEquals(null, down);

        down = MazePathV5.down(0, 3, maze, visited);
        Assert.assertEquals(null, down);
    }

    @Test
    public void leftTest() {
        Map<String, Integer> left;
        Map<String, Integer> expected = new HashMap<>();

        left = MazePathV5.left(2, 1, maze, visited);
        expected.put("i", 2);
        expected.put("j", 0);
        Assert.assertEquals(expected, left);

        left = MazePathV5.left(2, 3, maze, visited);
        expected.put("i", 2);
        expected.put("j", 2);
        Assert.assertEquals(expected, left);

        left = MazePathV5.left(0, 0, maze, visited);
        Assert.assertEquals(null, left);

        left = MazePathV5.left(2, 0, maze, visited);
        Assert.assertEquals(null, left);

        left = MazePathV5.left(0, 3, maze, visited);
        expected.put("i", 0);
        expected.put("j", 2);
        Assert.assertEquals(expected, left);
    }

    @Test
    public void rightTest() {
        Map<String, Integer> right;
        Map<String, Integer> expected = new HashMap<>();

        right = MazePathV5.right(2, 1, maze, visited);
        expected.put("i", 2);
        expected.put("j", 2);
        Assert.assertEquals(expected, right);

        right = MazePathV5.right(2, 3, maze, visited);
        Assert.assertEquals(null, right);

        right = MazePathV5.right(0, 0, maze, visited);
        expected.put("i", 0);
        expected.put("j", 1);
        Assert.assertEquals(expected, right);

        right = MazePathV5.right(2, 0, maze, visited);
        expected.put("i", 2);
        expected.put("j", 1);
        Assert.assertEquals(expected, right);

        right = MazePathV5.right(0, 3, maze, visited);
        Assert.assertEquals(null, right);
    }
}
