package com.github.bibek77.dsa.dataStructures.graph.dijkstra_bf_fw;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author bibek
 */
public class WeightedGraph {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    //Implement Dijkstra Algo
    public void dijkstra(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while (!queue.isEmpty()) {
            WeightedNode currNode = queue.poll();
            for (WeightedNode neighbor : currNode.neighbors) {
                if (queue.contains(neighbor)) {
                    if (neighbor.distance > currNode.distance + currNode.weightMap.get(neighbor)) {
                        neighbor.distance = currNode.distance + currNode.weightMap.get(neighbor);
                        neighbor.parent = currNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        for (WeightedNode nodeCheck : nodeList) {
            System.out.print("Node: " + nodeCheck + " , distance: " + nodeCheck.distance + ", Path: ");
            pathPrint(nodeCheck);
            System.out.println();
        }
    }

    public static void pathPrint(WeightedNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    public void addWeightedEdge(int i, int j, int d) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, d);
    }

    //Bellman ford helper
    public void bellmanFord(WeightedNode sourceNode) {
        sourceNode.distance = 0;
        for (int i = 0; i < nodeList.size(); i++) {
            for (WeightedNode currNode : nodeList) {
                for (WeightedNode neighbour : currNode.neighbors) {
                    if (neighbour.distance > currNode.distance + currNode.weightMap.get(neighbour)) {
                        neighbour.distance = currNode.distance + currNode.weightMap.get(neighbour);
                        neighbour.parent = currNode;
                    }
                }
            }
        }
        System.out.println("Checking for Negative Cycle");
        for (WeightedNode currNode : nodeList) {
            for (WeightedNode neighbour : currNode.neighbors) {
                if (neighbour.distance > currNode.distance + currNode.weightMap.get(neighbour)) {
                    System.out.println("Negative cycle found: \n");
                    System.out.println("Vertex Name : " + neighbour.name);
                    System.out.println("Old Cost : " + neighbour.distance);

                    int newDistance = currNode.distance + currNode.weightMap.get(neighbour);
                    System.out.println("New Distance : " + newDistance);
                    return;
                }
            }
        }
        System.out.println("No Negative Cycle");
        for (WeightedNode nodeCheck : nodeList) {
            System.out.print("Node: " + nodeCheck + " , distance: " + nodeCheck.distance + ", Path: ");
            pathPrint(nodeCheck);
            System.out.println();
        }
    }

    // Floyd Warshall
    void floydWarshall() {
        int size = nodeList.size();
        int[][] v = new int[size][size];
        for (int i = 0; i < size; i++) {
            WeightedNode first = nodeList.get(i);
            // Updating initial weight
            // Direct way - weight, no direct way - Infinity, same node - 0
            for (int j = 0; j < size; j++) {
                WeightedNode second = nodeList.get(j);
                if (i == j) {
                    v[i][j] = 0;
                } else if (first.weightMap.containsKey(second)) {
                    v[i][j] = first.weightMap.get(second);
                } else {
                    v[i][j] = Integer.MAX_VALUE / 10; // to avoid arithmetic overflow
                }
            }
        }
        // Main logic
        for (int k = 0; k < nodeList.size(); k++) {
            for (int i = 0; i < nodeList.size(); i++) {
                for (int j = 0; j < nodeList.size(); j++) {
                    if (v[i][j] > v[i][k] + v[k][j]) {
                        v[i][j] = v[i][k] + v[k][j];
                    }
                }
            }
        }

        // Printing the graph
        for (int i = 0; i < size; i++) {
            System.out.println("Printing Distance for node : " + i);
            for (int j = 0; j < size; j++) {
                System.out.print(v[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
