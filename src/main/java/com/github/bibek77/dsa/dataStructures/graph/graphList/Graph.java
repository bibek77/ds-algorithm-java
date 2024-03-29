package com.github.bibek77.dsa.dataStructures.graph.graphList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author bibek
 */
public class Graph {

    ArrayList<GraphNode> nodeList;

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
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbours.size(); j++) {
                if (j == nodeList.get(i).neighbours.size() - 1) {
                    s.append(nodeList.get(i).neighbours.get(j).name);
                } else {
                    s.append((nodeList.get(i).neighbours.get(j).name) + " -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    // BFS Visit helper
    public void bfsVisit(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            GraphNode currNode = queue.remove();
            currNode.isVisited = true;
            System.out.print(currNode.name + " ");
            for (GraphNode neighbour : currNode.neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    // BFS main
    public void bfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
    }

    // DFS visit
    public void dsfVisit(GraphNode node) {
        Stack<GraphNode> stk = new Stack<>();
        stk.push(node);
        while (!stk.empty()) {
            GraphNode currNode = stk.pop();
            currNode.isVisited = true;
            System.out.print(currNode.name + " ");
            for (GraphNode neighbour : currNode.neighbours) {
                if (!neighbour.isVisited) {
                    stk.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    //dfs main
    void dfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                dsfVisit(node);
            }
        }
    }

    //-----Topological Sort Implementation-----//
    public void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
    }

    //helper for topological
    public void topologicalVisit(GraphNode node, Stack<GraphNode> stk) {
        for (GraphNode neighbour : node.neighbours) {
            if (!neighbour.isVisited) {
                topologicalVisit(neighbour, stk);
            }
        }
        node.isVisited = true;
        stk.push(node);
    }

    public void topologicalSort() {
        Stack<GraphNode> stk = new Stack<>();
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                topologicalVisit(node, stk);
            }
        }
        while (!stk.empty()) {
            System.out.print(stk.pop().name + " ");
        }
    }

    public static void pathPrint(GraphNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    public void bfsSSSP(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currNode = queue.remove();
            currNode.isVisited = true;
            System.out.print("Printing Path for node : " + currNode.name + " : ");
            pathPrint(currNode);
            System.out.println();
            for(GraphNode neighbour : currNode.neighbours) {
                if(!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                    neighbour.parent = currNode;
                }
            }

        }
    }

}
