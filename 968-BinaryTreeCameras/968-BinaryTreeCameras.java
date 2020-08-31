/*

968. Binary Tree Cameras
Hard

Given a binary tree, we install cameras on the nodes of the tree. 

Each camera at a node can monitor its parent, itself, and its immediate children.

Calculate the minimum number of cameras needed to monitor all nodes of the tree.

Example 1:

Input: [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.

Example 2:

Input: [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

Note:

    The number of nodes in the given tree will be in the range [1, 1000].
    Every node has value 0.

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
    public int minCameraCover(TreeNode root) {
        // greedy
        // bottom up approach
        // go to the last level and place camera at a level above that
        // now we don't need to add cameras to the last 3 levels
        int[] res = new int[]{0};
        Set<TreeNode> covered = new HashSet<>();
        covered.add(null);
        dfs(root, null, res, covered);
        return res[0];
    }
    private void dfs(TreeNode node, TreeNode parent, int[] res, Set<TreeNode> covered){
        if(node == null) return;
        dfs(node.left, node, res, covered);
        dfs(node.right, node, res, covered);
        if ((parent == null && !covered.contains(node)) 
            || !covered.contains(node.left) || !covered.contains(node.right)){
            res[0]++;
            covered.add(node);
            covered.add(parent);
            covered.add(node.left);
            covered.add(node.right);
        }
        
    }
}
