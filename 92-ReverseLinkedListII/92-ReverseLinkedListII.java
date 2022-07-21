/*

92. Reverse Linked List II
Medium

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]

Constraints:

    The number of nodes in the list is n.
    1 <= n <= 500
    -500 <= Node.val <= 500
    1 <= left <= right <= n

 
Follow up: Could you do it in one pass

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //Stack Based Approach
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = new ListNode(0);
        ListNode dummy = newHead;
        for(int i = 0; i < m-1; i++ ){
            newHead.next = new ListNode(head.val);
            head = head.next;
            newHead = newHead.next;
        }
        for(int i = 0; i <= n - m; i++) {
            stack.push(new ListNode(head.val));
            head = head.next;
        }
        while(!stack.isEmpty()){
            newHead.next = stack.pop();
            newHead = newHead.next;
        }
        newHead.next = head;
        return dummy.next;
    }
}

// Iterative approach
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        right = right - left + 1;
        while(--left != 0){
            temp.next = new ListNode(head.val);
            head = head.next;
            temp = temp.next;
        }
        ListNode prev = null, curr = head;
        while(right-- != 0){
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        while(prev != null){
            temp.next = new ListNode(prev.val);
            prev = prev.next;
            temp = temp.next;
        }
        while(curr != null){
            temp.next = new ListNode(curr.val);
            curr = curr.next;
            temp = temp.next;
        }
        
        return newHead.next;
        
    }
}
