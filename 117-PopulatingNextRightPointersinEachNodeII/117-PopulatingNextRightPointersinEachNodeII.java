/*

117. Populating Next Right Pointers in Each Node II
Medium

Given a binary tree

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

Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

 

Constraints:

    The number of nodes in the given tree is less than 6000.
    -100 <= node.val <= 100

Link : https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

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
        
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        
        q1.add(root);
        while (true){
            while(!q1.isEmpty()){
                Node temp1 = q1.poll();
                
                if (q1.isEmpty())
                    temp1.next = null;
                else
                    temp1.next = q1.peek();

                if (temp1.left != null)
                    q2.add(temp1.left);
                if (temp1.right != null)
                    q2.add(temp1.right);
            }
            while(!q2.isEmpty()){
                Node temp2 = q2.poll();
                
                if (q2.isEmpty())
                    temp2.next = null;
                else
                    temp2.next = q2.peek();
                
                if (temp2.left != null)
                    q1.add(temp2.left);
                if (temp2.right != null)
                    q1.add(temp2.right);
            }
            if (q1.isEmpty() && q2.isEmpty())
                break;
        }
        return root;
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            for (int i = 0 ; i < len; i++){
                Node temp = q.poll();
                if(i != len - 1)
                    temp.next = q.peek();
                else
                    temp.next = null;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
        return root;
        
    }
}

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
        Node first = root;
        while(root != null){
            Node temp = new Node(0);
            Node cursor = temp;
            while(root != null){
                if(root.left != null){
                    cursor.next = root.left;
                    cursor = cursor.next;
                }
                if(root.right != null){
                    cursor.next = root.right;
                    cursor = cursor.next;
                }
                root = root.next;
            }
            root = temp.next;
            temp.next = null;
        }
        return first;
    }
}
