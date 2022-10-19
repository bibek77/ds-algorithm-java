package com.github.bibek77.dsa.dataStructures.graph.graphList;

import java.util.ArrayList;

/**
 * @author bibek
 */
public class GraphNode {
    public String name;
    public int index;

    public ArrayList<GraphNode> neighbours = new ArrayList<>();

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
