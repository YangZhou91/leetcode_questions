package com.gavin.leetcode.editor.en;
/*2023-08-02 16:37:57*/

import java.util.ArrayList;
import java.util.List;

/**
Given a string containing digits from 2-9 inclusive, return all possible letter 
combinations that the number could represent. Return the answer in any order. 

 A mapping of digits to letters (just like on the telephone buttons) is given 
below. Note that 1 does not map to any letters. 
 
 
 Example 1: 

 
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 

 Example 2: 

 
Input: digits = ""
Output: []
 

 Example 3: 

 
Input: digits = "2"
Output: ["a","b","c"]
 

 
 Constraints: 

 
 0 <= digits.length <= 4 
 digits[i] is a digit in the range ['2', '9']. 
 

 Related Topics Hash Table String Backtracking 👍 15851 👎 862

*/

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args){
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 0, 1, 2 .. 9
        private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> combinations = new ArrayList<>();
            if (digits == null || digits.length() == 0)
            {
                return combinations;
            }
            doCombination(new StringBuilder(), combinations, digits);
            return combinations;
        }

        private void doCombination(StringBuilder prefix, List<String> combinations, final String digits)
        {
            if (prefix.length() == digits.length())
            {
                combinations.add(prefix.toString());
                return;
            }
            int curDigits = digits.charAt(prefix.length()) - '0';
            String letters = KEYS[curDigits];
            for (char c : letters.toCharArray())
            {
                prefix.append(c);
                doCombination(prefix, combinations, digits);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}