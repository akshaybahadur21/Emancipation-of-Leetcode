/*

116. Populating Next Right Pointers in Each Node
Medium

You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

    You may only use constant extra space.
    Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.

 

Example 1:

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

 

Constraints:

    The number of nodes in the given tree is less than 4096.
    -1000 <= node.val <= 1000

Link : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        int prevCount = 0;
        while(!q.isEmpty()){
            count++;
            Node temp = q.poll();
            if (count == Math.pow(2,prevCount)){
                count = 0;
                prevCount++;
                temp.next = null;
            }
            else
                temp.next = q.peek();
            
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)    
                q.add(temp.right);
        }       
        return root;
        
    }
}
