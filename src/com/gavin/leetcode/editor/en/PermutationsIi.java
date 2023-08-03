package com.gavin.leetcode.editor.en;
/*2023-08-03 15:30:10*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given a collection of numbers, nums, that might contain duplicates, return all 
possible unique permutations in any order. 

 
 Example 1: 

 
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 

 Example 2: 

 
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

 
 Constraints: 

 
 1 <= nums.length <= 8 
 -10 <= nums[i] <= 10 
 

 Related Topics Array Backtracking 👍 7881 👎 136

*/

public class PermutationsIi{
    public static void main(String[] args){
        Solution solution = new PermutationsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> permuteList = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] hasVisited = new boolean[nums.length];
        backtracking(permuteList, permutes, hasVisited, nums);
        return permutes;
    }

    private void backtracking(List<Integer> permuteList, List<List<Integer>> permutes, boolean[] hasVisited, int[] nums)
    {
        if (permuteList.size() == nums.length){
            permutes.add(new ArrayList<>(permuteList));
            return;
        }

        for (int i = 0; i < hasVisited.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !hasVisited[i - 1]) {
                continue;
            }
            if (hasVisited[i]){
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