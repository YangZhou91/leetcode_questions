package com.gavin.leetcode.editor.en;
/*2023-07-24 23:32:14*/
/**
Given a non-negative integer c, decide whether there're two integers a and b 
such that a² + b² = c. 

 
 Example 1: 

 
Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
 

 Example 2: 

 
Input: c = 3
Output: false
 

 
 Constraints: 

 
 0 <= c <= 2³¹ - 1 
 

 Related Topics Math Two Pointers Binary Search 👍 2287 👎 527

*/

public class SumOfSquareNumbers{
    public static void main(String[] args){
        Solution solution = new SumOfSquareNumbers().new Solution();
        System.out.println(solution.judgeSquareSum(2147483600));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeSquareSum(int c) {

        long i = 0;
        long j = (int)(Math.sqrt(c));
        while(i <= j){
            long powSum = i * i + j * j;
            if (powSum == c){
                return true;
            } else if (powSum > c) {
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

