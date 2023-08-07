package com.gavin.leetcode.editor.en;
/*2023-08-07 10:38:14*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given a collection of candidate numbers (candidates) and a target number (
target), find all unique combinations in candidates where the candidate numbers sum 
to target. 

 Each number in candidates may only be used once in the combination. 

 Note: The solution set must not contain duplicate combinations. 

 
 Example 1: 

 
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
 

 Example 2: 

 
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

 
 Constraints: 

 
 1 <= candidates.length <= 100 
 1 <= candidates[i] <= 50 
 1 <= target <= 30 
 

 Related Topics Array Backtracking 👍 9253 👎 230

*/

public class CombinationSumIi{
    public static void main(String[] args){
        Solution solution = new CombinationSumIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> combinations = new ArrayList<>();
            List<Integer> combinList = new ArrayList<>();

            backtracking(new ArrayList<>(), combinations, new boolean[candidates.length], 0, target, candidates);
            return combinations;
        }

        private void backtracking(List<Integer> tempCombination, List<List<Integer>> combinations, boolean[] hasVisited, int start, int target, final int[] candidates) {
            if (target == 0)
            {
                combinations.add(new ArrayList<>(tempCombination));
            }
            for (int i = start; i < candidates.length; i++) {
                if (i != 0 && candidates[i] == candidates[i - 1] && !hasVisited[i - 1])
                {
                    continue;
                }
                if (candidates[i] <= target)
                {
                    tempCombination.add(candidates[i]);
                    hasVisited[i] = true;
                    backtracking(tempCombination, combinations, hasVisited, i + 1, target - candidates[i], candidates);
                    hasVisited[i] = false;
                    tempCombination.remove(tempCombination.size() - 1);
                }
            }
        }
        }
//leetcode submit region end(Prohibit modification and deletion)

}