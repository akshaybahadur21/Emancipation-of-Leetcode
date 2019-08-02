/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

Question : https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  
        ListNode res=dummyHead;
        int carry=0;
        while(l1!=null || l2!=null)
        {
            int x1 = (l1 != null) ? l1.val : 0;
            int x2 = (l2 != null) ? l2.val : 0;        
            int temp=x1 + x2 + carry;
            if (temp>=10)
            {
                res.next= new ListNode(temp%10);
                carry=1;
            }
            else
            {
                res.next= new ListNode(temp);
                carry=0;
            }
            
            res=res.next;
            if (l1!=null)
            l1=l1.next;
            if (l2!=null)
            l2=l2.next;
        }
        if (carry==1)
            res.next= new ListNode(carry);
        
        return dummyHead.next;
        
    }
}
