/*

617. Merge Two Binary Trees
Easy

Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7

Note: The merging process must start from the root nodes of both trees.

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return dfs(t1,t2);
    }
    
    private TreeNode dfs(TreeNode t1, TreeNode t2){
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        
        t1.val+=t2.val;
        t1.left = dfs(t1.left, t2.left);
        t1.right = dfs(t1.right, t2.right);
        return t1;
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(t1,t2));
        while(!q.isEmpty()){
            Pair currPair = q.poll();
            if (currPair.getT2() == null)
                continue;
            currPair.getT1().val += currPair.getT2().val;
            if(currPair.getT1().left == null)
                currPair.getT1().left = currPair.getT2().left;
            else
                q.offer(new Pair(currPair.getT1().left, currPair.getT2().left));
            if(currPair.getT1().right == null)
                 currPair.getT1().right = currPair.getT2().right;
            else
                 q.offer(new Pair(currPair.getT1().right, currPair.getT2().right));
        }
        return t1;
    }
}

public class Pair{
    TreeNode t1;
    TreeNode t2;
    Pair(TreeNode t1, TreeNode t2){
        this.t1=t1;
        this.t2=t2;
    }
    public TreeNode getT1(){
        return t1;
    }
    public TreeNode getT2(){
        return t2;
    }

}
