package com.gavin.leetcode.editor.en;
/*2023-07-31 15:10:08*/
/**
Given an array of integers nums sorted in non-decreasing order, find the 
starting and ending position of a given target value. 

 If target is not found in the array, return [-1, -1]. 

 You must write an algorithm with O(log n) runtime complexity. 

 
 Example 1: 
 Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
 
 Example 2: 
 Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 
 Example 3: 
 Input: nums = [], target = 0
Output: [-1,-1]
 
 
 Constraints: 

 
 0 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 nums is a non-decreasing array. 
 -10⁹ <= target <= 10⁹ 
 

 Related Topics Array Binary Search 👍 17847 👎 436

*/

public class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args){
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = findStartIndex(nums, target);
        int lastIndex = findStartIndex(nums, target + 1) - 1;
        if (firstIndex == nums.length || nums[firstIndex] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{firstIndex, Math.max(firstIndex, lastIndex)};
        }
    }

    private int findStartIndex(int nums[], int target)
    {
        int low = 0;
        // handle nums = [2,2], target = 2 case
        int high = nums.length;
        while (low < high)
        {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)
            {
                low = mid + 1;
            }else
            {
                high = mid;
            }
        }
        return low;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}