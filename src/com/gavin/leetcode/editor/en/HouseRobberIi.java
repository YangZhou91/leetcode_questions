package com.gavin.leetcode.editor.en;
/*2023-08-09 10:10:05*/

import java.util.Arrays;

/**
You are a professional robber planning to rob houses along a street. Each house 
has a certain amount of money stashed. All houses at this place are arranged in 
a circle. That means the first house is the neighbor of the last one. Meanwhile,
 adjacent houses have a security system connected, and it will automatically 
contact the police if two adjacent houses were broken into on the same night. 

 Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.
 

 
 Example 1: 

 
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2)
, because they are adjacent houses.
 

 Example 2: 

 
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 

 Example 3: 

 
Input: nums = [1,2,3]
Output: 3
 

 
 Constraints: 

 
 1 <= nums.length <= 100 
 0 <= nums[i] <= 1000 
 

 Related Topics Array Dynamic Programming 👍 8833 👎 123

*/

public class HouseRobberIi{
    public static void main(String[] args){
        Solution solution = new HouseRobberIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
        {
            return 0;
        }
        if (n == 1)
        {
            return nums[0];
        }
        if (n == 2)
        {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob198(Arrays.copyOfRange(nums, 0, n-1)), rob198(Arrays.copyOfRange(nums, 1, n)));
    }

        private int rob198(int[] nums) {

            int n = nums.length;
            if (n==1)
            {
                return nums[0];
            }
            int[] f = new int[nums.length];

            f[0] = nums[0];
            f[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                f[i] = Math.max(f[i - 2] + nums[i], f[i - 1]);
            }
            return f[nums.length - 1];
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}