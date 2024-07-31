"""

234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a
palindrome
or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true

Example 2:

Input: head = [1,2]
Output: false

Constraints:

    The number of nodes in the list is in the range [1, 105].
    0 <= Node.val <= 9

 
Follow up: Could you do it in O(n) time and O(1) space?

"""

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isaPalindrome(self, head: Optional[ListNode]) -> bool:
        q, length = deque(), 0
        temp = head
        while temp:
            temp = temp.next
            length += 1
        temp = head
        for i in range(length // 2):
            q.append(temp)
            temp = temp.next
        if length % 2 != 0: temp = temp.next
        while temp:
            if temp.val != q[-1].val: return False
            temp = temp.next
            q.pop()
        return True
