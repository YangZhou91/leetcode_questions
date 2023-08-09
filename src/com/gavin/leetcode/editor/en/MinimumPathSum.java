package com.gavin.leetcode.editor.en;
/*2023-08-09 16:44:58*/
/**
Given a m x n grid filled with non-negative numbers, find a path from top left 
to bottom right, which minimizes the sum of all numbers along its path. 

 Note: You can only move either down or right at any point in time. 

 
 Example 1: 
 
 
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 

 Example 2: 

 
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 

 
 Constraints: 

 
 m == grid.length 
 n == grid[i].length 
 1 <= m, n <= 200 
 0 <= grid[i][j] <= 200 
 

 Related Topics Array Dynamic Programming Matrix 👍 11420 👎 147

*/

public class MinimumPathSum{
    public static void main(String[] args){
        Solution solution = new MinimumPathSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}