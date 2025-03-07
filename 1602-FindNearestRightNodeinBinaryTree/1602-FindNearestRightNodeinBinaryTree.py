"""

1602. Find Nearest Right Node in Binary Tree

Given the root of a binary tree and a node u in the tree, return the nearest node on the same level that is to the right of u, or return null if u is the rightmost node in its level.

Example 1:

Input: root = [1,2,3,null,4,5,6], u = 4
Output: 5
Explanation: The nearest node on the same level to the right of node 4 is node 5.

Example 2:

Input: root = [3,null,4,2], u = 2
Output: null
Explanation: There are no nodes to the right of 2.

Constraints:

    The number of nodes in the tree is in the range [1, 105].
    1 <= Node.val <= 105
    All values in the tree are distinct.
    u is a node in the binary tree rooted at root.

"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findNearestRightNode(self, root: TreeNode, u: TreeNode) -> Optional[TreeNode]:
        q = deque()
        q.append(root)
        while q:
            lenn = len(q)
            for i in range(lenn):
                curr = q.popleft()
                if curr == u:
                    if len(q) == 0 or i == lenn - 1: return None
                    else: return q.popleft()
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
        return None
