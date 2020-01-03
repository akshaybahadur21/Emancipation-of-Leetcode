/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3


Link : https://leetcode.com/problems/symmetric-tree/

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
    public boolean isSymmetric(TreeNode node) {
        if (node==null)
            return true;
        return(symmetricTreeHelper(node.left,node.right));
    }
    
    public boolean symmetricTreeHelper(TreeNode p, TreeNode q)
    {
        if(p==null && q==null)
            return true;
        if( p!=null && q==null || q!=null && p==null || p.val!=q.val)
            return false;
        return (symmetricTreeHelper(p.left,q.right)&&symmetricTreeHelper(p.right,q.left));
    }
}

//bfs using stack
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return bfs(root);
    }
    private boolean bfs(TreeNode root){
        Stack<TreeNode> s = new Stack<>();
        s.push(root.left);
        s.push(root.right);
        while(!s.isEmpty()){
            TreeNode p = s.pop();
            TreeNode q = s.pop();
            if (p == null && q == null) 
                continue;
            if (p == null && q!=null || p != null && q == null || p.val != q.val)
                return false;
            s.push(p.left);
            s.push(q.right);
            s.push(p.right);
            s.push(q.left);
        }
        return true;
    }
}
