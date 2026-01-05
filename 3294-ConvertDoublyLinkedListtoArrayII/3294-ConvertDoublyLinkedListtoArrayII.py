"""

3294. Convert Doubly Linked List to Array II

You are given an arbitrary node from a doubly linked list, which contains nodes that have a next pointer and a previous pointer.

Return an integer array which contains the elements of the linked list in order.

Example 1:

Input: head = [1,2,3,4,5], node = 5

Output: [1,2,3,4,5]

Example 2:

Input: head = [4,5,6,7,8], node = 8

Output: [4,5,6,7,8]

Constraints:

    The number of nodes in the given list is in the range [1, 500].
    1 <= Node.val <= 1000
    All nodes have unique Node.val.

"""

"""
# Definition for a Node.
class Node:
    def __init__(self, val, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next
"""
class Solution:
    def toArray(self, node: 'Optional[Node]') -> List[int]:
        if not node: return False
        temp = node
        head = None
        while temp:
            head = temp
            temp = temp.prev
        res = []
        while head:
            res.append(head.val)
            head = head.next
        return res
