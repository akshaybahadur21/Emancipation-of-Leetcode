/*

99. Recover Binary Search Tree
Hard

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2

Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3

Follow up:

    A solution using O(n) space is pretty straight forward.
    Could you devise a constant space solution?

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
    private TreeNode first;
    private TreeNode second;
    private TreeNode pre;
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        pre = null;
        inorder(root);
        swap();
    }
    
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        
        if(first == null && (pre == null || pre.val >= root.val))
            first = pre;
        if(first != null && pre.val >= root.val)
            second = root;
        pre = root;
        
        inorder(root.right);
    }
    
    private void swap(){
        if(first == null || second == null) return;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
