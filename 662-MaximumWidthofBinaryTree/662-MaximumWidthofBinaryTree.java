/*

662. Maximum Width of Binary Tree
Medium

Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:

Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

Example 2:

Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Example 3:

Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).

Example 4:

Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).

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
// import javafx.util.Pair;
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        //bfs approach
        if(root == null) return 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair(root, 1)); //1 is the index
        int max = 0;
        while(!q.isEmpty()){
            int len = q.size();
            int left = -1;
            int right = -1;
            for(int i = 0; i < len; i++){
                Pair<TreeNode, Integer> pair = q.poll();
                if(i == 0) left = pair.getValue();
                if(i == len - 1) right = pair.getValue();
                if(pair.getKey().left != null) q.add(new Pair(pair.getKey().left, pair.getValue() * 2));
                if(pair.getKey().right != null) q.add(new Pair(pair.getKey().right, pair.getValue() * 2 + 1));
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
