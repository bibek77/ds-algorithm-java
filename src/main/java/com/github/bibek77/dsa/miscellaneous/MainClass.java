package com.github.bibek77.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author bibek
 */
public class MainClass {
    public static void main(String[] args) {
        MatrixDFS matrixDFS = new MatrixDFS();

        System.out.println();
        BfsKahnAlgorithm bfsKahnAlgorithm = new BfsKahnAlgorithm();
        int nodes = 6;
        ArrayList<Integer> adjNodes = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>());
        adjList.add(new ArrayList<>());
        adjNodes.add(3);
        adjList.add(adjNodes);
        adjNodes = new ArrayList<>();
        adjNodes.add(1);
        adjList.add(adjNodes);
        adjNodes = new ArrayList<>();
        adjNodes.add(0);
        adjNodes.add(1);
        adjList.add(adjNodes);
        adjNodes = new ArrayList<>();
        adjNodes.add(0);
        adjNodes.add(2);
        adjList.add(adjNodes);
        int[] topologicalSort = bfsKahnAlgorithm.bfsKahnAlgorithm(nodes, adjList);
        System.out.println(Arrays.toString(topologicalSort));
    }
}
