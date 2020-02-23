/*

1214. Two Sum BSTs

Given two binary search trees, return True if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.

Example 1:

Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
Output: true
Explanation: 2 and 3 sum up to 5.
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
Output: false

Constraints:

Each tree has at most 5000 nodes.
-10^9 <= target, node.val <= 10^9

*/

class Solution {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        //Traverse 1st tree using DFS and search for the compliment in the 2nd tree using BST property.
        if (root1 == null || root2 == null) return false;
        return dfs(root1,root2,target);
    }
    private boolean dfs(TreeNode node, TreeNode root2, int target){
        if (node == null) return false;
        if (searchBST(root2, target - node.val)) return true;
        return dfs(node.left, root2, target) || dfs(node.right, root2, target); 
    }
    
    private boolean searchBST(TreeNode root2, int target){
        if (root2 == null) return false;
        if (root2.val == target) return true;
        if (target > root2.val) 
            return searchBST(root2.right, target);
        else 
            return searchBST(root2.left, target);
    }
}
