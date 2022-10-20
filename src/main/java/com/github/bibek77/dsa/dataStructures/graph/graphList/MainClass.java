package com.github.bibek77.dsa.dataStructures.graph.graphList;

import java.util.ArrayList;

/**
 * @author bibek
 */
public class MainClass {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("a", 0));
        nodeList.add(new GraphNode("b", 1));
        nodeList.add(new GraphNode("c", 2));
        nodeList.add(new GraphNode("d", 3));
        nodeList.add(new GraphNode("e", 4));
        Graph graph = new Graph(nodeList);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 4);
        System.out.println(graph.listToString());

        graph.bfs();

    }
}
