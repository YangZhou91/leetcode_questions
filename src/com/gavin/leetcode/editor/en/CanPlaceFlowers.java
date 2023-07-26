package com.gavin.leetcode.editor.en;
/*2023-07-26 17:31:25*/
/**
You have a long flowerbed in which some of the plots are planted, and some are 
not. However, flowers cannot be planted in adjacent plots. 

 Given an integer array flowerbed containing 0's and 1's, where 0 means empty 
and 1 means not empty, and an integer n, return true if n new flowers can be 
planted in the flowerbed without violating the no-adjacent-flowers rule and false 
otherwise. 

 
 Example 1: 
 Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
 
 Example 2: 
 Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 
 
 Constraints: 

 
 1 <= flowerbed.length <= 2 * 10⁴ 
 flowerbed[i] is 0 or 1. 
 There are no two adjacent flowers in flowerbed. 
 0 <= n <= flowerbed.length 
 

 Related Topics Array Greedy 👍 5407 👎 909

*/

public class CanPlaceFlowers{
    public static void main(String[] args){
        Solution solution = new CanPlaceFlowers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int availableSlots = 0;
        for (int i = 0; i < flowerbed.length && availableSlots < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            // Assume first and last 0 is valid
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];

            if (pre == 0 && next == 0) {
                flowerbed[i] = 1;
                availableSlots++;
            }
        }

        return availableSlots >= n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}