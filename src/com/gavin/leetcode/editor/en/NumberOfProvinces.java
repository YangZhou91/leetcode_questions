package com.gavin.leetcode.editor.en;
/*2023-08-02 11:16:21*/
/**
There are n cities. Some of them are connected, while some are not. If city a 
is connected directly with city b, and city b is connected directly with city c, 
then city a is connected indirectly with city c. 

 A province is a group of directly or indirectly connected cities and no other 
cities outside of the group. 

 You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the iᵗ
ʰ city and the jᵗʰ city are directly connected, and isConnected[i][j] = 0 
otherwise. 

 Return the total number of provinces. 

 
 Example 1: 
 
 
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2
 

 Example 2: 
 
 
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 

 
 Constraints: 

 
 1 <= n <= 200 
 n == isConnected.length 
 n == isConnected[i].length 
 isConnected[i][j] is 1 or 0. 
 isConnected[i][i] == 1 
 isConnected[i][j] == isConnected[j][i] 
 

 Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 8674
 👎 320

*/

public class NumberOfProvinces{
    public static void main(String[] args){
        Solution solution = new NumberOfProvinces().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int n = 0;
        int numOfProvinces = 0;
        public int findCircleNum(int[][] isConnected) {
            n = isConnected.length;
            boolean[] hasVisited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!hasVisited[i])
                {
                    dfs(isConnected, i, hasVisited);
                    numOfProvinces++;
                }
            }
            return numOfProvinces;
        }

        private void dfs(int[][] isConnected, int row, boolean[] hasVisited) {
            hasVisited[row] = true;
            for (int i = 0; i < n; i++) {
                if (isConnected[row][i] == 1 && !hasVisited[i]) {
                    dfs(isConnected, i, hasVisited);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}