/*

113. Path Sum II
Medium

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

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
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return resList;
        dfs(root, sum, new ArrayList<>());
        return resList;
    }
    
    private void dfs(TreeNode node, int sum, List list){
        if (node == null) return; 
        list.add(node.val);
        if (sum == node.val && node.left == null && node.right == null)
            resList.add(new ArrayList<Integer>(list));
        else {
            dfs(node.left, sum - node.val, list);
            dfs(node.right, sum - node.val, list);
        }
        list.remove(list.size() - 1);
    }
}
