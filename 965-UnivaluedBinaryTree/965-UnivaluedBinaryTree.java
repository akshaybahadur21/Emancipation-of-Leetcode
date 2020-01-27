/*

965. Univalued Binary Tree
Easy

A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.

Example 1:

Input: [1,1,1,1,1,null,1]
Output: true

Example 2:

Input: [2,2,2,5,2]
Output: false

Note:

    The number of nodes in the given tree will be in the range [1, 100].
    Each node's value will be an integer in the range [0, 99].

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
    //bfs approach.
    // Will traverse and add values in a linked list
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        int lookup = root.val;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if (temp.val != lookup)
                return false;
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
        return true;
        
    }
}

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
    //dfs
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.val != root.left.val) return false;
        if (root.right != null && root.val != root.right.val) return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
