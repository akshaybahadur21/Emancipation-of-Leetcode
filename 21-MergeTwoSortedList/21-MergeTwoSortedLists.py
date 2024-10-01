"""

21. Merge Two Sorted Lists

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

Constraints:

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.

"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        newHead = ListNode(0)
        temp = newHead
        while list1 or list2:
            node1 = list1 if list1 else ListNode(100_000)
            node2 = list2 if list2 else ListNode(100_000)
            if node1.val < node2.val:
                temp.next = ListNode(node1.val)
                if list1: list1 = list1.next
            else:
                temp.next = ListNode(node2.val)
                if list2: list2 = list2.next
            temp = temp.next
        return newHead.next
