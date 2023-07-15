package com.github.bibek77.dsa.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bibek
 */
public class NumberOfIslands200 {
    public static void main(String[] args) {

        char[][] grid = {{'1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        if(grid.length==0)
            System.out.println(0);

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int islands = 0;
        for(int i=0;i<m;i++) {
            for(int j=0; j<n;j++) {
                if(grid[i][j]=='1' && !visited[i][j]) {
                    grid[i][j]='0';
                    // visited[i][j] = true;

                    islands++;

                    queue.add(new int[]{i,j});

                    while(!queue.isEmpty()) {
                        int[] curr = queue.remove();

                        for(int[] currDir : dir) {
                            int nextx = curr[0] + currDir[0];
                            int nexty = curr[1] + currDir[1];

                            if(nextx<0 || nexty<0 || nextx>=m || nexty>=n || grid[nextx][nexty]=='0' ) {
                                continue;
                            }
                            queue.add(new int[]{nextx, nexty});
                            grid[nextx][nexty] = '0';
                            // visited[nextx][nexty] = true;
                        }
                    }
                }
            }
        }
        System.out.println(islands);
    }

    // Using BFS
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]=='1') {
                    count+=1;
                    callBfs(grid, i, j);

                }
            }
        }
        return count;
    }

    public void callBfs(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>= grid[i].length || grid[i][j]=='0')
            return;
        grid[i][j]='0';
        callBfs(grid, i+1, j);
        callBfs(grid, i-1, j);
        callBfs(grid, i, j-1);
        callBfs(grid, i, j+1);
    }
}
