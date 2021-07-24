/*

314. Binary Tree Vertical Order Traversal
Medium

Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]

Example 2:

Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]

Example 3:

Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
Output: [[4],[9,5],[3,0,1],[8,2],[7]]

Example 4:

Input: root = []
Output: []

Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        for(Map.Entry<Integer, List<int[]>> entry : map.entrySet()){
            List<Integer> list = new ArrayList<>();
            List<int[]> temp = entry.getValue();
            Collections.sort(temp, (n1, n2) -> n1[0] - n2[0]);
            for(int[] arr : temp) list.add(arr[1]);
            resList.add(new ArrayList<>(list));
        }
        return resList;
    }
    private void dfs(TreeNode node, int width, int depth,  Map<Integer, List<int[]>> map){
        if(node == null) return;
        map.putIfAbsent(width, new ArrayList<>());
        map.get(width).add(new int[]{depth, node.val});
        dfs(node.left, width - 1, depth + 1, map);
        dfs(node.right, width + 1, depth + 1, map);
    }
}
