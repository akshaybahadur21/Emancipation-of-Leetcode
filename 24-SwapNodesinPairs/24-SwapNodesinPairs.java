/*

Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

 

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.


Question : https://leetcode.com/problems/swap-nodes-in-pairs/

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
    public ListNode swapPairs(ListNode head) {
        
        if(head == null)
            return null;
        if(head.next==null)
            return head;
        
        ListNode first = head;
        ListNode newHead=first.next;
        ListNode second;
        ListNode temp;
        while (true)
        {
            second=first.next;
            temp=second.next;
            second.next=first;
            
            if (temp==null)
            {
                first.next=null;
                break;
            }
            if (temp.next ==null)
            {
                first.next=temp;
                first.next.next=null;
                break;
            }
            
            first.next=temp.next;
            first=temp;
        }
        return newHead;
}
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while(head != null){
            while(head != null && stack.size() < 2){
                stack.push(head);
                head = head.next;
            }
            while(!stack.isEmpty()){
                temp.next = new ListNode(stack.pop().val);
                temp = temp.next;
            }
        }
        return newHead.next;
    }
}
