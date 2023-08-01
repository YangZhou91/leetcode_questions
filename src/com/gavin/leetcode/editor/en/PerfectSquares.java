package com.gavin.leetcode.editor.en;
/*2023-08-01 15:30:17*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
Given an integer n, return the least number of perfect square numbers that sum 
to n. 

 A perfect square is an integer that is the square of an integer; in other 
words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
are perfect squares while 3 and 11 are not. 

 
 Example 1: 

 
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
 

 Example 2: 

 
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

 
 Constraints: 

 
 1 <= n <= 10⁴ 
 

 Related Topics Math Dynamic Programming Breadth-First Search 👍 9782 👎 411

*/

public class PerfectSquares{
    public static void main(String[] args){
        Solution solution = new PerfectSquares().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            level ++;
            while (size-- > 0)
            {
                int cur = queue.poll();
                for (int s : squares)
                {
                    int next = cur - s;
                    if (next < 0){
                        break;
                    }
                    if (next == 0){
                        return level;
                    }
                    if (marked[next])
                    {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return level;
    }

    private List<Integer> generateSquares(int n )
    {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while(square <= n)
        {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}