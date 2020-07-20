/*

203. Remove Linked List Elements
Easy

Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode pseudoHead = new ListNode(0);
        pseudoHead.next = head;
        
        ListNode temp = pseudoHead;
        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return pseudoHead.next;
    }
}
