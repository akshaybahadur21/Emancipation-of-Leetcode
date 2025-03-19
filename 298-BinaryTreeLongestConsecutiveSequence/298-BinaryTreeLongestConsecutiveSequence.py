"""

298. Binary Tree Longest Consecutive Sequence

Given the root of a binary tree, return the length of the longest consecutive sequence path.

A consecutive sequence path is a path where the values increase by one along the path.

Note that the path can start at any node in the tree, and you cannot go from a node to its parent in the path.

Example 1:

Input: root = [1,null,3,2,4,null,null,null,5]
Output: 3
Explanation: Longest consecutive sequence path is 3-4-5, so return 3.

Example 2:

Input: root = [2,null,3,2,null,1]
Output: 2
Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.

Constraints:

    The number of nodes in the tree is in the range [1, 3 * 104].
    -3 * 104 <= Node.val <= 3 * 104

"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestConsecutive(self, root: Optional[TreeNode]) -> int:
        def dfs(node, curr, target):
            if not node: return 
            if node.val == target: curr += 1
            else: curr = 1
            maxx[0] = max(maxx[0], curr)
            dfs(node.left, curr, node.val + 1)
            dfs(node.right, curr, node.val + 1)

        if not root: return 0
        maxx = [0]
        dfs(root, 0, root.val)
        return maxx[0]


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestConsecutive(self, root: Optional[TreeNode]) -> int:
        def dfs(node):
            if not node: return 0
            left, right = 1, 1
            if node.left and node.left.val == 1 + node.val:
                left = 1 + dfs(node.left)
            if node.right and node.right.val == 1 + node.val:
                right = 1 + dfs(node.right)
            return max(left, right)

        if not root: return 0
        return max(dfs(root), self.longestConsecutive(root.left), longestConsecutive(root.right))
