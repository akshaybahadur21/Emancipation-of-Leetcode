/*

112. Path Sum
Easy

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.


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
 
 // Recursive solution
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);
    }
    private boolean dfs(TreeNode root, int sum){
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
    return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
    }
}

// Iterative Solution
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        Stack <TreeNode> stack = new Stack<>();
        Stack <Integer> value = new Stack<>();
        stack.push(root);
        value.push(root.val);
        while(!stack.isEmpty()){
            TreeNode tempNode = stack.pop();
            int tempVal = value.pop();
            if (tempNode.left == null && tempNode.right == null && tempVal == sum)
                return true;
            else{
                    if (tempNode.left != null){
                        stack.push(tempNode.left);
                        value.push(tempVal + tempNode.left.val);
                    }
                    if (tempNode.right != null) {
                        stack.push(tempNode.right);
                        value.push(tempVal + tempNode.right.val);
                     }
            }
        }
        return false;
    }
}
