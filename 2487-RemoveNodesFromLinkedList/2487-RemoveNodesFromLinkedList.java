/*

2487. Remove Nodes From Linked List

You are given the head of a linked list.

Remove every node which has a node with a greater value anywhere to the right side of it.

Return the head of the modified linked list.

Example 1:

Input: head = [5,2,13,3,8]
Output: [13,8]
Explanation: The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.

Example 2:

Input: head = [1,1,1,1]
Output: [1,1,1,1]
Explanation: Every node has value 1, so no nodes are removed.

Constraints:

    The number of the nodes in the given list is in the range [1, 105].
    1 <= Node.val <= 105

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode newHead = new ListNode(0);
        Stack<Integer> s = new Stack<>();
        while(head != null){
            s.push(head.val);
            head = head.next;
        }
        int rightMax = Integer.MIN_VALUE;
        ListNode temp = newHead;
        Stack<Integer> s2 = new Stack<>();
        while(!s.isEmpty()){
            int curr = s.pop();
            if(curr >= rightMax){
                rightMax = curr;
                s2.push(curr);
            }
        }
        while(!s2.isEmpty()){
            temp.next = new ListNode(s2.pop());
            temp = temp.next;
        }
        return newHead.next;
    }
}
