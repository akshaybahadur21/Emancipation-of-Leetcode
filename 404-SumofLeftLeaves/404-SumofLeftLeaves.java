/*

404. Sum of Left Leaves
Easy

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if (temp.left != null && temp.left.left == null && temp.left.right == null)
                res += temp.left.val;
            if (temp.left !=null) q.add(temp.left);
            if (temp.right !=null) q.add(temp.right);
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
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }
    
    private int dfs(TreeNode node, boolean isLeft){
        if (node  == null)
            return 0;
        if(node.left == null && node.right == null && isLeft)
            return node.val;
        return dfs(node.left, true) + dfs(node.right, false);
    }
}


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
    public int sumOfLeftLeaves(TreeNode root) {
        int[] res = new int[]{0};
        dfs(root, res, false);
        return res[0];
    }

    private void dfs(TreeNode node, int[] res, boolean isLeft){
        if(node == null) return;
        if(node.left == null && node.right == null && isLeft) res[0] += node.val;
        dfs(node.left, res, true);
        dfs(node.right, res, false);
    }
}
