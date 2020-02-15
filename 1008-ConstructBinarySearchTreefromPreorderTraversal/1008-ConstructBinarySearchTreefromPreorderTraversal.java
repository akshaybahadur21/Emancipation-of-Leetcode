/*

1008. Construct Binary Search Tree from Preorder Traversal
Medium

Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Note: 

    1 <= preorder.length <= 100
    The values of preorder are distinct.

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
    int i =0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode dfs(int[] A, int start, int end){
        if (i == A.length || A[i] < start || A[i] > end)
            return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = dfs(A, start, root.val);
        root.right = dfs(A, root.val, end);
        return root;
    }
}
