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

//        graph.bfs();
//        graph.dfs();
        System.out.println();

        ArrayList<GraphNode> nodeList2 = new ArrayList<>();
        nodeList2.add(new GraphNode("a", 0));
        nodeList2.add(new GraphNode("b", 1));
        nodeList2.add(new GraphNode("c", 2));
        nodeList2.add(new GraphNode("d", 3));
        nodeList2.add(new GraphNode("e", 4));
        nodeList2.add(new GraphNode("f", 5));
        nodeList2.add(new GraphNode("g", 6));
        nodeList2.add(new GraphNode("h", 7));
        Graph graph2 = new Graph(nodeList2);
        graph2.addDirectedEdge(0, 2);
        graph2.addDirectedEdge(2, 4);
        graph2.addDirectedEdge(4, 7);
        graph2.addDirectedEdge(4, 5);
        graph2.addDirectedEdge(5, 6);
        graph2.addDirectedEdge(1, 2);
        graph2.addDirectedEdge(1, 3);
        graph2.addDirectedEdge(3, 5);
        System.out.println(graph2.listToString());

        graph2.topologicalSort();


    }
}
