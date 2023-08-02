package com.gavin.leetcode.editor.en;
/*2023-08-02 15:25:25*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
There is an m x n rectangular island that borders both the Pacific Ocean and 
Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the 
Atlantic Ocean touches the island's right and bottom edges. 

 The island is partitioned into a grid of square cells. You are given an m x n 
integer matrix heights where heights[r][c] represents the height above sea level 
of the cell at coordinate (r, c). 

 The island receives a lot of rain, and the rain water can flow to neighboring 
cells directly north, south, east, and west if the neighboring cell's height is 
less than or equal to the current cell's height. Water can flow from any cell 
adjacent to an ocean into the ocean. 

 Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes 
that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic 
oceans. 

 
 Example 1: 
 
 
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
Explanation: The following cells can flow to the Pacific and Atlantic oceans, 
as shown below:
[0,4]: [0,4] -> Pacific Ocean 
       [0,4] -> Atlantic Ocean
[1,3]: [1,3] -> [0,3] -> Pacific Ocean 
       [1,3] -> [1,4] -> Atlantic Ocean
[1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
       [1,4] -> Atlantic Ocean
[2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
[3,0]: [3,0] -> Pacific Ocean 
       [3,0] -> [4,0] -> Atlantic Ocean
[3,1]: [3,1] -> [3,0] -> Pacific Ocean 
       [3,1] -> [4,1] -> Atlantic Ocean
[4,0]: [4,0] -> Pacific Ocean 
       [4,0] -> Atlantic Ocean
Note that there are other possible paths for these cells to flow to the Pacific 
and Atlantic oceans.
 

 Example 2: 

 
Input: heights = [[1]]
Output: [[0,0]]
Explanation: The water can flow from the only cell to the Pacific and Atlantic 
oceans.
 

 
 Constraints: 

 
 m == heights.length 
 n == heights[r].length 
 1 <= m, n <= 200 
 0 <= heights[r][c] <= 10⁵ 
 

 Related Topics Array Depth-First Search Breadth-First Search Matrix 👍 6704 👎 
1290

*/

public class PacificAtlanticWaterFlow{
    public static void main(String[] args){
        Solution solution = new PacificAtlanticWaterFlow().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        private int m, n;
        private int[][] directions = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        m = heights.length;
        n = heights[0].length;

        boolean[][] canReachPacific = new boolean[m][n];
        boolean[][] canReachAtlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            // Pacific is on the left
            dfs(i, 0, heights, canReachPacific);
            dfs(i, n-1, heights, canReachAtlantic);
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i, heights, canReachPacific);
            dfs(m-1, i, heights, canReachAtlantic);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j])
                {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

        private void dfs(int row, int col, int[][] heights, boolean[][] canReach) {
            if (canReach[row][col])
            {
                return;
            }
            canReach[row][col] = true;
            for (int[] direction : directions)
            {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n
                        || heights[row][col] > heights[nextRow][nextCol])
                {
                    continue;
                }
                dfs(nextRow, nextCol, heights, canReach);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}