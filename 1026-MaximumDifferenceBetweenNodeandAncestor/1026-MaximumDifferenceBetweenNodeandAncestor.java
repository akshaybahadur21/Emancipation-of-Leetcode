/*

1026. Maximum Difference Between Node and Ancestor
Medium

Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.

(A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)

Example 1:

Input: [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: 
We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

Note:

    The number of nodes in the tree is between 2 and 5000.
    Each node will have value between 0 and 100000.

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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
    private int dfs(TreeNode node, int max , int min){
        if(node == null) return 0;
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        int left = dfs(node.left, max, min);
        int right = dfs(node.right, max, min);
        return Math.max(max - min, Math.max(left, right));
    }
}

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
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }
    private void dfs(TreeNode node, int max, int min){
        if(node == null) return;
        res = Math.max(res, Math.abs(max - node.val));
        res = Math.max(res, Math.abs(min - node.val));
        dfs(node.right, Math.max(max, node.val), Math.min(min, node.val));
        dfs(node.left, Math.max(max, node.val), Math.min(min, node.val));
    }
}
