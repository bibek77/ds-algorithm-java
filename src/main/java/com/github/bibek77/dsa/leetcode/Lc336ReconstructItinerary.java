package com.github.bibek77.dsa.leetcode;

import java.util.*;

/**
 * @author bibek
 */
public class Lc336ReconstructItinerary {
    static class Solution {
        // eulerian path - dfs
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, PriorityQueue<String>> adjMap = new HashMap<>();

            // Graph building remains exactly the same
            for (List<String> routes : tickets) {
                String u = routes.get(0);
                String v = routes.get(1);
                if (!adjMap.containsKey(u)) {
                    adjMap.put(u, new PriorityQueue<>());
                }
                adjMap.get(u).add(v);
            }

            // Change 1: Use a Stack for DFS instead of a Queue
            Stack<String> stack = new Stack<>();
            stack.push("JFK");

            // Change 2: Use a LinkedList so we can efficiently insert at the front
            LinkedList<String> result = new LinkedList<>();

            while (!stack.isEmpty()) {
                String node = stack.peek();

                // If the current airport has unvisited outgoing flights, go to the next one
                if (adjMap.containsKey(node) && !adjMap.get(node).isEmpty()) {
                    stack.push(adjMap.get(node).poll());
                } else {
                    // If we reach a dead end, backtrack and add to the front of our result
                    result.addFirst(stack.pop());
                }
            }

            return result;
        }
    }
}
