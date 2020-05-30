/*

1120. Maximum Average Subtree
Medium
Given the root of a binary tree, find the maximum average value of any subtree of that tree.

(A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of its values, divided by the number of nodes.)

Example 1:

Input: [5,6,1]
Output: 6.00000
Explanation: 
For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
For the node with value = 6 we have an average of 6 / 1 = 6.
For the node with value = 1 we have an average of 1 / 1 = 1.
So the answer is 6 which is the maximum.
 

Note:

The number of nodes in the tree is between 1 and 5000.
Each node will have a value between 0 and 100000.
Answers will be accepted as correct if they are within 10^-5 of the correct answer.

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
    double max = 0.0;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }
    private int[] dfs(TreeNode node){
        if(node == null) return new int[]{0, 0};
        int sum = node.val;
        int num = 1;
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        sum += left[0] + right[0];
        num += left[1] + right[1];
        
        max = Math.max(max, (double)sum / (double)num );
        return new int[]{sum, num};
    }
}
