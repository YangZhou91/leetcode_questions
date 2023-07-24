package com.gavin.leetcode.editor.en;
/*2023-07-24 23:58:12*/

import java.util.Arrays;
import java.util.HashSet;

/**
Given a string s, reverse only all the vowels in the string and return it. 

 The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower 
and upper cases, more than once. 

 
 Example 1: 
 Input: s = "hello"
Output: "holle"
 
 Example 2: 
 Input: s = "leetcode"
Output: "leotcede"
 
 
 Constraints: 

 
 1 <= s.length <= 3 * 10⁵ 
 s consist of printable ASCII characters. 
 

 Related Topics Two Pointers String 👍 3701 👎 2548

*/

public class ReverseVowelsOfAString{
    public static void main(String[] args){
        Solution solution = new ReverseVowelsOfAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)){
                result[i++] = ci;
            }
            else if (!vowels.contains(cj)) {
                result[j--] = cj;
            }
            else{
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

