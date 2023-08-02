package com.gavin.leetcode.editor.en;
/*2023-07-31 16:46:03*/

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
Given an integer n, return all the structurally unique BST's (binary search 
trees), which has exactly n nodes of unique values from 1 to n. Return the answer 
in any order. 

 
 Example 1: 
 
 
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 

 Example 2: 

 
Input: n = 1
Output: [[1]]
 

 
 Constraints: 

 
 1 <= n <= 8 
 

 Related Topics Dynamic Programming Backtracking Tree Binary Search Tree Binary 
Tree 👍 6163 👎 399

*/

public class UniqueBinarySearchTreesIi{
    public static void main(String[] args){
        Solution solution = new UniqueBinarySearchTreesIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1){
            return new ArrayList<TreeNode>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int l, int r)
    {
        List<TreeNode> result = new ArrayList<>();
        if (l > r) {
            result.add(null);
            return result;
        }

        for (int i = l; i <= r; ++i)
        {
            List<TreeNode> lTree = build(l, i - 1);
            List<TreeNode> rTree = build(i + 1, r);
            for (TreeNode left : lTree) {
                for (TreeNode right : rTree) {

//              for debug
                /*
                TreeNode root = new TreeNode(i);
                root.left = left;
                root.right = right;
                result.add(root);
                */
                }

            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}