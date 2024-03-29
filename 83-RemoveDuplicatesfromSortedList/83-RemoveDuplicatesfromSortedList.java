/*

83. Remove Duplicates from Sorted List
Easy

Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2

Example 2:

Input: 1->1->2->3->3
Output: 1->2->3

Link : https://leetcode.com/problems/remove-duplicates-from-sorted-list/

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;
        
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}

//2 pointer approach
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        while(p2!=null){
            if (p1.val == p2.val){
                p1.next = p2.next;
                p2 = p1.next;
            }
            else{
                p1 = p1.next;
                p2 = p1.next;
            }
        }
        return head;
    }
}
