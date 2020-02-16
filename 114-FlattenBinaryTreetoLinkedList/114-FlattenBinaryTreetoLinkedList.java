/*

114. Flatten Binary Tree to Linked List
Medium

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

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
     TreeNode newRoot = new TreeNode(0);
    public void flatten(TreeNode root) {
        //preorder traversal
        if (root == null)
            return ;
        //do preorder
        preOrder(root);
        root = newRoot.right;
    }
    
    private void preOrder(TreeNode node){
        // Not the correct approach since you are creating a newRoot and linking
        // Correct approach would be just updating the correct links as you traverse
        if(node == null) return;
        TreeNode L = node.left;
        TreeNode R = node.right;
        newRoot.right = node;
        node.left = null;
        node.right = null;
        newRoot = newRoot.right;
        preOrder(L);
        preOrder(R);
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
     TreeNode previous = null;
    public void flatten(TreeNode root) {
        //postorder traversal
        // A good approach is to go to the rightmost node and then traverse backwards until you traverse every node
        if (root == null)
            return ;
        flatten(root.right);
        flatten(root.left);
        root.right = previous;
        root.left = null;
        previous = root;
    }
}
