/*

783. Minimum Distance Between BST Nodes
Easy

Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \    
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.

Note:

    The size of the BST will be between 2 and 100.
    The BST is always valid, each node's value is an integer, and each node's value is different.
    This question is the same as 530: https://leetcode.com/problems/minimum-absolute-difference-in-bst/

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
    //Apprach 1 
    // Perform inorder and perform comparisions
    List<Integer> tempList;
    public int minDiffInBST(TreeNode root) {
        tempList = new ArrayList<>();
        inorder(root); 
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<tempList.size() - 1; i++)
            min = Math.min(min, Math.abs(tempList.get(i) - tempList.get(i + 1)));
        return min;
    }
    
    private void inorder(TreeNode node){
        if (node == null) return;
        inorder(node.left);
        tempList.add(node.val);
        inorder(node.right);
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
    //Apprach 2
    // Perform inorder and compare at runtime
    
    Integer min = Integer.MAX_VALUE, prev = null;
    public int minDiffInBST(TreeNode root) {
        inorder(root); 
        return min;
    }
    
    private void inorder(TreeNode node){
        if (node == null) return;
        inorder(node.left);
        if(prev != null)
            min = Math.min(min, Math.abs(prev - node.val));
        prev = node.val;
        inorder(node.right);
    }
}
