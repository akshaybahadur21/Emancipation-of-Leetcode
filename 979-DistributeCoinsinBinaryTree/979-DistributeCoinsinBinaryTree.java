/*

979. Distribute Coins in Binary Tree
Medium

You are given the root of a binary tree with n nodes where each node in the tree has node.val coins and there are n coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another. (A move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.

Example 1:

Input: root = [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.

Example 2:

Input: root = [0,3,0]
Output: 3
Explanation: From the left child of the root, we move two coins to the root [taking two moves].  Then, we move one coin from the root of the tree to the right child.

Example 3:

Input: root = [1,0,2]
Output: 2

Example 4:

Input: root = [1,0,0,null,3]
Output: 4

Constraints:

    The number of nodes in the tree is n.
    1 <= n <= 100
    0 <= Node.val <= n
    The sum of Node.val is n.

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
    public int distributeCoins(TreeNode root) {
        // interesting question
        // take into account -> number of nodes in a subtree, number of coins in a subtree
        int[] res = new int[]{0};
        dfs(root, res);
        return res[0];
    }
    // returning [number of nodes in a subtree, number of coins in a subtree]
    private int[] dfs(TreeNode node, int[] res){
        if(node == null) return new int[]{0, 0};
        int[] left = dfs(node.left, res);
        int[] right = dfs(node.right, res);
        res[0] += Math.abs(left[0] - left[1]) + Math.abs(right[0] - right[1]);
        return new int[]{left[0] + right[0] + 1, left[1] + right[1] + node.val};
    }
}
