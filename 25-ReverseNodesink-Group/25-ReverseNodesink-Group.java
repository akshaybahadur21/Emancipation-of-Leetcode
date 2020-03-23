/*

25. Reverse Nodes in k-Group
Hard

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

    Only constant extra memory is allowed.
    You may not alter the values in the list's nodes, only nodes itself may be changed.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        Stack<ListNode> s = new Stack<>();
        ListNode pseudoHead = new ListNode(0);
        ListNode pseudotemp = pseudoHead;
        ListNode temp = head;
        int len = getLength(temp, k);
        for (int i = 0; i< len/k; i++){
            int count = 0;
            while(count++ != k){
                ListNode t = head.next;
                s.push(head);
                head.next = null;
                head = t;
            }
            while(!s.isEmpty()){
                pseudotemp.next = s.pop();
                pseudotemp = pseudotemp.next;
            }
        }
        pseudotemp.next = head;
        return pseudoHead.next;
        
    }
    
    private int getLength(ListNode temp, int k){
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}
