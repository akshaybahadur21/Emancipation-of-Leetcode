/*

Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]

Follow up: Recursive solution is trivial, could you do it iteratively?

Link: https://leetcode.com/problems/binary-tree-inorder-traversal/

*/

//Recursive
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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> resultList = new ArrayList<>(); 
        if (root==null)
            return resultList;
       inorderHelper(root,resultList);
        return resultList;
            
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


//Stack

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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> resultList = new ArrayList<>(); 
        Stack<TreeNode> stack = new Stack<>();
        TreeNode top=root;
        
        if (root==null || !stack.isEmpty())
            return resultList;
        
        while(top != null || !stack.isEmpty()){
        while (top!=null)
        {
            stack.push(top);
            top=top.left;
        }
        top=stack.pop();
        resultList.add(top.val);
        top=top.right;
    }
        return resultList;
    }
}
