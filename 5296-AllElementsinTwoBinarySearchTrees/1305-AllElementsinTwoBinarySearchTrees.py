"""

1305. All Elements in Two Binary Search Trees

Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.

Example 1:

Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:

Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]

Constraints:

    The number of nodes in each tree is in the range [0, 5000].
    -105 <= Node.val <= 105

"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getAllElements(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> List[int]:
        s1, s2 = [], []
        res = []
        while root1:
            s1.append(root1)
            root1 = root1.left
        while root2:
            s2.append(root2)
            root2 = root2.left
        while s1 or s2:
            n1 = None if not s1 else s1[-1]
            n2 = None if not s2 else s2[-1]

            if not n2 or (n1 and n1.val <= n2.val):
                node = s1.pop()
                res.append(node.val)
                node = node.right
                while node:
                    s1.append(node)
                    node = node.left
            
            else:
                node = s2.pop()
                res.append(node.val)
                node = node.right
                while node:
                    s2.append(node)
                    node = node.left
        return res
