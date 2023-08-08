package com.gavin.leetcode.editor.en;
/*2023-08-08 15:29:49*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
The n-queens puzzle is the problem of placing n queens on an n x n chessboard 
such that no two queens attack each other. 

 Given an integer n, return all distinct solutions to the n-queens puzzle. You 
may return the answer in any order. 

 Each solution contains a distinct board configuration of the n-queens' 
placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. 

 
 Example 1: 
 
 
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown 
above
 

 Example 2: 

 
Input: n = 1
Output: [["Q"]]
 

 
 Constraints: 

 
 1 <= n <= 9 
 

 Related Topics Array Backtracking 👍 10945 👎 233

*/

public class NQueens{
    public static void main(String[] args){
        Solution solution = new NQueens().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private List<List<String>> solutions;
        private char[][] nQueens;
        private boolean[] colUsed;
        private boolean[] diagonals45Used;
        private boolean[] diagonals135Used;
        private int n;

    public List<List<String>> solveNQueens(int n) {
        solutions = new ArrayList<>();
        nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }
        colUsed = new boolean[n];
        diagonals45Used = new boolean[2*n - 1];
        diagonals135Used = new boolean[2*n - 1];
        this.n = n;
        backtracking(0);
        return solutions;
    }

        private void backtracking(int row) {
            if (row == n)
            {
                List<String> list = new ArrayList<>();
                for (char[] chars : nQueens){
                    list.add(new String(chars));
                }
                solutions.add(list);
                return;
            }

            for (int col = 0; col < n; col++) {
                int diagonals45Idx = row + col;
                int diagonals135Idx = n - 1 - (row - col);
                if (colUsed[col] || diagonals45Used[diagonals45Idx] || diagonals135Used[diagonals135Idx])
                {
                    continue;
                }
                nQueens[row][col] = 'Q';
                colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = true;
                backtracking(row + 1);
                colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = false;
                nQueens[row][col] = '.';
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}