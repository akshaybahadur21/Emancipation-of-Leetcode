/*

1315. Sum of Nodes with Even-Valued Grandparent
Medium

Given a binary tree, return the sum of values of nodes with even-valued grandparent.  (A grandparent of a node is the parent of its parent, if it exists.)

If there are no nodes with an even-valued grandparent, return 0.

Example 1:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

Constraints:

    The number of nodes in the tree is between 1 and 10^4.
    The value of nodes is between 1 and 100.

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
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i =0; i<len; i++){
                TreeNode temp = q.poll();
                if (temp.left != null) {
                    q.add(temp.left);
                    if (temp.val %2 == 0){
                        if (temp.left.left != null)
                            res+= temp.left.left.val;
                        if (temp.left.right != null)
                            res+= temp.left.right.val;
                        }
                }
                if (temp.right != null) {
                    q.add(temp.right);
                     if (temp.val %2 == 0){
                         if (temp.right.left != null)
                             res+= temp.right.left.val;
                          if (temp.right.right != null)
                             res+= temp.right.right.val; 
                     }
                }
            }
        }
        return res;
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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        //Approach 2
        // DFS
        dfs(root);
        return sum;
    }
    private void dfs(TreeNode node){
        if (node == null) return;
        if(node.val %2 == 0){
            if (node.left != null && node.left.left != null)
                sum+= node.left.left.val;
            if (node.left != null && node.left.right != null)
              sum += node.left.right.val;
            if (node.right != null && node.right.left != null)
                 sum += node.right.left.val;
            if (node.right != null && node.right.right != null)
                sum += node.right.right.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
