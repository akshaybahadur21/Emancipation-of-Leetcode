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

// Approach 2
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return partition(lists, 0, lists.length - 1);
    }
    private ListNode partition(ListNode[] lists, int lo, int hi){
        if(lo >= hi) return lists[lo];
        int mid = lo + (hi - lo) / 2;
        ListNode l1 = partition(lists, lo, mid);
        ListNode l2 = partition(lists, mid + 1, hi);
        return merge(l1, l2);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next, l2);
            return l1;
        }
        else{
            l2.next = merge(l1, l2.next);
            return l2;
        }
        
    }
}
