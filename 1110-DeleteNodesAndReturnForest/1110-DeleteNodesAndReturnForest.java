/*

1110. Delete Nodes And Return Forest
Medium

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

Example 1:

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]

Constraints:

    The number of nodes in the given tree is at most 1000.
    Each node has a distinct value between 1 and 1000.
    to_delete.length <= 1000
    to_delete contains distinct values between 1 and 1000.

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
    Set<Integer> toDelete = new HashSet<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete)
            toDelete.add(i);
        dfs(root, true);
        return res;
    }
    private TreeNode dfs(TreeNode node, boolean isRoot){
        if (node == null) return null;
        boolean delete = toDelete.contains(node.val);
        if (isRoot && !delete) res.add(node);
        node.left = dfs(node.left, delete);
        node.right = dfs(node.right, delete);
        return delete ? null : node;
    }
}
