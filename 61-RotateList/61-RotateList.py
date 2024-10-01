"""

61. Rotate List

Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:

    The number of nodes in the list is in the range [0, 500].
    -100 <= Node.val <= 100
    0 <= k <= 2 * 109

"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head: return None
        length = 0
        temp = head
        while temp:
            length += 1
            temp = temp.next
        k = k % length
        newHead = ListNode(0)
        temp = newHead
        curr = head
        length -= k
        for i in range(length): curr = curr.next
        while curr:
            temp.next = ListNode(curr.val)
            temp = temp.next
            curr = curr.next
        while length != 0:
            temp.next = ListNode(head.val)
            head = head.next
            temp = temp.next
            length -= 1
        return newHead.next
