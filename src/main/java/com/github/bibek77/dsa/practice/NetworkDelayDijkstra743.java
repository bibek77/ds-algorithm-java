package com.github.bibek77.dsa.practice;

import java.util.*;

/**
 * @author bibek
 */
public class NetworkDelayDijkstra743 {
    //Dijkstra AlG
    // O(N*E)
    public int networkDelayTimeDjK(int[][] times, int n, int k) {
        //Map for u, v nodes and w weight for u to v
        // u <- {v, w}
        // for u can be multiple adj nodes so use List
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // Fill all minDistance with a larger value as Infinity
        // MinDistance size is n+1, as 0th index node will be unused.
        int[] minDistance = new int[n + 1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        //Priority queue add in order of ascending distance a[0]
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        //K is the starting node, so distance from starting node to starting node is 0
        minDistance[k] = 0;
        //Add starting node and distance to queue as starting point
        queue.add(new int[]{minDistance[k], k});

        //Max is the result var where we keep the total minimum time to traverse all nodes
        int max = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNode = curr[1];
            int currDist = curr[0];
            // curr[1] is v node, curr[0] is the weight or time

            if (currDist > minDistance[currNode])
                continue;
            //if currDist is greater than we will not take the path hence coninue loop
            max = currDist;
            n--;
            //n to keep track that we traverse all the nodes/source nodes (u)

            // graph will containKey only is adj nodes of u exists or path from u exists
            if (graph.containsKey(currNode)) {
                // loop for all the adjacent nodes of u
                for (int[] adj : graph.get(currNode)) {
                    // update minDistance only if total distance (curr + adjacent) is less
                    if (currDist + adj[1] < minDistance[adj[0]]) {
                        queue.add(new int[]{currDist + adj[1], adj[0]});
                        minDistance[adj[0]] = currDist + adj[1];
                    }
                }
            }
        }
        //if all nodes are covered then n will be 0 we can return max else return -1
        return n == 0 ? max : -1;

    }

    //Bellman Ford ALG0 - works with -ve values, but no -ve cycles.
    // O(N+ E log E )
    public int networkDelayTimeBF(int[][] times, int n, int k) {

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k - 1] = 0;

        for (int i = 1; i < n; i++) {
            for (int[] edges : times) {
                int u = edges[0] - 1, v = edges[1] - 1, w = edges[2];
                if (distance[u] == Integer.MAX_VALUE)
                    continue;
                // Condition is nessesary, else MAAX_VALUE + weight will become a min value and result becomes -ve.
                distance[v] = Math.min(distance[v], distance[u] + w);
            }
        }

        int res = Integer.MIN_VALUE;
        for (int w : distance) {
            res = Math.max(res, w);
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;

    }
}
