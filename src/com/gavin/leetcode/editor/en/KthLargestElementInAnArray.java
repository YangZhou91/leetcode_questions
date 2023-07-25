package com.gavin.leetcode.editor.en;
/*2023-07-25 15:38:25*/

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
Given an integer array nums and an integer k, return the kᵗʰ largest element in 
the array. 

 Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
distinct element. 

 Can you solve it without sorting? 

 
 Example 1: 
 Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
 
 Example 2: 
 Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 
 
 Constraints: 

 
 1 <= k <= nums.length <= 10⁵ 
 -10⁴ <= nums[i] <= 10⁴ 
 

 Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) 
Quickselect 👍 14583 👎 711

*/

public class KthLargestElementInAnArray{
    public static void main(String[] args){
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    // Array Sort
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }

//        // Priority Queue
//        public int findKthLargest(int[] nums, int k){
//            Queue<Integer> queue = new PriorityQueue<>();
//            for (int i = 0; i < nums.length; i++) {
//                queue.add(nums[i]);
//                if (queue.size() > k){
//                    // remove top element
//                    queue.poll();
//                }
//            }
//            return queue.peek();
//        }

        // TODO: Quick select
        public int findKthLargest(int[] nums, int k)
        {
            helper(nums, 0, nums.length - 1, k);
            return nums[nums.length - k];
        }

        void helper(int[] nums, int left, int right, int k){
            if (left >= right){
                return;
            }
            int position = partition(nums, left, right);
            if (position == nums.length - k)
            {
                return;
            }
            if (position < nums.length - k) {
                helper(nums, position + 1, right, k);
            } else {
                helper(nums, left, position -1, k);
            }
        }

        private int partition(int[] nums, int left, int right){
            int pivot = nums[right], p = left;
            for (int i = left; i < right; i++) {
                if (nums[i] < pivot){
                    swap(nums, i, p);
                    p++;
                }
            }
            swap(nums, p, right);
            return p;
        }

        private void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}