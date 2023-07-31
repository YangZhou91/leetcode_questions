package com.gavin.leetcode.editor.en;
/*2023-07-31 10:26:41*/

import java.util.ArrayList;
import java.util.List;

/**
You are given a string s. We want to partition the string into as many parts as 
possible so that each letter appears in at most one part. 

 Note that the partition is done so that after concatenating all the parts in 
order, the resultant string should be s. 

 Return a list of integers representing the size of these parts. 

 
 Example 1: 

 
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits 
s into less parts.
 

 Example 2: 

 
Input: s = "eccbbbbdec"
Output: [10]
 

 
 Constraints: 

 
 1 <= s.length <= 500 
 s consists of lowercase English letters. 
 

 Related Topics Hash Table Two Pointers String Greedy 👍 9690 👎 354

*/

public class PartitionLabels{
    public static void main(String[] args){
        Solution solution = new PartitionLabels().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndexOfChar[char2Index(s.charAt(i))] = i;
        }
        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;
        while (firstIndex < s.length())
        {
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < s.length() && i <=lastIndex; i++)
            {
                int index = lastIndexOfChar[char2Index(s.charAt(i))];
                if (index > lastIndex){
                    lastIndex = index;
                }
            }
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }

    private int char2Index(char c){
        return c - 'a';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}