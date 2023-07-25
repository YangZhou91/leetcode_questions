package com.gavin.leetcode.editor.en;
/*2023-07-25 14:52:27*/

import java.util.Arrays;
import java.util.List;

/**
Given a string s and a string array dictionary, return the longest string in 
the dictionary that can be formed by deleting some of the given string characters. 
If there is more than one possible result, return the longest word with the 
smallest lexicographical order. If there is no possible result, return the empty 
string. 

 
 Example 1: 

 
Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"
 

 Example 2: 

 
Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
 

 
 Constraints: 

 
 1 <= s.length <= 1000 
 1 <= dictionary.length <= 1000 
 1 <= dictionary[i].length <= 1000 
 s and dictionary[i] consist of lowercase English letters. 
 

 Related Topics Array Two Pointers String Sorting 👍 1665 👎 353

*/

public class LongestWordInDictionaryThroughDeleting{
    public static void main(String[] args){
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        List<String> words = Arrays.asList("Apple", "Grape", "Pear");
        System.out.println(solution.findLongestWord("abpcplea", words));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";
        for (int i = 0; i < dictionary.size(); i++) {
            String word = dictionary.get(i);
            int resultLength = longestWord.length();
            int wordLength = word.length();

            if (resultLength > wordLength || (resultLength == wordLength && longestWord.compareTo(word) < 0))
            {
                continue;
            }

            if (isSubstring(s, word)) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private boolean isSubstring(String s1, String target)
    {
        int i = 0, j = 0;
        while(i < s1.length() && j < target.length()){
            if (Character.toLowerCase(s1.charAt(i)) == Character.toLowerCase(target.charAt(j)))
            {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}