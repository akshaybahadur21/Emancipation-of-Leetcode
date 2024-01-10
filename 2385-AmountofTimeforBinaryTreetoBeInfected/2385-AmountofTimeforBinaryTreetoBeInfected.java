/*

2385. Amount of Time for Binary Tree to Be Infected
Medium

You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.

Each minute, a node becomes infected if:

    The node is currently uninfected.
    The node is adjacent to an infected node.

Return the number of minutes needed for the entire tree to be infected.

Example 1:

Input: root = [1,5,3,null,4,10,6,9,2], start = 3
Output: 4
Explanation: The following nodes are infected during:
- Minute 0: Node 3
- Minute 1: Nodes 1, 10 and 6
- Minute 2: Node 5
- Minute 3: Node 4
- Minute 4: Nodes 9 and 2
It takes 4 minutes for the whole tree to be infected so we return 4.

Example 2:

Input: root = [1], start = 1
Output: 0
Explanation: At minute 0, the only node in the tree is infected so we return 0.

Constraints:

    The number of nodes in the tree is in the range [1, 105].
    1 <= Node.val <= 105
    Each node has a unique value.
    A node with a value of start exists in the tree.

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
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> cpmap = new HashMap<>();
        TreeNode[] startNodeArr = new TreeNode[]{null};
        dfs(root, cpmap, null, startNodeArr, start);
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(startNodeArr[0]);
        vis.add(startNodeArr[0].val);
        int res = -1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                TreeNode curr = q.poll();
                if(curr.left != null && !vis.contains(curr.left.val)) q.add(curr.left);
                if(curr.right != null && !vis.contains(curr.right.val)) q.add(curr.right);
                if(cpmap.containsKey(curr) && !vis.contains(cpmap.get(curr).val)) q.add(cpmap.get(curr));
                vis.add(curr.val);
            }
            res++;
        }
        return res;
    }
    private void dfs(TreeNode node, Map<TreeNode, TreeNode> cpmap, TreeNode parent, TreeNode[] startNodeArr, int start){
        if(node == null) return;
        if(node.val == start) startNodeArr[0] = node;
        if(parent != null) cpmap.put(node, parent);
        dfs(node.left, cpmap, node, startNodeArr, start);
        dfs(node.right, cpmap, node, startNodeArr, start);
        
    }
}
