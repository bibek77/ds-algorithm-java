package com.github.bibek77.dsa.dataStructures.graph.graphMatrix;

import java.util.ArrayList;

/**
 * @author bibek
 */
public class MainClass {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeArrayList = new ArrayList<>();
        nodeArrayList.add(new GraphNode("a", 0));
        nodeArrayList.add(new GraphNode("b", 1));
        nodeArrayList.add(new GraphNode("c", 2));
        nodeArrayList.add(new GraphNode("d", 3));
        nodeArrayList.add(new GraphNode("e", 4));
        Graph graph = new Graph(nodeArrayList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 4);

        System.out.println(graph.matrixToString());

//        graph.bfs();
        graph.dfs();
    }
}
