package com.gavin.leetcode.editor.en;
/*2023-07-25 22:40:43*/
/**
Given an array nums with n objects colored red, white, or blue, sort them in-
place so that objects of the same color are adjacent, with the colors in the order 
red, white, and blue. 

 We will use the integers 0, 1, and 2 to represent the color red, white, and 
blue, respectively. 

 You must solve this problem without using the library's sort function. 

 
 Example 1: 

 
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
 

 Example 2: 

 
Input: nums = [2,0,1]
Output: [0,1,2]
 

 
 Constraints: 

 
 n == nums.length 
 1 <= n <= 300 
 nums[i] is either 0, 1, or 2. 
 

 
 Follow up: Could you come up with a one-pass algorithm using only constant 
extra space? 

 Related Topics Array Two Pointers Sorting 👍 15852 👎 556

*/

public class SortColors{
    public static void main(String[] args){
        Solution solution = new SortColors().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = nums.length-1;
        while (one <= two){
            if (nums[one] == 0){
                swap(nums, zero, one);
                zero++;
                one++;
            } else if (nums[one] == 1) {
                one++;
            } else if (nums[one] == 2) {
                swap(nums, one, two);
                two--;
            }
        }
    }

    private void swap(int[] nums, int left, int right)
    {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

