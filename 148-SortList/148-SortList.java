/*

148. Sort List
Medium

Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

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
    public ListNode sortList(ListNode head) {
        // Approaches
        // 1 . keep a min heap and create a new list using heap (not recommended)
        // 2. Merge sort
        
        Queue<ListNode> heap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        while(head != null){
            ListNode temp = head;
            heap.add(head);
            head = head.next;
            temp.next = null; // breaking connections
        }
        
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while(!heap.isEmpty()){
            newHead.next = heap.poll();
            newHead = newHead.next;
        }
        return temp.next;
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
    public ListNode sortList(ListNode head) {
        // Approaches
        // 1 . keep a min heap and create a new list using heap (not recommended)
        // 2. Merge sort
        
        if (head == null || head.next == null) return head;
        ListNode fast = head, slow = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
           
        }
        prev.next = null; // breaking connections
        
        // splitting into 2 halves
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        //merge l1 and l2
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode l = new ListNode(0);
        ListNode returnNode = l;
        while(l1 != null && l2!= null){
            if (l1.val <= l2.val){
                l.next = l1;
                l1 = l1.next;
            }
            else{
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }
        if (l1 != null)
            l.next = l1;
        else
            l.next = l2;
        
        return returnNode.next;
    }
}
