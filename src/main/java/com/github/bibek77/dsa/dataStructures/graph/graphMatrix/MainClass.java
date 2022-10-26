package com.github.bibek77.dsa.dataStructures.graph.graphMatrix;
import java.util.ArrayList;

/**
 * @author bibek
 */
public class MainClass {
    public static void main(String[] args) {
//        ArrayList<GraphNode> nodeArrayList = new ArrayList<>();
//        nodeArrayList.add(new GraphNode("a", 0));
//        nodeArrayList.add(new GraphNode("b", 1));
//        nodeArrayList.add(new GraphNode("c", 2));
//        nodeArrayList.add(new GraphNode("d", 3));
//        nodeArrayList.add(new GraphNode("e", 4));
//        Graph graph = new Graph(nodeArrayList);
//        graph.addUndirectedEdge(0, 1);
//        graph.addUndirectedEdge(0, 2);
//        graph.addUndirectedEdge(0, 3);
//        graph.addUndirectedEdge(1, 4);
//        graph.addUndirectedEdge(2, 3);
//        graph.addUndirectedEdge(3, 4);
//
//        System.out.println(graph.matrixToString());

//        graph.bfs();
//        graph.dfs();

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
        System.out.println(graph2.matrixToString());

        graph2.topologicalSort();

        ArrayList<GraphNode> nodeList3 = new ArrayList<>();
        nodeList3.add(new GraphNode("a", 0));
        nodeList3.add(new GraphNode("b", 1));
        nodeList3.add(new GraphNode("c", 2));
        nodeList3.add(new GraphNode("d", 3));
        nodeList3.add(new GraphNode("e", 4));
        nodeList3.add(new GraphNode("f", 5));
        nodeList3.add(new GraphNode("g", 6));
        nodeList3.add(new GraphNode("h", 7));
        Graph graph3 = new Graph(nodeList3);
        graph3.addUndirectedEdge(0, 1);
        graph3.addUndirectedEdge(0, 2);
        graph3.addUndirectedEdge(1, 3);
        graph3.addUndirectedEdge(1, 6);
        graph3.addUndirectedEdge(2, 3);
        graph3.addUndirectedEdge(2, 4);
        graph3.addUndirectedEdge(3, 5);
        graph3.addUndirectedEdge(4, 5);
        graph3.addUndirectedEdge(5, 6);
        System.out.println(graph3.matrixToString());
        graph3.bfsForSSSP(nodeList3.get(0));

    }
}
