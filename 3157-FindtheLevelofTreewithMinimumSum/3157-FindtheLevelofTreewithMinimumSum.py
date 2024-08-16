"""

3157. Find the Level of Tree with Minimum Sum

Given the root of a binary tree root where each node has a value, return the level of the tree that has the minimum sum of values among all the levels (in case of a tie, return the lowest level).

Note that the root of the tree is at level 1 and the level of any other node is its distance from the root + 1.

Example 1:

Input: root = [50,6,2,30,80,7]

Output: 2

Explanation:

Example 2:

Input: root = [36,17,10,null,null,24]

Output: 3

Explanation:

Example 3:

Input: root = [5,null,5,null,5]

Output: 1

Explanation:

Constraints:

    The number of nodes in the tree is in the range [1, 105].
    1 <= Node.val <= 109

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minimumLevel(self, root: Optional[TreeNode]) -> int:
        q = deque()
        q.append(root)
        level = 0
        _min = float("inf")
        res = -1
        while q:
            length = len(q)
            level += 1
            _sum = 0
            for i in range(length):
                curr = q.popleft()
                _sum += curr.val
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
            if _sum < _min:
                _min = _sum
                res = level
        return res
