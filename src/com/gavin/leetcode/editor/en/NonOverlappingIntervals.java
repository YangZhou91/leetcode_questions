package com.gavin.leetcode.editor.en;
/*2023-07-25 23:30:19*/

import java.util.Arrays;
import java.util.Comparator;

/**
Given an array of intervals intervals where intervals[i] = [starti, endi], 
return the minimum number of intervals you need to remove to make the rest of the 
intervals non-overlapping. 

 
 Example 1: 

 
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-
overlapping.
 

 Example 2: 

 
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-
overlapping.
 

 Example 3: 

 
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're 
already non-overlapping.
 

 
 Constraints: 

 
 1 <= intervals.length <= 10⁵ 
 intervals[i].length == 2 
 -5 * 10⁴ <= starti < endi <= 5 * 10⁴ 
 

 Related Topics Array Dynamic Programming Greedy Sorting 👍 7228 👎 189

*/

public class NonOverlappingIntervals{
    public static void main(String[] args){
        Solution solution = new NonOverlappingIntervals().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // sort by start
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        int count = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // compare next start to previous end
            // non overlapping
            if (end <= intervals[i][0]){
                end = intervals[i][1];
            }
            else{
                end = Math.min(end, intervals[i][1]);
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

