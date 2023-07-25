package com.gavin.leetcode.editor.en;
/*2023-07-25 18:30:21*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
Given an integer array nums and an integer k, return the k most frequent 
elements. You may return the answer in any order. 

 
 Example 1: 
 Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
 
 Example 2: 
 Input: nums = [1], k = 1
Output: [1]
 
 
 Constraints: 

 
 1 <= nums.length <= 10⁵ 
 -10⁴ <= nums[i] <= 10⁴ 
 k is in the range [1, the number of unique elements in the array]. 
 It is guaranteed that the answer is unique. 
 

 
 Follow up: Your algorithm's time complexity must be better than O(n log n), 
where n is the array's size. 

 Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority 
Queue) Bucket Sort Counting Quickselect 👍 15273 👎 536

*/

public class TopKFrequentElements{
    public static void main(String[] args){
        Solution solution = new TopKFrequentElements().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyforNum = new HashMap<>();
        // number, count
        for (int num: nums) {
            frequencyforNum.put(num, frequencyforNum.getOrDefault(num,0) + 1);
        }

        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        // count, number
        for (Integer key: frequencyforNum.keySet()) {
            Integer frequency = frequencyforNum.get(key);
            if (bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && topK.size() < k ; i--) {
            if (bucket[i] == null){
                continue;
            }
            if (bucket[i].size() <= (k - topK.size())){
                topK.addAll(bucket[i]);
            }else{
                topK.addAll(bucket[i].subList(0, k - topK.size()));
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

