/*

1522. Diameter of N-Ary Tree
Medium

Given a root of an N-ary tree, you need to compute the length of the diameter of the tree.

The diameter of an N-ary tree is the length of the longest path between any two nodes in the tree. This path may or may not pass through the root.

(Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value.)

Example 1:

Input: root = [1,null,3,2,4,null,5,6]
Output: 3
Explanation: Diameter is shown in red color.

Example 2:

Input: root = [1,null,2,null,3,4,null,5,null,6]
Output: 4

Example 3:

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: 7

Constraints:

    The depth of the n-ary tree is less than or equal to 1000.
    The total number of nodes is between [0, 10^4].

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int diameter(Node root) {
        if(root == null) return 0;
        int[] res = new int[]{0};
        dfs(root, res);
        return res[0];
    }
    private int dfs(Node node, int[] res){
        if(node == null) return 0;
        int max1 = 0, max2 = 0;
        for(Node n : node.children){
            int h = dfs(n, res);
            if(h > max1){
                max2 = max1;
                max1 = h;
            }
            else if(h > max2){
                max2 = h;
            }
        }
        res[0] = Math.max(res[0], max1 + max2);
        return max1 + 1;
    }
}
