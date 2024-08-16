"""

257. Binary Tree Paths

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

Example 1:

Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Example 2:

Input: root = [1]
Output: ["1"]

Constraints:

    The number of nodes in the tree is in the range [1, 100].
    -100 <= Node.val <= 100

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def binaryTreePaths(self, root: Optional[TreeNode]) -> List[str]:
        res = []
        def dfs(node, curr):
            if node == None: return
            if node.left == None and node.right == None:
                res.append(curr+f"{node.val}")
            dfs(node.left, curr+f"{node.val}->")
            dfs(node.right, curr+f"{node.val}->")
        dfs(root, "")

        return res
