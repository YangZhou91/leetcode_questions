package com.gavin.leetcode.editor.en;
/*2023-08-10 16:43:53*/

import java.util.Arrays;

/**
You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and 
lefti < righti. 

 A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can 
be formed in this fashion. 

 Return the length longest chain which can be formed. 

 You do not need to use up all the given intervals. You can select pairs in any 
order. 

 
 Example 1: 

 
Input: pairs = [[1,2],[2,3],[3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4].
 

 Example 2: 

 
Input: pairs = [[1,2],[7,8],[4,5]]
Output: 3
Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
 

 
 Constraints: 

 
 n == pairs.length 
 1 <= n <= 1000 
 -1000 <= lefti < righti <= 1000 
 

 Related Topics Array Dynamic Programming Greedy Sorting 👍 3160 👎 115

*/

public class MaximumLengthOfPairChain{
    public static void main(String[] args){
        Solution solution = new MaximumLengthOfPairChain().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b)->(a[0] - b[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0])
                {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}