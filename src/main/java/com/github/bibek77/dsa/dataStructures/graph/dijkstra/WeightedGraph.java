package com.github.bibek77.dsa.dataStructures.graph.dijkstra;

import com.github.bibek77.dsa.dataStructures.graph.graphList.GraphNode;

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
}
