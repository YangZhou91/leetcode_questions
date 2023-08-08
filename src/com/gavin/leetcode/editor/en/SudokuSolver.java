package com.gavin.leetcode.editor.en;
/*2023-08-08 10:18:47*/
/**
Write a program to solve a Sudoku puzzle by filling the empty cells. 

 A sudoku solution must satisfy all of the following rules: 

 
 Each of the digits 1-9 must occur exactly once in each row. 
 Each of the digits 1-9 must occur exactly once in each column. 
 Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes 
of the grid. 
 

 The '.' character indicates empty cells. 

 
 Example 1: 
 
 
Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",
".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",
".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".",
"6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4",
"8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"]
,["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9
","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4
","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is 
shown below:
 



 
 Constraints: 

 
 board.length == 9 
 board[i].length == 9 
 board[i][j] is a digit or '.'. 
 It is guaranteed that the input board has only one solution. 
 

 Related Topics Array Hash Table Backtracking Matrix 👍 8522 👎 220

*/

public class SudokuSolver{
    public static void main(String[] args){
        Solution solution = new SudokuSolver().new Solution();
        solution.solveSudoku(new char[][]
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                });
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private boolean[][] rowsUsed = new boolean[9][10];
        private boolean[][] colsUsed = new boolean[9][10];
        private boolean[][] cubesUsed = new boolean[9][10];
        private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                {
                   continue;
                }
                int num = board[i][j] - '0';
                rowsUsed[i][num] = true;
                colsUsed[j][num] = true;
                cubesUsed[subBoxNum(i, j)][num] = true;
            }
        }
        backtracking(0, 0);
    }

        private boolean backtracking(int row, int col) {
            while(row < 9 && board[row][col] != '.')
            {
                row = col == 8 ? row + 1 : row;
                col = col == 8 ? 0 : col + 1;
            }
            if (row == 9)
            {
                return true;
            }
            for (int num = 1; num <= 9; num++) {
                if (rowsUsed[row][num] || colsUsed[col][num] || cubesUsed[subBoxNum(row, col)][num]) {
                    continue;
                }
                rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[subBoxNum(row, col)][num] = true;
                board[row][col] = (char) (num + '0');
                if (backtracking(row, col)) {
                    return true;
                }
                board[row][col] = '.';
                rowsUsed[row][num] = colsUsed[col][num] = cubesUsed[subBoxNum(row, col)][num] = false;
            }
            return false;
        }

        // sub cube index?
        private int subBoxNum(int i, int j) {
            int row = i / 3;
            int col = j / 3;
//            System.out.println("cubeNum: " + (row * 3 + col));
            return row * 3 + col;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}