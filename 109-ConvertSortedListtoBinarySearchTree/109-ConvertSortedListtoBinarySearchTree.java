/*

109. Convert Sorted List to Binary Search Tree
Medium

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        // A1 = create a sorted integer array from list and create bst
        // A2 = similar to what we do for array. Go to middle and find left and right
        return dfs(head);
    }
    private TreeNode dfs(ListNode head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        prev.next = null; //breaking connection
        TreeNode root = new TreeNode(slow.val);
        root.left = dfs(head);
        root.right = dfs(slow.next);
        return root;
    }
}
