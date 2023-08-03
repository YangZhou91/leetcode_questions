package com.gavin.leetcode.editor.en;
/*2023-08-03 14:16:32*/

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
Given the root of a binary tree, return all root-to-leaf paths in any order. 

 A leaf is a node with no children. 

 
 Example 1: 
 
 
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
 

 Example 2: 

 
Input: root = [1]
Output: ["1"]
 

 
 Constraints: 

 
 The number of nodes in the tree is in the range [1, 100]. 
 -100 <= Node.val <= 100 
 

 Related Topics String Backtracking Tree Depth-First Search Binary Tree 👍 6023 
👎 259

*/

public class BinaryTreePaths{
    public static void main(String[] args){
        Solution solution = new BinaryTreePaths().new Solution();
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        dfs(root, values, paths);
        return paths;
    }

    private void dfs(TreeNode node, List<Integer> values, List<String> paths) {
        if (node == null) {
            return;
        }
        values.add(node.val);
        if (isLeaf(node)) {
            paths.add(buildPath(values));
        } else {
            dfs(node.left, values, paths);
            dfs(node.right, values, paths);
        }
        values.remove(values.size() - 1);
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private String buildPath(List<Integer> values)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < values.size(); i++)
        {
            stringBuilder.append(values.get(i));
            if (i != values.size() - 1)
            {
                stringBuilder.append("->");
            }
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}