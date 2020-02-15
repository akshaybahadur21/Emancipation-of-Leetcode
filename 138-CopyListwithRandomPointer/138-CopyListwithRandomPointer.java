/*

138. Copy List with Random Pointer
Medium

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.

Example 1:

Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

Example 2:

Input: head = [[1,1],[2,1]]
Output: [[1,1],[2,1]]

Example 3:

Input: head = [[3,null],[3,0],[3,null]]
Output: [[3,null],[3,0],[3,null]]

Example 4:

Input: head = []
Output: []
Explanation: Given linked list is empty (null pointer), so return null.

Constraints:

    -10000 <= Node.val <= 10000
    Node.random is null or pointing to a node in the linked list.
    Number of Nodes will not exceed 1000.

*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        // 1st approach - Use a hashmap and store copies of the node.
        if (head == null) return null;
        Map<Node, Node> lookupMap = new HashMap<>();
        Node temp = head;
        while(temp != null){    //creating copy
            lookupMap.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        
        temp = head;
        while(temp != null){
            lookupMap.get(temp).next = lookupMap.get(temp.next);
            lookupMap.get(temp).random = lookupMap.get(temp.random);
            temp = temp.next;
        }
        return lookupMap.get(head);
    }
}

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        // 2nd Approach - Don't use a hashmap (save space) and just use O(1) space
        if (head == null) return null;
        Node temp = head;
        while(temp != null){ // create copy nodes and attach it to node.next
            Node nxt = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = nxt;
            temp = nxt;
        }
        temp = head;
        while(temp != null){ //copy random pointers
            if (temp.random != null){
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next; //skipping to next in original list
        }
        temp = head;
        Node pseudoHead = head.next;
        while(temp != null){ // extract the deep copy and possibly restore the original list
            Node next = temp.next.next;
            Node copy = temp.next;
            temp.next = next;
            if (next != null)
                copy.next = next.next;
            temp = next;
        }
        return pseudoHead;
    }
}
