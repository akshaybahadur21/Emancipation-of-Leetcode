/*

987. Vertical Order Traversal of a Binary Tree
Medium

Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 

Example 1:

Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).

Example 2:

Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.

 

Note:

    The tree will have between 1 and 1000 nodes.
    Each node's value will be between 0 and 1000.

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
    Map<Integer, List<Integer>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //dfs did not work because of the irregularity in depth
        // we can try bfs
        map = new TreeMap<>();
        dfs(root,0);
        return new ArrayList<>(map.values());
    }
    private void dfs(TreeNode node, int vLevel){
        if (node == null) return;
        if (map.containsKey(vLevel))
            map.get(vLevel).add(node.val);
        else{
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            map.put(vLevel, temp);
        }
        dfs(node.left, vLevel - 1);
        dfs(node.right, vLevel + 1);
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
    Map<Integer, List<Integer>> map;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //dfs did not work because of the irregularity in depth
        // we can try bfs
        map = new TreeMap<>();
        bfs(root);
        return new ArrayList<>(map.values());
    }
    private void bfs(TreeNode root){
        if (root == null) return;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int l = q.size();
            for(int i = 0; i < l; i++){
                Pair p = q.poll();
                TreeNode node = (TreeNode)p.getKey();
                int vLevel = (int)p.getValue();
                if (map.containsKey(vLevel))
                    map.get(vLevel).add(node.val);
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(node.val);
                    map.put(vLevel, temp);
                }
               if(node.left != null) q.add(new Pair(node.left, vLevel - 1));
               if(node.right != null) q.add(new Pair(node.right, vLevel + 1));
            }
        }
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) 
            map.put(x, new TreeMap<>());
        if (!map.get(x).containsKey(y)) 
            map.get(x).put(y, new PriorityQueue<>());
        map.get(x).get(y).add(root.val);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
}
