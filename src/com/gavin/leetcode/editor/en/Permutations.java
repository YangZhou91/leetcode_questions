package com.gavin.leetcode.editor.en;
/*2023-08-03 15:09:17*/

import java.util.ArrayList;
import java.util.List;

/**
Given an array nums of distinct integers, return all the possible permutations. 
You can return the answer in any order. 

 
 Example 1: 
 Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 
 Example 2: 
 Input: nums = [0,1]
Output: [[0,1],[1,0]]
 
 Example 3: 
 Input: nums = [1]
Output: [[1]]
 
 
 Constraints: 

 
 1 <= nums.length <= 6 
 -10 <= nums[i] <= 10 
 All the integers of nums are unique. 
 

 Related Topics Array Backtracking 👍 17317 👎 276

*/

public class Permutations{
    public static void main(String[] args){
        Solution solution = new Permutations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> permutes = new ArrayList<>();
            List<Integer> permuteList = new ArrayList<>();
            boolean[] hasVisited = new boolean[nums.length];
            backtracking(permuteList, permutes, hasVisited, nums);
            return permutes;
        }

        private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] hasVisited, int[] nums) {
            if (permuteList.size() == nums.length) {
                permutes.add(new ArrayList<>(permuteList));
            }
            for (int i = 0; i < hasVisited.length; i++) {
                if (hasVisited[i]) {
                    continue;
                }
                hasVisited[i] = true;
                permuteList.add(nums[i]);
                backtracking(permuteList, permutes, hasVisited, nums);
                permuteList.remove(permuteList.size() - 1);
                hasVisited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}