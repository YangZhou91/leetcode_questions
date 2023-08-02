package com.gavin.leetcode.editor.en;
/*2023-08-01 16:31:45*/

import java.util.*;

/**
A transformation sequence from word beginWord to word endWord using a 
dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that: 

 
 Every adjacent pair of words differs by a single letter. 
 Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to 
be in wordList. 
 sk == endWord 
 

 Given two words, beginWord and endWord, and a dictionary wordList, return the 
number of words in the shortest transformation sequence from beginWord to 
endWord, or 0 if no such sequence exists. 

 
 Example 1: 

 
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
"log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> 
"dog" -> cog", which is 5 words long.
 

 Example 2: 

 
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
"log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid 
transformation sequence.
 

 
 Constraints: 

 
 1 <= beginWord.length <= 10 
 endWord.length == beginWord.length 
 1 <= wordList.length <= 5000 
 wordList[i].length == beginWord.length 
 beginWord, endWord, and wordList[i] consist of lowercase English letters. 
 beginWord != endWord 
 All the words in wordList are unique. 
 

 Related Topics Hash Table String Breadth-First Search 👍 10915 👎 1808

*/

public class WordLadder{
    public static void main(String[] args){
        Solution solution = new WordLadder().new Solution();
        solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        // for BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] wordUnit = cur.toCharArray();
                if (cur.equals(endWord)) {
                    return level + 1;
                }
                for (int j = 0; j < cur.length(); j++) {
                    char temp = wordUnit[j];
                    for (char c = 'a'; c <= 'z'; c++)
                    {
                        wordUnit[j] = c;
                        String s = new String(wordUnit);
                        if (set.contains(s))
                        {
                            queue.add(s);
                            set.remove(s);
                        }
                    }
                    wordUnit[j] = temp;
                }
            }
            level ++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}