package com.gavin.leetcode.editor.en;
/*2023-08-07 11:05:15*/

import java.util.ArrayList;
import java.util.List;

/**
Given an integer array nums of unique elements, return all possible subsets (
the power set). 

 The solution set must not contain duplicate subsets. Return the solution in 
any order. 

 
 Example 1: 

 
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 

 Example 2: 

 
Input: nums = [0]
Output: [[],[0]]
 

 
 Constraints: 

 
 1 <= nums.length <= 10 
 -10 <= nums[i] <= 10 
 All the numbers of nums are unique. 
 

 Related Topics Array Backtracking Bit Manipulation 👍 15343 👎 223

*/

public class Subsets{
    public static void main(String[] args){
        Solution solution = new Subsets().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> tempSubsets = new ArrayList<>();

        for (int i = 0; i <= nums.length; i++) {
            backtracking(subsets, tempSubsets, nums, 0, i);
        }
        return subsets;
    }

        private void backtracking(List<List<Integer>> subsets, List<Integer> tempSubset, int[] nums, int start, int size) {
            if (tempSubset.size() == size)
            {
                subsets.add(new ArrayList<>(tempSubset));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                tempSubset.add(nums[i]);
                backtracking(subsets, tempSubset, nums, i + 1, size);
                tempSubset.remove(tempSubset.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}