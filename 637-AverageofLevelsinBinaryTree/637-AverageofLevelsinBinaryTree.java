/*

637. Average of Levels in Binary Tree
Easy
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:

Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

Note:

    The range of node's value is in the range of 32-bit signed integer.


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
    public List<Double> averageOfLevels(TreeNode root) {
        //use only one queue and maintain size
        List<Double> resList = new LinkedList<>();
        if (root == null)
            return resList;
        Queue<TreeNode> q = new LinkedList<>();
        double sum =0.0;
        q.add(root);
        while(!q.isEmpty()){
            double len = Double.valueOf(q.size());
            for(int i =0; i<len; i++){
                TreeNode temp = q.poll();
                sum+= temp.val;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            double r = Double.valueOf(sum/len);
            resList.add(r);
            sum = 0;
        }
      return resList;  
    }
}
