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
            System.out.print("Node: " + nodeCheck + " , distance: " + nodeCheck.distance + ", Path: " );
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
}
