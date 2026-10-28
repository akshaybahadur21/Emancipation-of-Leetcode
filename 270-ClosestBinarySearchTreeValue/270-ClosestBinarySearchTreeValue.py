"""

270. Closest Binary Search Tree Value

Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target. If there are multiple answers, print the smallest.

Example 1:

Input: root = [4,2,5,1,3], target = 3.714286
Output: 4

Example 2:

Input: root = [1], target = 4.428571
Output: 1

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    0 <= Node.val <= 109
    -109 <= target <= 109

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def closestValue(self, root: TreeNode | None, target: float) -> int:
        def dfs(node, res):
            if not node: return
            diff, val = res
            curr_diff = abs(node.val - target)
            if curr_diff < diff:
                res[0], res[1] = curr_diff, node.val
            if curr_diff == diff:
                if val > node.val: 
                    res[1] = node.val
            if node.val > target:
                dfs(node.left, res)
            else:
                dfs(node.right, res)
        res = [inf, 0]
        dfs(root, res)
        return res[-1]
