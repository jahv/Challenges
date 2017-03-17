package hackerranck.ns.contest.w2;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MazePathV4 {

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry< Node, Integer> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    public static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    public static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    /////////

    public static Graph buildGraph(Node[][] nodes) {
        Graph graph = new Graph();
        for(int i=0; i<nodes.length; i++) {
            for (int j = 0; j < nodes[i].length; j++) {
                graph.addNode(nodes[i][j]);
            }
        }
        return graph;
    }

    public static Node[][] buildNodes(char[][] maze) {
        Node[][] nodes = new Node[maze.length][maze[0].length];
        for(int i=0; i<maze.length; i++) {
            for(int j=0; j<maze[i].length; j++) {
                nodes[i][j] = new Node(maze[i][j]);
            }
        }
        buildRelations(nodes);
        return nodes;
    }

    public static void buildRelations(Node[][] nodes) {
        for(int i=0; i<nodes.length; i++) {
            for(int j=0; j<nodes[i].length; j++) {
                Node node = nodes[i][j];
                if(node.getValue() != '#') {
                    addUp(node, i, j, nodes);
                    addDown(node, i, j, nodes);
                    addLeft(node, i, j, nodes);
                    addRight(node, i, j, nodes);
                }
            }
        }
    }

    public static void addUp(Node main, int i, int j, Node[][] nodes) {
        if(i>0 && isValidRelation(i-1, j, nodes)) {
            Node node = nodes[i-1][j];
            main.addDestination(node, 1);
        }
    }

    public static void addDown(Node main, int i, int j, Node[][] nodes) {
        if(i<nodes.length-1 && isValidRelation(i+1, j, nodes)) {
            Node node = nodes[i+1][j];
            main.addDestination(node, 1);
        }
    }

    public static void addLeft(Node main, int i, int j, Node[][] nodes) {
        if(j>0 && isValidRelation(i, j-1, nodes)) {
            Node node = nodes[i][j-1];
            main.addDestination(node, 1);
        }
    }

    public static void addRight(Node main, int i, int j, Node[][] nodes) {
        if(j<nodes[0].length-1 && isValidRelation(i, j+1, nodes)) {
            Node node = nodes[i][j+1];
            main.addDestination(node, 1);
        }
    }



    public static boolean isValidRelation(int i, int j, Node[][] nodes) {
        return nodes[i][j].getValue()=='.' || nodes[i][j].getValue()=='T';
    }
}
