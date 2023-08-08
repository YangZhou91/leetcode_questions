package com.gavin.leetcode.editor.en;
/*2023-08-08 17:45:04*/
/**
You are a professional robber planning to rob houses along a street. Each house 
has a certain amount of money stashed, the only constraint stopping you from 
robbing each of them is that adjacent houses have security systems connected and 
it will automatically contact the police if two adjacent houses were broken into 
on the same night. 

 Given an integer array nums representing the amount of money of each house, 
return the maximum amount of money you can rob tonight without alerting the police.
 

 
 Example 1: 

 
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 

 Example 2: 

 
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (
money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

 
 Constraints: 

 
 1 <= nums.length <= 100 
 0 <= nums[i] <= 400 
 

 Related Topics Array Dynamic Programming 👍 18755 👎 351

*/

public class HouseRobber{
    public static void main(String[] args){
        Solution solution = new HouseRobber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int rob(int[] nums) {
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