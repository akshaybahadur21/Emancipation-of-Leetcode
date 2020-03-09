/*

426. Convert Binary Search Tree to Sorted Doubly Linked List
Medium
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.

Example 1:

Input: root = [4,2,5,1,3]


Output: [1,2,3,4,5]

Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.

Example 2:

Input: root = [2,1,3]
Output: [1,2,3]
Example 3:

Input: root = []
Output: []
Explanation: Input is an empty tree. Output is also an empty Linked List.
Example 4:

Input: root = [1]
Output: [1]
 

Constraints:

-1000 <= Node.val <= 1000
Node.left.val < Node.val < Node.right.val
All values of Node.val are unique.
0 <= Number of Nodes <= 2000

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    //Approach 1
    // perform inorder and get a sorted array.
    // traverse array and return list
    List<Integer> list;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        list = new ArrayList<>();
        inorder(root);
        Node prev = new Node(0);
        Node head = prev;
        for(int i = 0; i<list.size(); i++){
            Node node = new Node(list.get(i));
            node.left = prev;
            prev.right = node;
            prev = node;
        }
        head.right.left = prev;
        prev.right = head.right;
        return head.right;
    }
    
    private void inorder(Node node){
        if (node == null) return;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    //Approach 2
    // perform inorder and create doubly linked list
    Node prev;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node head = new Node(0);
        prev = head;
        inorder(root);
        head.right.left = prev;
        prev.right = head.right;
        return head.right;
    }
    
    private void inorder(Node node){
        if (node == null) return;
        inorder(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        inorder(node.right);
    }
}
