/*

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]


Question Link : https://leetcode.com/problems/binary-tree-level-order-traversal/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> resList = new ArrayList<>();
        
        if (root==null)
            return resList;
        
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        
        while (!q1.isEmpty() || !q2.isEmpty())
        {
            resList.add(getListPerLevel(q1,q2));
        }
        return resList;
    }
    
    public static List getListPerLevel(Queue<TreeNode> q1, Queue<TreeNode> q2)
    {
        List<Integer> r1=new ArrayList<>();
        while(!q1.isEmpty())
            {
                TreeNode tempNode=q1.remove();
                if(tempNode.left !=null)
                    q2.add(tempNode.left);
                if(tempNode.right != null)
                    q2.add(tempNode.right);
                r1.add(tempNode.val);
            }
        if(!r1.isEmpty())
            return r1;
        while (!q2.isEmpty())
            {
                TreeNode tempNode=q2.remove();
                if(tempNode.left !=null)
                    q1.add(tempNode.left);
                if(tempNode.right != null)
                    q1.add(tempNode.right);
                r1.add(tempNode.val);
            }
            return r1;
    }
}
