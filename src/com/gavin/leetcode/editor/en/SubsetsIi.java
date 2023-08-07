package com.gavin.leetcode.editor.en;
/*2023-08-07 14:37:42*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given an integer array nums that may contain duplicates, return all possible 
subsets (the power set). 

 The solution set must not contain duplicate subsets. Return the solution in 
any order. 

 
 Example 1: 
 Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 
 Example 2: 
 Input: nums = [0]
Output: [[],[0]]
 
 
 Constraints: 

 
 1 <= nums.length <= 10 
 -10 <= nums[i] <= 10 
 

 Related Topics Array Backtracking Bit Manipulation 👍 8730 👎 245

*/

public class SubsetsIi{
    public static void main(String[] args){
        Solution solution = new SubsetsIi().new Solution();
        solution.subsetsWithDup(new int[]{4,4,4,1,4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubset = new ArrayList<>();
        boolean[] hasVisited = new boolean[nums.length];

        for (int size = 0; size <= nums.length; size++) {
            backtracking(tempSubset, subsets, nums, hasVisited, 0, size);
        }

        return subsets;
    }

        private void backtracking(List<Integer> tempSubset, List<List<Integer>> subsets, int[] nums, boolean[] hasVisited, int start, final int size) {
            if (tempSubset.size() == size)
            {
                subsets.add(new ArrayList<>(tempSubset));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1])
                {
                    continue;
                }
                tempSubset.add(nums[i]);
                hasVisited[i] = true;
                backtracking(tempSubset, subsets, nums, hasVisited, i + 1, size);
                hasVisited[i] = false;
                tempSubset.remove(tempSubset.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}