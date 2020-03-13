/*

1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
Medium

Given two binary trees original and cloned and given a reference to a node target in the original tree.

The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

Follow up: Solve the problem if repeated values on the tree are allowed.

Example 1:

Input: tree = [7,4,3,null,null,6,19], target = 3
Output: 3
Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.

Example 2:

Input: tree = [7], target =  7
Output: 7

Example 3:

Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
Output: 4

Example 4:

Input: tree = [1,2,3,4,5,6,7,8,9,10], target = 5
Output: 5

Example 5:

Input: tree = [1,2,null,3], target = 2
Output: 2

Constraints:

    The number of nodes in the tree is in the range [1, 10^4].
    The values of the nodes of the tree are unique.
    target node is a node from the original tree and is not null.

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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        if (original == null || cloned == null || target == null) return null;
        return dfs(original, cloned, target);
    }
    
    private TreeNode dfs(TreeNode original, TreeNode cloned, TreeNode target){
        if (original == null) return null;
        if (original == target)
            return cloned;
        
        TreeNode left = dfs(original.left, cloned.left, target);
        if (left != null)
            return left;
        
        return dfs(original.right, cloned.right, target);
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
    //Aproach 2 BFS
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        
        if (original == null || cloned == null || target == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(original);
        q.add(cloned);
        while(!q.isEmpty()){
            int len = q.size() / 2;
            for (int i = 0; i< len; i++){
                TreeNode ori = q.poll();
                TreeNode clo = q.poll();
                if (ori == target)
                    return clo;
                
                if (ori.left != null){
                    q.add(ori.left);
                    q.add(clo.left);
                    }
                if (ori.right != null){
                    q.add(ori.right);
                    q.add(clo.right);
                }
            }
        }
        return null;
    }
}
