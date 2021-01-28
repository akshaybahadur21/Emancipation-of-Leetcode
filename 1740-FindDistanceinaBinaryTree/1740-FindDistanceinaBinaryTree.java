/*

1740. Find Distance in a Binary Tree
Easy

Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.

The distance between two nodes is the number of edges on the path from one to the other.

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
Output: 3
Explanation: There are 3 edges between 5 and 0: 5-3-1-0.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 7
Output: 2
Explanation: There are 2 edges between 5 and 7: 5-2-7.

Example 3:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 5
Output: 0
Explanation: The distance between a node and itself is 0.

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    0 <= Node.val <= 109
    All Node.val are unique.
    p and q are values in the tree.

*/



//TLE
class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        // A1 : find first node and then do bfs on all the child and parent node to get the second node
        Map<TreeNode, TreeNode> map = new HashMap<>();
        map.put(root, null);
        generateParentChildPair(root, map);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(getNodeFromInt(root, p));
        int res = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode curr = queue.poll();
                if(curr.val == q) return res;
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
                if(map.get(curr) != null) queue.add(map.get(curr));
            }
            res++;
        }
        return -1;
    }
    private TreeNode getNodeFromInt(TreeNode node, int n){
        if(node == null) return null;
        if(node.val == n) return node;
        TreeNode left = getNodeFromInt(node.left, n);
        if(left != null) return left;
        return getNodeFromInt(node.right, n);
    }
    private void generateParentChildPair(TreeNode node, Map<TreeNode, TreeNode> map){
        if(node == null) return;
        if(node.left != null) map.put(node.left, node);
        if(node.right != null) map.put(node.right, node);
        generateParentChildPair(node.left, map);
        generateParentChildPair(node.right, map);
    }
}
