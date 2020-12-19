/*

938. Range Sum of BST
Easy

Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

 

Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32

Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23

 

Note:

    The number of nodes in the tree is at most 10000.
    The final answer is guaranteed to be less than 2^31.

Link : https://leetcode.com/problems/range-sum-of-bst/

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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }
    private int dfs(TreeNode node, int lo, int hi){
        if(node == null) return 0;
        if(node.val >= lo && node.val <= hi) return node.val + dfs(node.left, lo, hi) + dfs(node.right, lo, hi);
        if(node.val < lo) return dfs(node.right, lo, hi);
        else return dfs(node.left, lo, hi);
    }
}

 
 //Unoptimized
 // One optimization is to only go left or right if you know that the value will be in that range.
 
class Solution {
    int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        ans=0;
        rangeSumBSTHelper(root,  L,  R);
        return ans;
    }
    
    private void rangeSumBSTHelper(TreeNode root, int L, int R){
        if (root != null){
            if (L <= root.val && root.val <= R )
                ans +=root.val;
            rangeSumBSTHelper(root.left, L, R);
            rangeSumBSTHelper(root.right, L, R);
        }
    }
}
