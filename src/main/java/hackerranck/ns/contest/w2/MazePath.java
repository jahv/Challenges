package hackerranck.ns.contest.w2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ahernandez on 2/22/17.
 */
public class MazePath {

    public static int startI = -1;
    public static int startJ = -1;
    public static int targetI = -1;
    public static int targetJ = -1;

    public static int counter = 0;
    public static boolean keepLooking = true;

    public static List<Integer> stackI = new ArrayList<>();
    public static List<Integer> stackJ = new ArrayList<>();
    public static List<Character> stackChar = new ArrayList<>();
    public static List<Integer> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

        if((N < 1 || N > 1000) || (M < 1 || M > 1000)) {
            throw new RuntimeException("Constrains: 1 <= N <= 1000 and 1 <= M <= 1000\n");
        }

        //System.out.println(N +"x"+M);


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
                    if(data.charAt(j)=='T') {
                        targetI = i-1;
                        targetJ = j;
                    }
                }
            }
        }

        System.out.println("Start: " + startI + ", " + startJ);
        System.out.println("Target: " + targetI + ", " + targetJ);

        printMaze(maze);
        moveUp(maze);
        printMaze(maze);

        moveUp(maze);
        printMaze(maze);

        moveUp(maze);
        printMaze(maze);

        moveUp(maze);
        printMaze(maze);

        moveUp(maze);
        printMaze(maze);

    }

    public static void findPath(char[][] maze) {
        System.out.println("Original:");
        printMaze(maze);
        while(true) {
            if(moveUp(maze)||moveLeft(maze)||moveDown(maze)||moveRight(maze)) {
                //System.out.println("->");
                //printMaze(maze);
                if (!keepLooking) {
                    break;
                }
            } else {
                System.out.println("Else");

                maze[startI][startJ] = 'V';

                System.out.println(stackI);
                System.out.println(stackJ);
                System.out.println(stackChar);
                System.out.println(results);

                startI = stackI.remove(stackI.size()-1);
                startJ = stackJ.remove(stackJ.size()-1);
                maze[startI][startJ] = '.';

                System.out.println("New start i: " + startI);
                System.out.println("New start j: " + startJ);

                System.out.println(stackI);
                System.out.println(stackJ);
                System.out.println(stackChar);
                System.out.println(results);

                printMaze(maze);
//                break;
            }
        }
    }

    public static void push(char c) {
        stackI.add(startI);
        stackJ.add(startJ);
        stackChar.add('.');
    }

    public static boolean moveUp(char[][] maze) {
        System.out.println("Move Up");
        if((startI > 0) && isAllowToMove(maze[startI-1][startJ])) {
            push(maze[startI][startJ]);
            maze[startI][startJ] = 'X';
            //maze[startI - 1][startJ] = 'S';
            startI--;
            counter++;
            return true;
        } else {
            System.out.println("No more up");
            return false;
        }
    }

    public static boolean moveDown(char[][] maze) {
        System.out.println("Move Down");
        if((startI < maze.length - 1) && isAllowToMove(maze[startI+1][startJ])) {
            push(maze[startI][startJ]);
            maze[startI][startJ] = 'X';
            //maze[startI + 1][startJ] = 'S';
            startI++;
            counter++;
            return true;
        } else {
            System.out.println("No more down");
            return false;
        }
    }

    public static boolean moveLeft(char[][] maze) {
        System.out.println("Move Left");
        if((startJ > 0) && isAllowToMove(maze[startI][startJ-1])) {
            push(maze[startI][startJ]);
            maze[startI][startJ] = 'X';
            //maze[startI][startJ - 1] = 'S';
            startJ--;
            counter++;
            return true;
        } else {
            System.out.println("No more left");
            return false;
        }
    }

    public static boolean moveRight(char[][] maze) {
        System.out.println("Move Right");
        if((startJ < maze[0].length - 1) && isAllowToMove(maze[startI][startJ+1])) {
            push(maze[startI][startJ]);
            maze[startI][startJ] = 'X';
            //maze[startI][startJ + 1] = 'S';
            startJ++;
            counter++;
            return true;
        } else {
            System.out.println("No more right");
            return false;
        }
    }

    public static boolean isAllowToMove(char c) {
        if(isTarget(c)) {
            counter++;
            System.out.println("Target found");
            System.out.println("Movements=" + counter);
            results.add(counter);
            counter=0;
            keepLooking = false;
            return false;
        }
        return c=='.';
    }

    public static boolean isTarget(char c) {
        return c=='T';
    }

    public static void printMaze(char[][] maze) {
        System.out.println("\n==================\n");
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\n==================\n");
    }
}
