package com.gavin.leetcode.editor.en;
/*2023-07-25 19:11:00*/

import java.util.ArrayList;
import java.util.HashMap;

/**
Given a string s, sort it in decreasing order based on the frequency of the 
characters. The frequency of a character is the number of times it appears in the 
string. 

 Return the sorted string. If there are multiple answers, return any of them. 

 
 Example 1: 

 
Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid 
answer.
 

 Example 2: 

 
Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" 
are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
 

 Example 3: 

 
Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 

 
 Constraints: 

 
 1 <= s.length <= 5 * 10⁵ 
 s consists of uppercase and lowercase English letters and digits. 
 

 Related Topics Hash Table String Sorting Heap (Priority Queue) Bucket Sort 
Counting 👍 6977 👎 234

*/

public class SortCharactersByFrequency{
    public static void main(String[] args){
        Solution solution = new SortCharactersByFrequency().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> frequencyForChar = new HashMap<>();
        // char, count map
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Increment char count
            frequencyForChar.put(c, frequencyForChar.getOrDefault(c, 0) + 1);
        }

        ArrayList<Character>[] bucket = new ArrayList[s.length() + 1];
        for (char c:frequencyForChar.keySet()) {
            int frequency = frequencyForChar.get(c);
            if (bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0 ; i--) {
            // i is frequency
            if (bucket[i] == null)
            {
                continue;
            }
            for (char c: bucket[i]) {
                for (int j = 0; j < i; j++) {
                    stringBuilder.append(c);
                }
            }

        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

