package com.gavin.leetcode.editor.en;
/*2023-07-25 11:08:05*/
/**
Given a string s, return true if the s can be palindrome after deleting at most 
one character from it. 

 
 Example 1: 

 
Input: s = "aba"
Output: true
 

 Example 2: 

 
Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
 

 Example 3: 

 
Input: s = "abc"
Output: false
 

 
 Constraints: 

 
 1 <= s.length <= 10⁵ 
 s consists of lowercase English letters. 
 

 Related Topics Two Pointers String Greedy 👍 7453 👎 379

*/

public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        System.out.println(solution.validPalindrome("deeee"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
                }
            }
            return true;
        }

        private boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) {
                    return false;
                }
//                i++;
//                j--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}