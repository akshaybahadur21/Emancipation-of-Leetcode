"""

203. Remove Linked List Elements

Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example 1:

Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:

Input: head = [], val = 1
Output: []

Example 3:

Input: head = [7,7,7,7], val = 7
Output: []

Constraints:

    The number of nodes in the list is in the range [0, 104].
    1 <= Node.val <= 50
    0 <= val <= 50

"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        newHead = ListNode(0)
        newHead.next = head
        prev, curr = newHead, head
        while curr:
            if curr.val == val:
                if not curr.next: prev.next = None
                else: prev.next = curr.next
                curr = curr.next
            else:
                prev = curr
                curr = curr.next
        return newHead.next
