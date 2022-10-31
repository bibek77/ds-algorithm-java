package com.github.bibek77.dsa.dataStructures.graph.graphMatrix;

/**
 * @author bibek
 */
public class GraphNode {
    public String name;
    public int index;
    public boolean isVisited;
    GraphNode parent;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
        this.isVisited = false;
    }

}
