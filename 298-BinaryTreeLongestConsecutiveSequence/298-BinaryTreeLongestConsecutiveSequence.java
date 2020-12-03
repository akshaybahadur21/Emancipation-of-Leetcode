/*

298. Binary Tree Longest Consecutive Sequence
Medium

Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.

Example 2:

Input:

   2
    \
     3
    / 
   2    
  / 
 1

Output: 2 

Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2

*/

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
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        return Math.max(dfs(root), Math.max(longestConsecutive(root.left), longestConsecutive(root.right)));
    }
    private int dfs(TreeNode node){
        if(node == null) return 0;
        int left = 1, right = 1;
        if(node.left != null && node.left.val - node.val == 1)
            left = 1 + dfs(node.left);
        if(node.right != null &&  node.right.val - node.val == 1)
            right = 1 + dfs(node.right);
        return Math.max(left, right);
    }
}
