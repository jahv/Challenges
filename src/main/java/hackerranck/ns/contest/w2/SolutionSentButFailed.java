package hackerranck.ns.contest.w2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SolutionSentButFailed {

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

        //System.out.println(r);
        if(r.isEmpty()) {
            System.out.println("DOOMED");
        } else {
            Collections.sort(r);
            System.out.println(r.get(0));
        }
    }

    public static void findPath(int i, int j, char[][] maze, int c, List<Integer> r) {
        if(isValid(i, j, maze)) {
            c++;
            if(isTarget(i, j, maze)) {
                r.add(c);
                //System.out.println(r);
            } else {
                visit(i, j, maze);
                //find down
                findPath(i+1, j, maze, c, r);
                //find up
                findPath(i-1, j, maze, c, r);
                //find left
                findPath(i, j-1, maze, c, r);
                //Find right
                findPath(i, j+1, maze, c, r);
            }
        }
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
    }
}