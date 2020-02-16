/*

563. Binary Tree Tilt
Easy

Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:

Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1

Note:

    The sum of node values in any subtree won't exceed the range of 32-bit integer.
    All the tilt values won't exceed the range of 32-bit integer.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        //preorder traversal
        if (root == null) return tilt;
        dfs(root);
        return tilt;
    }
    
    private int dfs(TreeNode node){
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        tilt += Math.abs(left - right);
        return left + right + node.val;
    }
}
