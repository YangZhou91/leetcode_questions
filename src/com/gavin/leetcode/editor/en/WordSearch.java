package com.gavin.leetcode.editor.en;
/*2023-08-03 11:11:32*/
/**
Given an m x n grid of characters board and a string word, return true if word 
exists in the grid. 

 The word can be constructed from letters of sequentially adjacent cells, where 
adjacent cells are horizontally or vertically neighboring. The same letter cell 
may not be used more than once. 

 
 Example 1: 
 
 
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"ABCCED"
Output: true
 

 Example 2: 
 
 
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"SEE"
Output: true
 

 Example 3: 
 
 
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
"ABCB"
Output: false
 

 
 Constraints: 

 
 m == board.length 
 n = board[i].length 
 1 <= m, n <= 6 
 1 <= word.length <= 15 
 board and word consists of only lowercase and uppercase English letters. 
 

 
 Follow up: Could you use search pruning to make your solution faster with a 
larger board? 

 Related Topics Array Backtracking Matrix 👍 13969 👎 572

*/

public class WordSearch{
    public static void main(String[] args){
        Solution solution = new WordSearch().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        private int m;
        private int n;

        public boolean exist(char[][] board, String word) {

            if (board == null || board.length == 0 || board[0].length == 0)
            {
                return false;
            }
            m = board.length;
            n = board[0].length;
            boolean[][] hasVisited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (backtracking(0, i, j, hasVisited, board, word))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backtracking(int curLen, int r, int c, boolean[][] visited, final char[][] board, final String word) {
            if (curLen == word.length()) {
                return true;
            }
            if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != word.charAt(curLen) || visited[r][c]) {
                return false;
            }
            visited[r][c] = true;

            for (int[] direction : directions) {
                if (backtracking(curLen + 1, r + direction[0], c + direction[1], visited, board, word)) {
                    return true;
                }
            }
            visited[r][c] = false;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}