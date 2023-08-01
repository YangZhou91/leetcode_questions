package com.gavin.leetcode.editor.en;
/*2023-07-30 12:39:17*/
/**
Given two strings s and t, return true if s is a subsequence of t, or false 
otherwise. 

 A subsequence of a string is a new string that is formed from the original 
string by deleting some (can be none) of the characters without disturbing the 
relative positions of the remaining characters. (i.e., "ace" is a subsequence of 
"abcde" while "aec" is not). 

 
 Example 1: 
 Input: s = "abc", t = "ahbgdc"
Output: true
 
 Example 2: 
 Input: s = "axc", t = "ahbgdc"
Output: false
 
 
 Constraints: 

 
 0 <= s.length <= 100 
 0 <= t.length <= 10⁴ 
 s and t consist only of lowercase English letters. 
 

 
Follow up: Suppose there are lots of incoming 
s, say 
s1, s2, ..., sk where 
k >= 10⁹, and you want to check one by one to see if 
t has its subsequence. In this scenario, how would you change your code?

 Related Topics Two Pointers String Dynamic Programming 👍 7937 👎 443

*/

public class IsSubsequence{
    public static void main(String[] args){
        Solution solution = new IsSubsequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c :
                s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1)
            {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

