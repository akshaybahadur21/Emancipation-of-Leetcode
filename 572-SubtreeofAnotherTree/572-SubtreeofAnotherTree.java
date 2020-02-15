/*

572. Subtree of Another Tree
Easy

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2

Given tree t:

   4 
  / \
 1   2

Return true, because t has the same structure and node values with a subtree of s.

Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0

Given tree t:

   4
  / \
 1   2

Return false. 

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //1st approach - traverse everynode and check for sameTree 
        //2nd approach - Modified Preorder Approach
        
        if (s == null && t != null || t == null && s != null)
            return false;
        if (s == null || t == null)
            return true;
        
        //Traversal can be done using bfs or dfs
        Queue<TreeNode> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()){
            int len = q.size();
            for (int i = 0; i<len; i++){
                TreeNode temp = q.poll();
                if (temp.val == t.val){
                    if (sameTree(temp, t))
                        return true;
                }
                
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
        return false;
    }
    
    private boolean sameTree(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null && t2 != null)
            return false;
        if (t2 == null && t1 != null)
            return false;
        if (t1.val != t2.val)
            return false;
        
        return sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //1st approach - Traverse everynode and check for sameTree 
        //2nd approach - Preorder Approach
        
        if (s == null && t != null || t == null && s != null)
            return false;
        if (s == null || t == null)
            return true;
        StringBuilder sres = new StringBuilder();
        dfs(s, sres);
        String sString = sres.toString();
        
        StringBuilder tres = new StringBuilder();
        dfs(t, tres);
        String tString = tres.toString();
        
        if (sString.contains(tString))
            return true;
        return false;
           
    }
    private void dfs(TreeNode node, StringBuilder sb){
        if (node == null) {
            sb.append("#");
            return;
        }
        sb.append ("," + node.val);
        dfs(node.left, sb);
        dfs(node.right, sb);
    }
}
