"""

3831. Median of a Binary Search Tree Level

You are given the root of a Binary Search Tree (BST) and an integer level.

The root node is at level 0. Each level represents the distance from the root.

Return the median value of all node values present at the given level. If the level does not exist or contains no nodes, return -1.

The median is defined as the middle element after sorting the values at that level in non-decreasing order. If the number of values at that level is even, return the upper median (the larger of the two middle elements after sorting).

Example 1:

Input: root = [4,null,5,null,7], level = 2

Output: 7

Explanation:

The nodes at level = 2 are [7]. The median value is 7.

Example 2:

Input: root = [6,3,8], level = 1

Output: 8

Explanation:

The nodes at level = 1 are [3, 8]. There are two possible median values, so the larger one 8 is the answer.

Example 3:

Input: root = [2,1], level = 2

Output: -1

Explanation:

There is no node present at level = 2​​​​​​​, so the answer is -1.

Constraints:

    The number of nodes in the tree is in the range [1, 2 * 105].
    1 <= Node.val <= 106
    0 <= level <= 2 * 10​​​​​​​5

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelMedian(self, root: Optional[TreeNode], level: int) -> int:
        q = deque()
        q.append(root)
        mapp = {}
        res = 0
        curr_level = 0
        while q:
            lenn = len(q)
            temp = []
            for _ in range(lenn):
                curr = q.popleft()
                temp.append(curr.val)
                if curr.left: q.append(curr.left)
                if curr.right: q.append(curr.right)
            if curr_level == level:
                mid = len(temp) // 2
                if len(temp) % 2 != 0:
                    return temp[mid]
                else:
                    return max(temp[mid - 1], temp[mid])
            curr_level += 1
        return -1
