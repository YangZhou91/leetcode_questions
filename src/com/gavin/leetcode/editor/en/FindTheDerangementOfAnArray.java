package com.gavin.leetcode.editor.en;
/*2023-08-09 11:31:05*/
/**
In combinatorial mathematics, a derangement is a permutation of the elements of 
a set, such that no element appears in its original position. 

 You are given an integer n. There is originally an array consisting of n 
integers from 1 to n in ascending order, return the number of derangements it can 
generate. Since the answer may be huge, return it modulo 10⁹ + 7. 

 
 Example 1: 

 
Input: n = 3
Output: 2
Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] 
and [3,1,2].
 

 Example 2: 

 
Input: n = 2
Output: 1
 

 
 Constraints: 

 
 1 <= n <= 10⁶ 
 

 Related Topics Math Dynamic Programming 👍 212 👎 162

*/

public class FindTheDerangementOfAnArray{
    public static void main(String[] args){
        Solution solution = new FindTheDerangementOfAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findDerangement(int n) {

        if (n <= 1)
        {
            return 0;
        }

        long[] dp = new long[n + 1];
        long mod = 1000000007;
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
//            long temp = (long)(i - 1) * dp[i - 2] + (long) (i - 1) * dp[i - 1];
            dp[i] = ((i - 1) * dp[i - 2] + (i - 1) * dp[i - 1]) % mod;
            System.out.println(dp[i]);
        }
        return (int)dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}