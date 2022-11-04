package com.github.bibek77.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bibek
 */
public class BfsKahnAlgorithm {

    public int[] bfsKahnAlgorithm(int nodes, ArrayList<ArrayList<Integer>> adjacent) {
        int[] topoSorted = new int[nodes];
        int[] inDegree = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            for (int adjNode : adjacent.get(i)) {
                //Adding inDegree for all the adjacent nodes of the current Node i
                inDegree[adjNode]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        //If inDegree is 0 for any node, it can be used as starting node.
        for (int i = 0; i < nodes; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int iterate = 0;
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            topoSorted[iterate++] = currNode;
            for (int adjNode : adjacent.get(currNode)) {
                inDegree[adjNode]--;
                if (inDegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }

        return topoSorted;
    }
}
