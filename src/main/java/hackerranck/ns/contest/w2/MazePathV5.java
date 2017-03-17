package hackerranck.ns.contest.w2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ahernandez on 2/23/17.
 */
public class MazePathV5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

        if((N < 1 || N > 1000) || (M < 1 || M > 1000)) {
            throw new RuntimeException("Constrains: 1 <= N <= 1000 and 1 <= M <= 1000\n");
        }
        int startI = -1;
        int startJ = -1;
        int targetI = -1;
        int targetJ = -1;

        //Fill the initial Maze
        char maze[][] = new char[N][M];
        double[][] distance = new double[maze.length][maze[0].length];
        char[][] visited = new char[maze.length][maze[0].length];
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

                    if(maze[i-1][j]!='#') {
                        distance[i-1][j] = Double.POSITIVE_INFINITY;
                        visited[i-1][j] = '-';
                    } else {
                        distance[i-1][j] = -1;
                        visited[i-1][j] = 'X';
                    }
                }
            }
        }

//        System.out.println("TI:"+targetI);
//        System.out.println("TJ:"+targetJ);



//        for(int i=0; i<distance.length; i++) {
//            for (int j=0; j<distance[i].length; j++) {
//                if(maze[i][j]!='#') {
//                    distance[i][j] = Double.POSITIVE_INFINITY;
//                    visited[i][j] = '-';
//                } else {
//                    distance[i][j] = -1;
//                    visited[i][j] = 'X';
//                }
//            }
//        }

        List<Map<String, Integer>> nonVisited = new ArrayList<>();
        Map<String, Integer> first = new HashMap<>();
        first.put("i", startI);
        first.put("j", startJ);
        nonVisited.add(first);
        distance[startI][startJ] = 0;
        dijkstra(1,1,maze, distance, visited, nonVisited);

//        System.out.println("\n\n###########");
//        MazePathV5.print(distance);
//        MazePathV5.print(visited);

        double result = distance[targetI][targetJ];
        if(result==Double.POSITIVE_INFINITY) {
            System.out.println("DOOMED");
        } else {
            int r = (int)result;
            System.out.println(r);
        }


    }

    public static void dijkstra(int startI, int startJ, char[][] maze, double[][] distance, char[][] visited,
                                List<Map<String, Integer>> nonVisited) {


        for(int i=0; i<nonVisited.size(); i++) {
            Map<String, Integer> noVisited = nonVisited.get(i);
            int nonVisitedI = noVisited.get("i");
            int nonVisitedJ = noVisited.get("j");
//            System.out.format("D: %d,%d\n", nonVisitedI, nonVisitedJ);

            visited[nonVisitedI][nonVisitedJ] = 'V';
            List<Map<String, Integer>> adjacentList = adjacent(nonVisitedI, nonVisitedJ, maze, visited);
            //nonVisited.addAll(adjacentList);
            for (Map<String, Integer> adjacent : adjacentList) {
                int adjI = adjacent.get("i");
                int adjJ = adjacent.get("j");
                if (visited[adjI][adjJ] == '-') {
                    if (distance[nonVisitedI][nonVisitedJ] + 1 < distance[adjI][adjJ]) {
                        distance[adjI][adjJ] = distance[nonVisitedI][nonVisitedJ] + 1;
                        nonVisited.add(adjacent);
                    }
                }
            }
        }

        //}

//        print(distance);
//        print(visited);
//
//        List<Map<String, Integer>> adjacent = adjacent(startI, startJ, maze, visited);
//        System.out.println(adjacent);
//
//        visited[startI][startJ] = 'V';
//        distance[startI][startJ] = 0;




//        double minimum = Double.POSITIVE_INFINITY;
//        Map<String, Integer> minimumCoordinates = null;

//        for(Map<String, Integer> coordinate : adjacent) {
//            visited[startI][startJ] = 'V';
//            int adjI = coordinate.get("i");
//            int adjJ = coordinate.get("j");
//
//            if(visited[adjI][adjJ] == '-') {
//                double currentCost = distance[startI][startJ] + 1;
//                double adjCost = distance[adjI][adjJ];
//                if(currentCost < adjCost) {
//                    distance[adjI][adjJ] = currentCost;
//                    dijkstra(adjI, adjJ, maze, distance, visited);
//                }
//            }

//            if(distance[coordinate.get("i")][coordinate.get("j")] > distance[startI][startJ] + 1) {
//                distance[coordinate.get("i")][coordinate.get("j")] = distance[startI][startJ] + 1;
//            }
//            if(distance[coordinate.get("i")][coordinate.get("j")] < minimum) {
//                minimum = distance[coordinate.get("i")][coordinate.get("j")];
//                minimumCoordinates = coordinate;
//            }
            //dijkstra(coordinate.get("i"), coordinate.get("j"), maze, distance, visited);
//        }

        //dijkstra(minimumCoordinates.get("i"), minimumCoordinates.get("j"), maze, distance, visited);
    }

    public static List<Map<String, Integer>> adjacent(int i, int j, char[][] maze, char[][] visited) {
        List<Map<String, Integer>> adjacent = new ArrayList<>();
        Map<String, Integer> up = up(i, j, maze, visited);
        Map<String, Integer> down = down(i, j, maze, visited);
        Map<String, Integer> left = left(i, j, maze, visited);
        Map<String, Integer> right = right(i, j, maze, visited);

        if(up != null) {
            adjacent.add(up);
        }

        if(down != null) {
            adjacent.add(down);
        }

        if(left != null) {
            adjacent.add(left);
        }

        if(right != null) {
            adjacent.add(right);
        }

        return adjacent;
    }

    public static Map<String, Integer> up(int i, int j, char[][] maze, char[][] visited) {
        Map<String, Integer> coordinates = null;
        if(i>0 && isValid(maze[i-1][j])) {
            coordinates = new HashMap<>();
            coordinates.put("i", i-1);
            coordinates.put("j", j);
        }
        return coordinates;
    }

    public static Map<String, Integer> down(int i, int j, char[][] maze, char[][] visited) {
        Map<String, Integer> coordinates = null;
        if(i<maze.length-1 && isValid(maze[i+1][j])) {
            coordinates = new HashMap<>();
            coordinates.put("i", i+1);
            coordinates.put("j", j);
        }
        return coordinates;
    }

    public static Map<String, Integer> left(int i, int j, char[][] maze, char[][] visited) {
        Map<String, Integer> coordinates = null;
        if(j>0 && isValid(maze[i][j-1])) {
            coordinates = new HashMap<>();
            coordinates.put("i", i);
            coordinates.put("j", j-1);
        }
        return coordinates;
    }

    public static Map<String, Integer> right(int i, int j, char[][] maze, char[][] visited) {
        Map<String, Integer> coordinates = null;
        if(j<maze[0].length-1 && isValid(maze[i][j+1])) {
            coordinates = new HashMap<>();
            coordinates.put("i", i);
            coordinates.put("j", j+1);
        }
        return coordinates;
    }

    public static boolean isValid(char c) {
        return c != '#';
    }

    public static void print(double[][] distance) {
        System.out.println("============");
        for(int i=0; i<distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                System.out.format("%10.0f", distance[i][j]);
            }
            System.out.println();
        }
        System.out.println("============");
    }

    public static void print(char[][] visited) {
        System.out.println("============");
        for(int i=0; i<visited.length; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                System.out.format("%s ", visited[i][j]);
            }
            System.out.println();
        }
        System.out.println("============");
    }
}
