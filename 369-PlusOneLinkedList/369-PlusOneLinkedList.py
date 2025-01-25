"""

369. Plus One Linked List

Given a non-negative integer represented as a linked list of digits, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list.

Example 1:

Input: head = [1,2,3]
Output: [1,2,4]

Example 2:

Input: head = [0]
Output: [1]

Constraints:

    The number of nodes in the linked list is in the range [1, 100].
    0 <= Node.val <= 9
    The number represented by the linked list does not contain leading zeros except for the zero itself. 

"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def plusOne(self, head: ListNode) -> ListNode:
        stack, res = [], []
        carry = 1
        while head:
            stack.append(head.val)
            head = head.next
        while stack:
            curr = stack.pop()
            curr += carry
            carry = curr // 10
            curr = curr % 10
            res.append(curr)
        if carry == 1: res.append(carry)
        newHead = ListNode(0)
        temp = newHead
        while res:
            temp.next = ListNode(res.pop())
            temp = temp.next
        return newHead.next
