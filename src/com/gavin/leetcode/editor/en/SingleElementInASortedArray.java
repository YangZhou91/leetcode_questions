package com.gavin.leetcode.editor.en;
/*2023-07-31 11:31:32*/
/**
You are given a sorted array consisting of only integers where every element 
appears exactly twice, except for one element which appears exactly once. 

 Return the single element that appears only once. 

 Your solution must run in O(log n) time and O(1) space. 

 
 Example 1: 
 Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
 
 Example 2: 
 Input: nums = [3,3,7,7,10,11,11]
Output: 10
 
 
 Constraints: 

 
 1 <= nums.length <= 10⁵ 
 0 <= nums[i] <= 10⁵ 
 

 Related Topics Array Binary Search 👍 9777 👎 152

*/

public class SingleElementInASortedArray{
    public static void main(String[] args){
        Solution solution = new SingleElementInASortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        //[0,1,2,3,4,5,6,7,8]
        //[1,1,2,3,3,4,4,8,8]
        int l = 0, h = nums.length - 1;
        while(l < h){
            int m = l + (h - l) / 2;
            // duplicate occurrence
            if (m % 2 == 0) {
                if (nums[m] == nums[m + 1]) {
                    l = m + 1;
                } else {
                    h = m;
                }
            } else if (m % 2 == 1) {
                if (nums[m] == nums[m - 1]) {
                    l = m + 1;
                } else {
                    h = m;
                }
            }
        }
        return  nums[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}