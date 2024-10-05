"""

1315. Sum of Nodes with Even-Valued Grandparent

Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.

A grandparent of a node is the parent of its parent if it exists.

Example 1:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

Example 2:

Input: root = [1]
Output: 0

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    1 <= Node.val <= 100

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumEvenGrandparent(self, root: TreeNode) -> int:
        res = [0]
        def dfs(node):
            if not node: return
            if node.val % 2 == 0:
                if node.left and node.left.left: res[0] += node.left.left.val;
                if node.left and node.left.right: res[0] += node.left.right.val;
                if node.right and node.right.right: res[0] += node.right.right.val;
                if node.right and node.right.left: res[0] += node.right.left.val;
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        return res[0]
