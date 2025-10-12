"""

968. Binary Tree Cameras

You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

Example 1:

Input: root = [0,0,null,0,0]
Output: 1
Explanation: One camera is enough to monitor all nodes if placed as shown.

Example 2:

Input: root = [0,0,null,0,null,0,null,null,0]
Output: 2
Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.

Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    Node.val == 0

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minCameraCover(self, root: Optional[TreeNode]) -> int:
        def dfs(node, parent):
            if not node: return
            dfs(node.left, node)
            dfs(node.right, node)
            if (parent is None and node not in vis) or (node.left not in vis or node.right not in vis):
                res[0] += 1
                vis.add(node)
                vis.add(parent)
                vis.add(node.left)
                vis.add(node.right)
        res = [0]
        vis = {None}
        dfs(root, None)
        return res[0]
