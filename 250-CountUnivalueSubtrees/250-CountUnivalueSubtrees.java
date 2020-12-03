/*

250. Count Univalue Subtrees
Medium

Given the root of a binary tree, return the number of uni-value subtrees.

A uni-value subtree means all nodes of the subtree have the same value.

Example 1:

Input: root = [5,1,5,5,5,null,5]
Output: 4

Example 2:

Input: root = []
Output: 0

Example 3:

Input: root = [5,5,5,5,5,null,5]
Output: 6

Constraints:

    The numbrt of the node in the tree will be in the range [0, 1000].
    -1000 <= Node.val <= 1000

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
    public int countUnivalSubtrees(TreeNode root) {
        //simple dfs logic
        // if node.val != left and right, return a new identifier 1001
        // if node == null return -1001 (a different identifier)
        // use this to manipuate.
        int[] res = new int[]{0};
        dfs(root, res);
        return res[0];
    }
    private int dfs(TreeNode node, int[] res){
        if(node == null) return -1001;
        if(node.left == null && node.right == null) {
            res[0]++;
            return node.val;
        }
        int left = dfs(node.left, res);
        int right = dfs(node.right, res);
        left = left == -1001 ? node.val : left;
        right = right == -1001 ? node.val : right;
        if(node.val == left && node.val == right) {
            res[0]++;
            return node.val;
        }
        return 1001;
    }
}
