/*

270. Closest Binary Search Tree Value
Easy

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.

Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4

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
    public int closestValue(TreeNode root, double target) {
        if(root == null) return -1;
        int[] closest = new int[]{root.val};
        dfs(root, target, closest);
        return closest[0];
    }
    private void dfs(TreeNode node, double target, int[] closest){
        if(node == null) return;
        closest[0] = Math.abs(closest[0] - target) > Math.abs(node.val - target) ? node.val : closest[0];
        if(node.val > target) dfs(node.left, target, closest);
        else dfs(node.right, target, closest);
    }
}
