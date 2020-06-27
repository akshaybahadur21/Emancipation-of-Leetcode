/*

450. Delete Node in a BST
Medium

Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.

Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7

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
    public TreeNode deleteNode(TreeNode root, int key) {
        // Approach - perform BST dfs to get to the node
        // consider all 3 possibilites if it is a leaf node, or it has one or 2 children
        return dfs(root, key);
    }
    private TreeNode dfs(TreeNode node, int key){
        if(node == null) return null;
        if(key < node.val)
            node.left = dfs(node.left, key);
        else if(key > node.val)
            node.right = dfs(node.right, key);
        else if(node.val == key){
            if(node.left == null && node.right == null) // leaf
                return null;
            else if(node.left == null || node.right == null){ //either left or right child
                if(node.left != null) return node.left;
                else return node.right;
            }
            else{ // both left and right child
                TreeNode successor = findSuccessor(node);
                successor.left = node.left;
                return node.right;
            }
        }
        return node;
    }
    private TreeNode findSuccessor(TreeNode node){
        TreeNode sucessor = node;
        node = node.right;
        while(node != null){
            sucessor = node;
            node = node.left;
        }
        return sucessor;
    }
}
