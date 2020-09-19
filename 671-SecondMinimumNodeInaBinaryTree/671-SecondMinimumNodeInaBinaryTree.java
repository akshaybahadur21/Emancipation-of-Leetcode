/*

671. Second Minimum Node In a Binary Tree
Easy

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:

Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.

Example 2:

Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.

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
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        int [] res = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        boolean[] diff = new boolean[]{false};
        dfs(root, res, diff);
        return res[1] == Integer.MAX_VALUE && diff[0] == false ? -1 : res[1];
    }
    private void dfs(TreeNode node, int[] res, boolean[] diff){
        if(node == null) return;
        if(node.val < res[0]) res[0] = node.val;
        else if(node.val > res[0] && node.val <= res[1]) {
            res[1] = node.val;
            diff[0] = true;
        }
        dfs(node.left, res, diff);
        dfs(node.right, res, diff);
    }
}
