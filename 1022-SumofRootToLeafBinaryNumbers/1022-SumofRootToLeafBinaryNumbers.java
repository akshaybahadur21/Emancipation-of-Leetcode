/*

1022. Sum of Root To Leaf Binary Numbers
Easy

Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.

Example 1:

Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

 

Note:

    The number of nodes in the tree is between 1 and 1000.
    node.val is 0 or 1.
    The answer will not exceed 2^31 - 1.

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
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;
        List<String> list = new ArrayList<>();
        dfs(root, list, new StringBuilder());
        int res = 0;
        for(String l : list)
            res += getIntFromBinary(l);
        return res;
    }
    private void dfs(TreeNode node, List<String> list, StringBuilder sb){
        if(node == null) return;
        if(node.left == null && node.right == null){
            sb.append(node.val);
            list.add(new String(sb.toString()));
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        sb.append(node.val);
        dfs(node.left, list, sb);
        dfs(node.right, list, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    
    private int getIntFromBinary(String s){
        int res = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            int temp = Character.getNumericValue(s.charAt(i));
            res += temp * Math.pow(2, (s.length() -1) - i);
        }
        return res;
    }
}
