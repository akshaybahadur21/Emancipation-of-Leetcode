/*

257. Binary Tree Paths
Easy

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3


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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resList = new ArrayList<>();
        if (root != null)
            dfs(root, "", resList);
        return resList;
    }
    private void dfs(TreeNode root, String path, List list){
        if (root.left == null && root.right == null)
            list.add(path + root.val);
        if (root.left != null)
            dfs(root.left, path + root.val + "->", list);
        if (root.right != null)
            dfs(root.right, path + root.val + "->", list);
    }
}
