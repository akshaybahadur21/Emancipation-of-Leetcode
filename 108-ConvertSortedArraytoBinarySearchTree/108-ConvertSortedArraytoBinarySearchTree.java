/*

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5

Link : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Approach : Recursive from centre (binary search)

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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if (nums.length==0)
            return null;
        
        return getSortedArrayToBST(nums, 0, nums.length-1);
        
    }
    
    public static TreeNode getSortedArrayToBST( int[] nums, int start, int last)
    {
        if (start>last)
            return null;
        
        int mid= (start+last)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left= getSortedArrayToBST(nums, start, mid-1);
        node.right= getSortedArrayToBST(nums, mid+1, last);
        return node;
    }
}
