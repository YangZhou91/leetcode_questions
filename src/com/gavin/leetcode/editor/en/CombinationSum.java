package com.gavin.leetcode.editor.en;
/*2023-08-03 17:11:45*/

import java.util.ArrayList;
import java.util.List;

/**
Given an array of distinct integers candidates and a target integer target, 
return a list of all unique combinations of candidates where the chosen numbers sum 
to target. You may return the combinations in any order. 

 The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers 
is different. 

 The test cases are generated such that the number of unique combinations that 
sum up to target is less than 150 combinations for the given input. 

 
 Example 1: 

 
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple 
times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
 

 Example 2: 

 
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
 

 Example 3: 

 
Input: candidates = [2], target = 1
Output: []
 

 
 Constraints: 

 
 1 <= candidates.length <= 30 
 2 <= candidates[i] <= 40 
 All elements of candidates are distinct. 
 1 <= target <= 40 
 

 Related Topics Array Backtracking 👍 16910 👎 342

*/

public class CombinationSum{
    public static void main(String[] args){
        Solution solution = new CombinationSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> combinationList = new ArrayList<>();
        
        backtracking(combinations, combinationList, 0, target, candidates);
        return combinations;
    }

        private void backtracking(List<List<Integer>> combinations, List<Integer> combinationList, int start, int target, int[] candidates) {
            if (target == 0)
            {
                combinations.add(new ArrayList<>(combinationList));
                return;
            }
            for (int i = start; i < candidates.length ; i++) {
                if (candidates[i] <= target)
                {
                    combinationList.add(candidates[i]);
                    backtracking(combinations, combinationList, i, target - candidates[i], candidates);
                    combinationList.remove(combinationList.size() - 1);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}