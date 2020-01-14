/*

1161. Maximum Level Sum of a Binary Tree
Medium

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

Example 1:

Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.

Note:

    The number of nodes in the given tree is between 1 and 10^4.
    -10^5 <= node.val <= 10^5

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
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        int level= 1;
        int res = level;
        while(!q.isEmpty()){
            int len = q.size();
            int localMax = 0;
            for (int i =0; i<len ; i++){
                TreeNode temp = q.poll();
                localMax += temp.val;
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }
            if(localMax > max){
                res = level;
                max = localMax;
            }
            level++;
        }
        return res;
    }
}
