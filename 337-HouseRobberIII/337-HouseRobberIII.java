/*

337. House Robber III
Medium

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.

*/

class Solution {
    public int rob(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode node){
        if(node == null) return 0;
        int val = 0;
        if(node.left != null)
            val += dfs(node.left.left) + dfs(node.left.right);
        if(node.right != null)
            val += dfs(node.right.left) + dfs(node.right.right);
        return Math.max(val + node.val, dfs(node.left) + dfs(node.right));
            
    }
}

class Solution {
    public int rob(TreeNode root) {
        return dfs(root, new HashMap<>());
    }
    private int dfs(TreeNode node, HashMap<TreeNode, Integer> map){
        if(node == null) return 0;
        if(map.containsKey(node)) return map.get(node);
        int val = 0;
        if(node.left != null)
            val += dfs(node.left.left, map) + dfs(node.left.right, map);
        if(node.right != null)
            val += dfs(node.right.left, map) + dfs(node.right.right, map);
        int res = Math.max(val + node.val, dfs(node.left, map) + dfs(node.right, map));
        map.put(node, res);
        return res;
    }
}
