package com.gavin.leetcode.editor.en;
/*2023-08-01 10:58:34*/

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
Given an n x n binary matrix grid, return the length of the shortest clear path 
in the matrix. If there is no clear path, return -1. 

 A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0))
 to the bottom-right cell (i.e., (n - 1, n - 1)) such that: 

 
 All the visited cells of the path are 0. 
 All the adjacent cells of the path are 8-directionally connected (i.e., they 
are different and they share an edge or a corner). 
 

 The length of a clear path is the number of visited cells of this path. 

 
 Example 1: 
 
 
Input: grid = [[0,1],[1,0]]
Output: 2
 

 Example 2: 
 
 
Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
 

 Example 3: 

 
Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

 
 Constraints: 

 
 n == grid.length 
 n == grid[i].length 
 1 <= n <= 100 
 grid[i][j] is 0 or 1 
 

 Related Topics Array Breadth-First Search Matrix 👍 5851 👎 205

*/

public class ShortestPathInBinaryMatrix{
    public static void main(String[] args){
        Solution solution = new ShortestPathInBinaryMatrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            pathLength ++;
            while (size -- > 0)
            {
                Pair<Integer, Integer> cur = queue.poll();
                // row, column
                int cr = cur.getKey(), cc = cur.getValue();
                // block
                if (grid[cr][cc] == 1)
                {
                    continue;
                }
                if (cr == m - 1 && cc == n - 1)
                {
                    // reach to the end
                    return pathLength;
                }
                grid[cr][cc] = 1; // mark as visited
                for (int[] d : direction)
                {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}