"""

1382. Balance a Binary Search Tree

Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

Example 1:

Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.

Example 2:

Input: root = [2,1,3]
Output: [2,1,3]

Constraints:

    The number of nodes in the tree is in the range [1, 104].
    1 <= Node.val <= 105

"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def balanceBST(self, root: TreeNode) -> TreeNode:
        def in_order(_node, _list):
            if not _node:
                return
            in_order(_node.left, _list)
            _list.append(_node)
            in_order(_node.right, _list)
        
        def dfs(_list, _lo, _hi):
            if _lo > _hi:
                return None
            _mid = _lo + (_hi - _lo) // 2
            _node = _list[_mid]
            _node.left = dfs(_list, _lo, _mid - 1)
            _node.right = dfs(_list, _mid + 1, _hi)
            return _node

        _list = []
        in_order(root, _list)
        return dfs(_list, 0, len(_list) - 1)
        
