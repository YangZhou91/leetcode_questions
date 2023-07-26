package com.gavin.leetcode.editor.en;
/*2023-07-26 17:07:30*/
/**
You are given an array prices where prices[i] is the price of a given stock on 
the iᵗʰ day. 

 You want to maximize your profit by choosing a single day to buy one stock and 
choosing a different day in the future to sell that stock. 

 Return the maximum profit you can achieve from this transaction. If you cannot 
achieve any profit, return 0. 

 
 Example 1: 

 
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-
1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must 
buy before you sell.
 

 Example 2: 

 
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

 
 Constraints: 

 
 1 <= prices.length <= 10⁵ 
 0 <= prices[i] <= 10⁴ 
 

 Related Topics Array Dynamic Programming 👍 26974 👎 868

*/

public class BestTimeToBuyAndSellStock{
    public static void main(String[] args){
        Solution solution = new BestTimeToBuyAndSellStock().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int localMin = prices[0];
        int localMaxProfit = 0;
        for (int i = 1; i < n; i ++)
        {
            if (prices[i] < localMin)
            {
                localMin = prices[i];
            }
            else{
                localMaxProfit = Math.max(localMaxProfit, prices[i] - localMin);
            }
        }
        return localMaxProfit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}