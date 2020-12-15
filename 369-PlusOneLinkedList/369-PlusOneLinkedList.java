/*

369. Plus One Linked List
Medium

Given a non-negative integer represented as a linked list of digits, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list.

Example 1:

Input: head = [1,2,3]
Output: [1,2,4]

Example 2:

Input: head = [0]
Output: [1]

Constraints:

    The number of nodes in the linked list is in the range [1, 100].
    0 <= Node.val <= 9
    The number represented by the linked list does not contain leading zeros except for the zero itself. 

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
    //Use stack
    int carry = 1;
    public ListNode plusOne(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> ns = new Stack<>();
        while(head!= null){
            stack.push(head.val);
            head = head.next;
        }
        while(!stack.isEmpty()){
            int curr = stack.pop() + carry;
            carry = curr >= 10 ? 1 : 0;
            curr %= 10;
            ns.push(curr);
        }
        if(carry > 0) ns.push(carry);
        ListNode newHead = new ListNode(0);
        head = newHead;
        while(!ns.isEmpty()){
            head.next = new ListNode(ns.pop());
            head = head.next;
        }
        return newHead.next;
    }
}
