package hackerranck.ns.contest.w2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ahernandez on 2/23/17.
 */
public class MazePathV2 {
    static final int UP = 1;
    static final int DOWN = 2;
    static final int LEFT = 3;
    static final int RIGHT = 4;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

        if((N < 1 || N > 1000) || (M < 1 || M > 1000)) {
            throw new RuntimeException("Constrains: 1 <= N <= 1000 and 1 <= M <= 1000\n");
        }

        int startI = -1;
        int startJ = -1;


        //Fill the initial Maze
        char maze[][] = new char[N][M];
        for(int i=0; i<N+1; i++) {
            String data = scan.nextLine();
            if(i>1 && data.length()!=M){
                throw new RuntimeException("Invalid length for line ["+i+"]");
            } else {
                for(int j=0; j<data.length(); j++) {
                    maze[i-1][j] = data.charAt(j);
                    if(data.charAt(j)=='S') {
                        startI = i-1;
                        startJ = j;
                    }
                }
            }
        }

        //Look for the paths
        int c=0;
        List<Integer> r = new ArrayList<>();
        findPath(startI+1, startJ, maze, c, r);
        findPath(startI-1, startJ, maze, c, r);
        findPath(startI, startJ+1, maze, c, r);
        findPath(startI, startJ-1, maze, c, r);

        System.out.println(r);
        if(r.isEmpty()) {
            System.out.println("DOOMED");
        } else {
            Collections.sort(r);
            System.out.println(r.get(0));
        }
        System.out.println("Final");
        printMaze(maze);
    }

    public static void findPath(int i, int j, char[][] maze, int c, List<Integer> r) {
        if(isValid(i, j, maze)) {
            c++;
            if(isTarget(i, j, maze)) {
                r.add(c);
                System.out.println("Result: "+r);
                //printMaze(maze);
            } else {
                visit(i, j, maze);
                if(canMove(DOWN, i, j, maze)) {
                    findPath(i + 1, j, maze, c, r);
                }
                if(canMove(UP, i, j, maze)) {
                    findPath(i - 1, j, maze, c, r);
                }
                if(canMove(LEFT, i, j, maze)) {
                    findPath(i, j - 1, maze, c, r);
                }
                if(canMove(RIGHT, i, j, maze)) {
                    findPath(i, j + 1, maze, c, r);
                }
            }
        }
    }



    public static boolean canMove(int direction, int i, int j, char[][] maze) {
        switch (direction) {
            case UP: return isValid(i-1, j, maze);
            case DOWN: return isValid(i+1, j, maze);
            case LEFT: return isValid(i, j-1, maze);
            case RIGHT: return isValid(i, j+1, maze);
        }
        return false;
    }

    public static boolean isValid(int i, int j, char[][] maze) {
        if( (i>=0 && i<maze.length)
                && (j >= 0 && j < maze[0].length)
                && (maze[i][j]== '.' || maze[i][j]=='T')) {
            return true;
        }
        return false;
    }

    public static boolean isTarget(int i, int j, char[][] maze) {
        return maze[i][j] == 'T';
    }

    public static void visit(int i, int j, char[][] maze) {
        maze[i][j] = 'V';
        System.out.println("Visit:");
        printMaze(maze);
    }

    public static void printMaze(char[][] maze) {
        System.out.println("==================");
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println("");
        }
        System.out.println("==================");
    }
}
