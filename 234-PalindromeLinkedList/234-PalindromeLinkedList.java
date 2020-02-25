/*

234. Palindrome Linked List
Easy

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false

Example 2:

Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?

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
    public boolean isPalindrome(ListNode head) {
        //Couple of Approach
        //1. Use stack
        //2. convert val to string and check equals
        //3. Do it in place with O(1)
        
        if (head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        ListNode temp = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != null){
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        
        while(prev != null){
            if (head == null) return false;
            if (prev.val != head.val)
                return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        //Couple of Approach
        //1. Use stack
        //2. convert val to string and check equals
        //3. Do it in place with O(1)
        if (head == null) return true;
        StringBuilder sb = new StringBuilder();
        Stack<String> s = new Stack<>();
        while(head!= null){
            sb.append(String.valueOf(head.val)).append(",");
            s.push(String.valueOf(head.val));
            head = head.next;
        }
        String str[] = sb.toString().split(",");
        for (String sr : str){
            if (!String.valueOf(sr).equals(s.pop()))
                return false;
        }
        return true;
    }
}
