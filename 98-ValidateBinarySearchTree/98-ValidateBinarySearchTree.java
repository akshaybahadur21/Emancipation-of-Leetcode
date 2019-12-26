/*

98. Validate Binary Search Tree
Medium

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Link : https://leetcode.com/problems/validate-binary-search-tree/

*/

//DFS
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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }
    private boolean dfs(TreeNode root, Integer lower, Integer upper){
        if (root == null)
            return true;
            if (lower != null && root.val <= lower)
                return false;
            if (upper != null && root.val >= upper)
                return false;
        return dfs(root.left, lower, root.val) && dfs(root.right, root.val, upper);
    }
}

//Inorder traversal
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
    List <Integer> resList;
    public boolean isValidBST(TreeNode root) {
        resList= new ArrayList<>();
        inOrder(root);
        for (int i =0; i<resList.size() -1; i++){
            if(resList.get(i) >= resList.get(i+1))
                return false;
        }
        return true;
    }
    private void inOrder(TreeNode root){
        if (root == null)
            return;
        inOrder(root.left);
        resList.add(root.val);
        inOrder(root.right);
    }
}
