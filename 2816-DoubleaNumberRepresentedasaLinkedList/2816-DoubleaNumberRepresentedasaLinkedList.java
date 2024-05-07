/*

2816. Double a Number Represented as a Linked List

You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

Return the head of the linked list after doubling it.

Example 1:

Input: head = [1,8,9]
Output: [3,7,8]
Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.

Example 2:

Input: head = [9,9,9]
Output: [1,9,9,8]
Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 

Constraints:

    The number of nodes in the list is in the range [1, 104]
    0 <= Node.val <= 9
    The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.

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
    public ListNode doubleIt(ListNode head) {
        ListNode newHead = new ListNode(0);
        if(head == null) return head;
        Stack<Integer> s1 = new Stack<>();
        while(head != null){
            s1.push(head.val);
            head = head.next;
        }
        int carry = 0;
        Stack<Integer> s2 = new Stack<>();
        while(!s1.isEmpty()){
            int curr = s1.pop();
            curr = curr * 2 + carry;
            carry = curr/10;
            curr = curr % 10;
            s2.push(curr);
        }
        if(carry > 0) s2.push(carry);
        ListNode temp = newHead;
        while(!s2.isEmpty()){
            temp.next = new ListNode(s2.pop());
            temp = temp.next;
        }
        return newHead.next;
    }
}
