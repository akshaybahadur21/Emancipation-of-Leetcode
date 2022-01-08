/*

863. All Nodes Distance K in Binary Tree
Medium

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.

Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.

Note:

    The given tree is non-empty.
    Each node in the tree has unique values 0 <= node.val <= 500.
    The target node is a node in the tree.
    0 <= K <= 1000.

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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // Basically you need to have 3 links from targert -> left, right and parent 
        // Explore all those 3 links upto K and add them to result
        // Create a map for annotating parent and child
        Map<TreeNode, TreeNode> parentChildMap = createParentChildMap(root);
        List<Integer> resList = new ArrayList<>();
        if (root == null || target == null)
            return resList;
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.add(target);
        while(K != 0){
            int len = q.size();
            for (int i =0; i< len ; i++){
                TreeNode temp = q.poll();
                if (temp.left != null && visited.add(temp.left)) q.add(temp.left);
                if (temp.right != null && visited.add(temp.right)) q.add(temp.right);
                if (parentChildMap.containsKey(temp) && visited.add(parentChildMap.get(temp)))
                    q.add(parentChildMap.get(temp)); // adding parent
            }
            K--;
        }
        while(!q.isEmpty())
            resList.add(q.poll().val);
        return resList;
    }
    
    private Map createParentChildMap(TreeNode root){
        Map<TreeNode, TreeNode> map = new HashMap<>();
        //You can create this map using dfs or bfs
        fillMap(root,null,map);
        return map;
    }
    private void fillMap(TreeNode node, TreeNode parent, Map map){
        if(node == null)
            return;
        if(!map.containsKey(node)){
            if (parent != null)
                map.put(node, parent);
            fillMap(node.left, node, map);
            fillMap(node.right, node, map);
        }
    }
}
