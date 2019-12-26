/*

993. Cousins in Binary Tree
Easy

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.


Example 1:

Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:

Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:

Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

Note:

    The number of nodes in the tree will be between 2 and 100.
    Each node has a unique integer value from 1 to 100.

Link : https://leetcode.com/problems/cousins-in-binary-tree/

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
    //traverse bfs
    //maintain a hashmap for parent - child relationship (used to check if nodes are cousins or siblings)
    //maintain 2 queues for alternate depths
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        Map <Integer, Integer> parentChildMap = new HashMap<>();
        boolean OneNodeExists = false;
        int count = 0;
        q1.add(root);
        while(true){
            if (q1.isEmpty() && q2.isEmpty())
                return false;
            while(!q1.isEmpty()){
                TreeNode temp = q1.poll();
                if (temp.val == x || temp.val == y)
                {
                    if(OneNodeExists){
                        if(parentChildMap.get(x) != parentChildMap.get(y))
                            return true;
                        else
                            return false;
                    }
                    OneNodeExists = true;
                }
                if(temp.left != null){
                    parentChildMap.put(temp.left.val, temp.val);
                    q2.add(temp.left);
                }
                if(temp.right != null){
                    parentChildMap.put(temp.right.val, temp.val);
                    q2.add(temp.right);
                }
            }
            OneNodeExists = false;
            while(!q2.isEmpty()){
                TreeNode temp = q2.poll();
                if (temp.val == x || temp.val == y)
                {
                    if(OneNodeExists){
                        if(parentChildMap.get(x) != parentChildMap.get(y))
                            return true;
                        else
                            return false;
                    }
                    OneNodeExists = true;
                }
                if(temp.left != null){
                    parentChildMap.put(temp.left.val, temp.val);
                    q1.add(temp.left);
                }
                if(temp.right != null){
                    parentChildMap.put(temp.right.val, temp.val);
                    q1.add(temp.right);
                }
            }
            OneNodeExists = false;
        }
    }
}
