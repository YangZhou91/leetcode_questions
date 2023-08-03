package com.gavin.leetcode.editor.en;
/*2023-08-03 16:48:55*/

import java.util.ArrayList;
import java.util.List;

/**
Given two integers n and k, return all possible combinations of k numbers 
chosen from the range [1, n]. 

 You may return the answer in any order. 

 
 Example 1: 

 
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to 
be the same combination.
 

 Example 2: 

 
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

 
 Constraints: 

 
 1 <= n <= 20 
 1 <= k <= n 
 

 Related Topics Backtracking 👍 7470 👎 205

*/

public class Combinations{
    public static void main(String[] args){
        Solution solution = new Combinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> combinations = new ArrayList<>();
            List<Integer> combineList = new ArrayList<>();
            backtracking(combinations, combineList, 1, k, n);
            return combinations;
        }

        private void backtracking(List<List<Integer>> combinations, List<Integer> combineList, int start, int k, int n) {

            if (k == 0)
            {
                combinations.add(new ArrayList<>(combineList));
                return;
            }
            for (int i = start; i <= n - k + 1; i++) {
                combineList.add(i);
                backtracking(combinations, combineList, i + 1,  k - 1, n);
                combineList.remove(combineList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}