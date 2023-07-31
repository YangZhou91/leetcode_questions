package com.gavin.leetcode.editor.en;
/*2023-07-31 10:51:59*/
/**
Given a non-negative integer x, return the square root of x rounded down to the 
nearest integer. The returned integer should be non-negative as well. 

 You must not use any built-in exponent function or operator. 

 
 For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python. 
 

 
 Example 1: 

 
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.
 

 Example 2: 

 
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we round it down to 
the nearest integer, 2 is returned.
 

 
 Constraints: 

 
 0 <= x <= 2³¹ - 1 
 

 Related Topics Math Binary Search 👍 6933 👎 4198

*/

public class Sqrtx{
    public static void main(String[] args){
        Solution solution = new Sqrtx().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {

        int l = 1;
        int h = x;
        while (l <= h){
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid){
                return mid;
            } else if (mid > sqrt) {
                h = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return h;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}