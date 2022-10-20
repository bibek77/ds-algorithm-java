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
        for (GraphNode i : nodeList) {
            stringBuilder.append(i.name + " : ");
            for (int j : adjacencyMatrix[k++]) {
                stringBuilder.append(j + " ");
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
            currentNode.isVisted = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbours = getNeighbours(currentNode);
            for (GraphNode neighbour : neighbours) {
                if (!neighbour.isVisted) {
                    queue.add(neighbour);
                    neighbour.isVisted = true;
                }
            }
        }
    }

    // BFS Main
    public void bfs() {
        for(GraphNode node : nodeList) {
            if(!node.isVisted) {
                bfsVisit(node);
            }
        }
    }
}
