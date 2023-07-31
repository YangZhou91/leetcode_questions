package com.gavin.leetcode.editor.en;
/*2023-07-31 11:14:47*/
/**
You are given an array of characters letters that is sorted in non-decreasing 
order, and a character target. There are at least two different characters in 
letters. 

 Return the smallest character in letters that is lexicographically greater 
than target. If such a character does not exist, return the first character in 
letters. 

 
 Example 1: 

 
Input: letters = ["c","f","j"], target = "a"
Output: "c"
Explanation: The smallest character that is lexicographically greater than 'a' 
in letters is 'c'.
 

 Example 2: 

 
Input: letters = ["c","f","j"], target = "c"
Output: "f"
Explanation: The smallest character that is lexicographically greater than 'c' 
in letters is 'f'.
 

 Example 3: 

 
Input: letters = ["x","x","y","y"], target = "z"
Output: "x"
Explanation: There are no characters in letters that is lexicographically 
greater than 'z' so we return letters[0].
 

 
 Constraints: 

 
 2 <= letters.length <= 10⁴ 
 letters[i] is a lowercase English letter. 
 letters is sorted in non-decreasing order. 
 letters contains at least two different characters. 
 target is a lowercase English letter. 
 

 Related Topics Array Binary Search 👍 3948 👎 2148

*/

public class FindSmallestLetterGreaterThanTarget{
    public static void main(String[] args){
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0;
        int h = n - 1;
        while (l <= h)
        {
            int m = l + (h - l)/2;
            if (letters[m] > target){
                h = m - 1;
            }else
            {
                l = m + 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}