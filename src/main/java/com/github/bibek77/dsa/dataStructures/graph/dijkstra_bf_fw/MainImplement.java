package com.github.bibek77.dsa.dataStructures.graph.dijkstra_bf_fw;

import java.util.ArrayList;

/**
 * @author bibek
 */
public class MainImplement {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();
        nodeList.add(new WeightedNode("a", 0));
        nodeList.add(new WeightedNode("b", 1));
        nodeList.add(new WeightedNode("c", 2));
        nodeList.add(new WeightedNode("d", 3));
        nodeList.add(new WeightedNode("e", 4));
        nodeList.add(new WeightedNode("f", 5));
        nodeList.add(new WeightedNode("g", 6));

        WeightedGraph weightedGraph = new WeightedGraph(nodeList);
        weightedGraph.addWeightedEdge(0, 1, 2);
        weightedGraph.addWeightedEdge(0, 2, 5);
        weightedGraph.addWeightedEdge(1, 2, 6);
        weightedGraph.addWeightedEdge(1, 3, 1);
        weightedGraph.addWeightedEdge(1, 4, 3);
        weightedGraph.addWeightedEdge(2, 5, 8);
        weightedGraph.addWeightedEdge(3, 4, 4);
        weightedGraph.addWeightedEdge(4, 6, 9);
        weightedGraph.addWeightedEdge(5, 6, 7);
//        System.out.println("Printing dijkstra from a");
//        weightedGraph.dijkstra(nodeList.get(0));
//        System.out.println("Printing Bellman Ford from source a");
//        weightedGraph.bellmanFord(nodeList.get(0));
        weightedGraph.floydWarshall();


    }
}
