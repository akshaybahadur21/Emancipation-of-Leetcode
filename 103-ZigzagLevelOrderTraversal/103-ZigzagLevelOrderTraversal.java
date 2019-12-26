Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]


Link : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

// 2 stacks

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> resList = new ArrayList<>();
        if (root==null)
            return resList;
        
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty())
            {
                resList.add(getZigzagLevelOrder(stack1,stack2));
            }
        return resList;
    }
    
    public static List getZigzagLevelOrder(Stack<TreeNode> stack1, Stack<TreeNode> stack2)
    {
        List<Integer> r1=new ArrayList<>();
        
        while(!stack1.isEmpty())
            {
                TreeNode tempNode=stack1.pop();
                if(tempNode.left !=null)
                    stack2.push(tempNode.left);
                if(tempNode.right != null)
                    stack2.push(tempNode.right);
                r1.add(tempNode.val);
            }
        if(!r1.isEmpty())
            return r1;

        while(!stack2.isEmpty())
            {
                TreeNode tempNode=stack2.pop();
                if(tempNode.right !=null)
                    stack1.push(tempNode.right);
                if(tempNode.left != null)
                   stack1.push(tempNode.left);
                r1.add(tempNode.val);
            }
        return r1;
        }

    }
