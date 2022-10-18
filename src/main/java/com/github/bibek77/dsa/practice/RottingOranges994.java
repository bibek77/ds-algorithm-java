package com.github.bibek77.dsa.practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bibek
 */
public class RottingOranges994 {
    public int orangesRotting(int[][] grid) {
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        int rotten = 0;
        int fresh = 0;
        int empty = 0;

        if(grid.length==0)
            return 0;

        Queue<int[]> queue = new LinkedList<>();

        for(int row=0; row<grid.length;row++) {
            for(int col=0; col<grid[0].length;col++) {
                if(grid[row][col]==2) {
                    queue.add(new int[]{row, col});
                }
                if(grid[row][col]==1) {
                    fresh++;
                }
            }
        }
//         if(queue.size()==0 && fresh!=0)
//             return -1;

//         if(queue.size()==0 || fresh==0)
//             return 0;

        int len = queue.size();
        int minutes = 0;
        while(queue.size()>0) {
            if(len==0) {
                minutes++;
                len = queue.size();
            }
            int[] curr = queue.remove();
            len--;

            int currx = curr[0];
            int curry = curr[1];

            for(int[] currDir : dir) {
                int nextx = currx + currDir[0];
                int nexty = curry + currDir[1];

                if(nextx<0 || nexty<0 || nextx>=grid.length || nexty>=grid[0].length) {
                    continue;
                }
                if(grid[nextx][nexty] == 1) {
                    fresh--;
                    queue.add(new int[]{nextx, nexty});
                    grid[nextx][nexty] = 2;
                }

            }
        }
        return fresh != 0 ? -1 : minutes;
    }
}
