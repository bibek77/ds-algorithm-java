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
}
