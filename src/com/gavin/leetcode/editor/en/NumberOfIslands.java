package com.gavin.leetcode.editor.en;
/*2023-08-02 10:35:05*/
/**
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0
's (water), return the number of islands. 

 An island is surrounded by water and is formed by connecting adjacent lands 
horizontally or vertically. You may assume all four edges of the grid are all 
surrounded by water. 

 
 Example 1: 

 
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
 

 Example 2: 

 
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

 
 Constraints: 

 
 m == grid.length 
 n == grid[i].length 
 1 <= m, n <= 300 
 grid[i][j] is '0' or '1'. 
 

 Related Topics Array Depth-First Search Breadth-First Search Union Find Matrix 
👍 20701 👎 449

*/

public class NumberOfIslands{
    public static void main(String[] args){
        Solution solution = new NumberOfIslands().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int m, n;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int numOfIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0')
                {
                    dfs(grid, i, j);
                    // dfs return when island is explored
                    numOfIsland ++;
                }
            }
        }
        return numOfIsland;
    }

        private void dfs(char[][] grid, int row, int col) {
            if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0')
            {
                return;
            }
            grid[row][col] = '0';
            for (int [] d : directions)
            {
                dfs(grid, row + d[0], col + d[1]);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}