/*

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (n<=0)
            return null;
        
        
        ListNode first=head;
        ListNode last=head;
        
        for (int i=0;i<n;i++)
        {
            if (last.next == null)
            { 
                head=head.next;
                return head;
            }
            last=last.next;
        }
        
        while (last.next!=null){
            first=first.next;
            last=last.next;
        }
        first.next=first.next.next;
        return head;
        
    }
}
