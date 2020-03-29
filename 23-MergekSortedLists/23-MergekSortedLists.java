/*

23. Merge k Sorted Lists
Hard

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6


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
    public ListNode mergeKLists(ListNode[] lists) {
        //Approach 1
        // minHeap for storing all nodes
        // Approach 2
        // mergesort for divide and conquer
        if (lists.length == 0)
            return null;
        Queue<ListNode> heap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        ListNode pseudoHead = new ListNode(0);
        ListNode counter = pseudoHead;
        for(ListNode head : lists){
            while(head != null){
                ListNode temp = head.next;
                head.next = null;
                heap.add(head);
                head = temp;
            }
        }
        while(!heap.isEmpty()){
            counter.next = heap.poll();
            counter = counter.next;
        }
        return pseudoHead.next;
    }
}
