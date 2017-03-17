package hackerranck.ns.contest.w2;

public class MazePathV3 {

    public static final int UP = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGTH = 4;

    public Node[][] buildNodes(char[][] maze) {
        Node[][] nodesMatrix = new Node[maze.length][maze[0].length];
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[i].length; j++) {
                Node node = new Node(maze[i][j]);
                nodesMatrix[i][j] = node;
            }
        }
        return nodesMatrix;
    }



    public void buildRelations(int direction, int i, int j, Node[][] nodes, char[][] maze) {
        if(isValidRelation(i,j,maze)) {
            Node node = nodes[i][j];

            Node neighbord = null;

            switch (direction) {
                case UP:
                    if (i > 0 && isValidRelation(i - 1, j, maze)) {
                        neighbord = nodes[i - 1][j];
                        visit(i - 1, j, maze);
                    }
                    break;
                case DOWN:
                    if (i < maze.length - 1 && isValidRelation(i + 1, j, maze)) {
                        neighbord = nodes[i + 1][j];
                        visit(i + 1, j, maze);
                    }
                    break;
                case LEFT:
                    if (j > 0 && isValidRelation(i, j - 1, maze)) {
                        neighbord = nodes[i][j - 1];
                        visit(i, j - 1, maze);
                    }
                    break;
                case RIGTH:
                    if (j < maze[0].length && isValidRelation(i, j + 1, maze)) {
                        neighbord = nodes[i][j + 1];
                        visit(i, j + 1, maze);
                    }
                    break;
            }

            if (neighbord != null) {
                node.addDestination(neighbord, 1);
                if (node.getValue() != 'S') {
                    neighbord.addDestination(node, 1);
                }
            }
        }
    }

//    public boolean processUp(int i, int j, char[][] maze, Node[][] nodes) {
//        if (i > 0 && isValidRelation(i - 1, j, maze)) {
//            neighbord = nodes[i - 1][j];
//            visit(i - 1, j, maze);
//        }
//    }

    public boolean isValidRelation(int i, int j, char[][] maze) {
        return maze[i][j] == '.' || maze[i][j] == 'T' || maze[i][j] == 'S';
    }

    public void visit(int i, int j, char[][] maze) {
        maze[i][j] = 'V';
    }

    public void printNodeMatrix(Node[][] nodeMatrix) {
        for(int i=0; i<nodeMatrix.length; i++) {
            for (int j = 0; j < nodeMatrix[i].length; j++) {
                System.out.print(nodeMatrix[i][j].getValue());
            }
            System.out.println();
        }
    }

    public void printMaze(char[][] maze) {
        for(int i=0; i<maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

}