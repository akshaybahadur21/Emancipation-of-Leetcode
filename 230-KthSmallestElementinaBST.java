/*

230. Kth Smallest Element in a BST
Medium

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?


Link : https://leetcode.com/problems/kth-smallest-element-in-a-bst/

*/

// Recursion (need more space)

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
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> resultList = new ArrayList<>(); 
        if (root==null)
            return -1;
       inorderHelper(root,resultList);
        if (k>resultList.size())
            return -1;
        return resultList.get(k-1);            
        
    }
    public void inorderHelper(TreeNode root, List <Integer> resultList)
    {
        if  (root != null){
        if (root.left != null)
            inorderHelper(root.left, resultList);
        resultList.add(root.val);
        if (root.right!=null)
            inorderHelper(root.right,resultList);
        }
    }
}
