"""

1740. Find Distance in a Binary Tree

Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.

The distance between two nodes is the number of edges on the path from one to the other.

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
Output: 3
Explanation: There are 3 edges between 5 and 0: 5-3-1-0.

Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 7
Output: 2
Explanation: There are 2 edges between 5 and 7: 5-2-7.

Example 3:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 5
Output: 0
Explanation: The distance between a node and itself is 0.

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    0 <= Node.val <= 109
    All Node.val are unique.
    p and q are values in the tree.

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDistance(self, root: Optional[TreeNode], p: int, q: int) -> int:
        def fill_maps(node, parent):
            if not node: return
            node_map[node.val] = node
            parent_map[node] = parent
            fill_maps(node.left, node)
            fill_maps(node.right, node)
        parent_map = {}
        node_map = {}
        fill_maps(root, None)
        vis = set()
        queue = deque()
        queue.append(node_map[p])
        res = 0
        while queue:
            lenn = len(queue)
            for i in range(lenn):
                curr = queue.popleft()
                if curr in vis: continue
                vis.add(curr)
                if curr.val == q: return res
                if curr.left: queue.append(curr.left)
                if curr.right: queue.append(curr.right)
                if parent_map[curr]: queue.append(parent_map[curr])
            res += 1
        return -1
