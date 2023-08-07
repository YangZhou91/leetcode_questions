package com.gavin.leetcode.editor.en;
/*2023-08-07 16:06:57*/

import java.util.ArrayList;
import java.util.List;

/**
Given a string s, partition s such that every substring of the partition is a 
palindrome. Return all possible palindrome partitioning of s. 

 
 Example 1: 
 Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
 
 Example 2: 
 Input: s = "a"
Output: [["a"]]
 
 
 Constraints: 

 
 1 <= s.length <= 16 
 s contains only lowercase English letters. 
 

 Related Topics String Dynamic Programming Backtracking 👍 11385 👎 357

*/

public class PalindromePartitioning{
    public static void main(String[] args){
        Solution solution = new PalindromePartitioning().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> partitions = new ArrayList<>();
            List<String> tempPartition = new ArrayList<>();

            backtracking(s, tempPartition, partitions);

            return  partitions;
        }

        private void backtracking(String s, List<String> tempPartition, List<List<String>> partitions) {
            if (s.length() == 0)
            {
                partitions.add(new ArrayList<>(tempPartition));
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                if(isPalindrome(s, 0, i))
                {
                    tempPartition.add(s.substring(0, i + 1));
                    backtracking(s.substring(i + 1), tempPartition, partitions);
                    tempPartition.remove(tempPartition.size() - 1);
                }
            }
        }


        private boolean isPalindrome(String s, int begin, int end) {
            while (begin < end) {
                if (s.charAt(begin++) != s.charAt(end--)) {
                    return false;
                }
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}