package com.github.bibek77.dsa.dataStructures.graph.graphList;

import java.util.ArrayList;

/**
 * @author bibek
 */
public class Graph {

    ArrayList<GraphNode> nodeList = new ArrayList<>();

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public String listToString() {
        StringBuilder s = new StringBuilder();
        for(int i=0;i<nodeList.size();i++) {
            s.append(nodeList.get(i).name + ": ");
            for(int j=0; j<nodeList.get(i).neighbours.size();j++) {
                if(j==nodeList.get(i).neighbours.size()-1) {
                    s.append(nodeList.get(i).neighbours.get(j).name);
                } else {
                    s.append((nodeList.get(i).neighbours.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
