/*

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

Question Link : https://leetcode.com/problems/merge-two-sorted-lists/

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  
        ListNode res=dummyHead;
        while (l1!=null || l2 !=null)
        {
            if(l1==null && l2 !=null)
            {
                res.next= new ListNode(l2.val);
                l2=l2.next;
            }
            else if(l2==null && l1!=null )
            {
                res.next= new ListNode(l1.val);
                l1=l1.next;
            }
            else{
                if (l1.val <= l2.val)
                {
                     res.next= new ListNode(l1.val);
                     l1=l1.next;
                }
                else
                {
                     res.next= new ListNode(l2.val);
                     l2=l2.next;
                }
            }
            res=res.next;
        }
        return dummyHead.next; 
    }
}
