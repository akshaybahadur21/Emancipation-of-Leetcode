/*
206. Reverse Linked List
Easy

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

Link : https://leetcode.com/problems/reverse-linked-list/

*/

//Recursive credits Sarthak Tyagi

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        
        if (head.next==null)
            return head;
           
        ListNode newHead = reverseList(head.next);
        head.next.next= head;
        head.next=null;
        return newHead;

    }
}

// Stacks
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null)
            return null;
        
        Stack<ListNode> s = new Stack<>();
        while(head!=null)
        {
            s.push(head);
            head=head.next;
        }
        ListNode newHead = (ListNode) s.pop();
        ListNode flag= newHead;
        while(!s.isEmpty()){
            newHead = s.pop();
    		newHead.next.next = newHead;
    		newHead.next = null;
        }
        return flag;

    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
