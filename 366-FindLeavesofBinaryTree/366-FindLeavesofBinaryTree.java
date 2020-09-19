/*

366. Find Leaves of Binary Tree
Medium

Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:

Input: [1,2,3,4,5]
  
          1
         / \
        2   3
       / \     
      4   5    

Output: [[4,5,3],[2],[1]]

Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         / 
        2          

 
2. Now removing the leaf [2] would result in this tree:

          1          

3. Now removing the leaf [1] would result in the empty tree:

          []         

[[3,5,4],[2],[1]], [[3,4,5],[2],[1]], etc, are also consider correct answers since per each level it doesn't matter the order on which elements are returned.

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        while(root != null){
            List<Integer> list = new ArrayList<>();
            root = dfs(root, list);
            if(list.size() > 0) resList.add(list);
        }
        return resList;
    }
    private TreeNode dfs(TreeNode node, List<Integer> list){
        if(node == null) return null;
        TreeNode left = dfs(node.left, list);
        TreeNode right = dfs(node.right, list);
        if(node.left == null && node.right == null){
            list.add(node.val);
            return null;
        }
        node.left = left;
        node.right = right;
        return node;
    }
}
