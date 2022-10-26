package com.github.bibek77.dsa.dataStructures.graph.graphMatrix;

import java.util.*;

/**
 * @author bibek
 */
public class Graph {

    ArrayList<GraphNode> nodeList;
    int[][] adjacencyMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }

    public String matrixToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    ");
        for (GraphNode num : nodeList) {
            stringBuilder.append(num.name + " ");
        }
        stringBuilder.append("\n");
        int k = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            stringBuilder.append(nodeList.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                stringBuilder.append((j) + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    //Getting Neighbours
    public ArrayList<GraphNode> getNeighbours(GraphNode node) {
        ArrayList<GraphNode> neighbours = new ArrayList<>();
        int nodeIndex = node.index;
        // loop from first node to last node, ie equal to adjacency matrix col size
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1) {
                neighbours.add(nodeList.get(i));
            }
        }
        return neighbours;
    }

    // helper method for BFS
    public void bfsVisit(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbours = getNeighbours(currentNode);
            for (GraphNode neighbour : neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    // BFS Main
    public void bfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    // DFS Visit
    public void dfsVisit(GraphNode node) {
        Stack<GraphNode> stk = new Stack<>();
        stk.push(node);
        while (!stk.empty()) {
            GraphNode currNode = stk.pop();
            currNode.isVisited = true;
            System.out.print(currNode.name + " ");
            ArrayList<GraphNode> neighbours = getNeighbours(currNode);
            for (GraphNode neighbour : neighbours) {
                if (!neighbour.isVisited) {
                    stk.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    //dfs main
    public void dfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                dfsVisit(node);
            }
        }
    }

    // Topological Sort
    public void addDirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1; // only one way connection
    }

    public void topologicalVisit(GraphNode node, Stack<GraphNode> stk) {
        ArrayList<GraphNode> neighbours = getNeighbours(node);
        for (GraphNode neighbour : neighbours) {
            if (!neighbour.isVisited) {
                topologicalVisit(neighbour, stk);
            }
        }
        node.isVisited = true;
        stk.push(node);
    }

    public void topologicalSort() {
        Stack<GraphNode> stk = new Stack<>();
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                topologicalVisit(node, stk);
            }
        }
        while (!stk.empty()) {
            System.out.print(stk.pop().name + " ");
        }
    }

    // SSSP print path
    public static void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    // SSSP Implement
    public void bfsForSSSP(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currNode = queue.remove(0);
            currNode.isVisited = true;
            System.out.print("Printing Path for Node : " + currNode.name + " -> ");
            pathPrint(currNode);
            System.out.println();
            ArrayList<GraphNode> neighbours = getNeighbours(currNode);
            for (GraphNode neighbour : neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = currNode;
                }
            }
        }
    }

}
