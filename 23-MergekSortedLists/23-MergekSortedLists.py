"""

23. Merge k Sorted Lists

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:

Input: lists = []
Output: []

Example 3:

Input: lists = [[]]
Output: []

Constraints:

    k == lists.length
    0 <= k <= 104
    0 <= lists[i].length <= 500
    -104 <= lists[i][j] <= 104
    lists[i] is sorted in ascending order.
    The sum of lists[i].length will not exceed 104.

"""

# # Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
        
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        setattr(ListNode, "__lt__", lambda self, other: self.val <= other.val)
        newHead = ListNode(0)
        counter = newHead
        heap = []
        for head in lists:
             while head: 
                temp = head.next;
                head.next = None;
                heapq.heappush(heap, head)
                head = temp;
        while heap:
            counter.next = heappop(heap);
            counter = counter.next;
        return newHead.next;


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists: return None
        def merge(l1, l2):
            if not l1: return l2
            if not l2: return l1
            if l1.val <= l2.val:
                l1.next = merge(l1.next, l2)
                return l1
            else:
                l2.next = merge(l1, l2.next)
                return l2
        def partition(lo, hi):
            if lo >= hi: return lists[lo]
            mid = lo + (hi - lo) // 2
            l1 = partition(lo, mid)
            l2 = partition(mid + 1, hi)
            return merge(l1, l2)
            return merge(l1, l2);
        return partition(0, len(lists) - 1)
