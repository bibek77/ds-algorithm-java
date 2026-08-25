package com.github.bibek77.dsa.leetcode;

/**
 * @author bibek
 */
public class Lc547NumberOfProvinces {
    static class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            UnionFind uf = new UnionFind(n);
            int provinces = n; // Start assuming every city is its own province

            // We only need to check the upper triangle of the matrix
            // because connections are bidirectional (if A is connected to B, B is to A).
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isConnected[i][j] == 1) {
                        // If we successfully merge two separate provinces,
                        // the total number of provinces decreases by 1.
                        if (uf.union(i, j)) {
                            provinces--;
                        }
                    }
                }
            }

            return provinces;
        }

        // Standard Union-Find class
        class UnionFind {
            private int[] parent;
            private int[] rank;

            public UnionFind(int size) {
                parent = new int[size];
                rank = new int[size];
                for (int i = 0; i < size; i++) {
                    parent[i] = i;
                    rank[i] = 1;
                }
            }

            public int find(int i) {
                if (parent[i] == i) return i;
                return parent[i] = find(parent[i]); // Path compression
            }

            // Changed to boolean to let us know if a merge actually happened
            public boolean union(int i, int j) {
                int rootI = find(i);
                int rootJ = find(j);

                if (rootI != rootJ) {
                    if (rank[rootI] > rank[rootJ]) {
                        parent[rootJ] = rootI;
                    } else if (rank[rootI] < rank[rootJ]) {
                        parent[rootI] = rootJ;
                    } else {
                        parent[rootJ] = rootI;
                        rank[rootI]++;
                    }
                    return true; // Successfully merged two sets
                }
                return false; // They were already in the same set
            }
        }
    }
}
