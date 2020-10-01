/*

1602. Find Nearest Right Node in Binary Tree
Medium

Given the root of a binary tree and a node u in the tree, return the nearest node on the same level that is to the right of u, or return null if u is the rightmost node in its level.

Example 1:

Input: root = [1,2,3,null,4,5,6], u = 4
Output: 5
Explanation: The nearest node on the same level to the right of node 4 is node 5.

Example 2:

Input: root = [3,null,4,2], u = 2
Output: null
Explanation: There are no nodes to the right of 2.

Example 3:

Input: root = [1], u = 1
Output: null

Example 4:

Input: root = [3,4,2,null,null,null,1], u = 4
Output: 2

Constraints:

    The number of nodes in the tree is in the range [1, 105].
    1 <= Node.val <= 105
    All values in the tree are distinct.
    u is a node in the binary tree rooted at root.

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
    public TreeNode findNeartestRightNode(TreeNode root, TreeNode u) {
        if(root == null || u == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                TreeNode temp = q.poll();
                if(temp.val == u.val) return i == len - 1 ? null : q.peek();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
        return null;
    }
}
