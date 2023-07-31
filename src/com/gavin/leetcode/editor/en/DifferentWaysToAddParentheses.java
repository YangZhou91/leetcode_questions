package com.gavin.leetcode.editor.en;
/*2023-07-31 16:11:22*/

import java.util.ArrayList;
import java.util.List;

/**
Given a string expression of numbers and operators, return all possible results 
from computing all the different possible ways to group numbers and operators. 
You may return the answer in any order. 

 The test cases are generated such that the output values fit in a 32-bit 
integer and the number of different results does not exceed 10⁴. 

 
 Example 1: 

 
Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0 
(2-(1-1)) = 2
 

 Example 2: 

 
Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
 

 
 Constraints: 

 
 1 <= expression.length <= 20 
 expression consists of digits and the operator '+', '-', and '*'. 
 All the integer values in the input expression are in the range [0, 99]. 
 

 Related Topics Math String Dynamic Programming Recursion Memoization 👍 4901 👎
 235

*/

public class DifferentWaysToAddParentheses{
    public static void main(String[] args){
        Solution solution = new DifferentWaysToAddParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        // divide and conquer
        // T(n) = 2T(n / 2) + o(N) -> O(n log n)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*')
            {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int x : left) {
                    for (int y : right) {
                        if (c == '+') {
                            result.add(x + y);
                        } else if (c == '-') {
                            result.add(x - y);
                        } else if (c == '*') {
                            result.add(x * y);
                        }
                    }
                }
            }
        }
        if (result.size() == 0)
        {
            result.add(Integer.valueOf(expression));
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}