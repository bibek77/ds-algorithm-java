package com.github.bibek77.dsa.dataStructures.graph.graphMatrix;

/**
 * @author bibek
 */
public class GraphNode {
    public String name;
    public int index;
    public boolean isVisted;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
        this.isVisted = false;
    }

}
