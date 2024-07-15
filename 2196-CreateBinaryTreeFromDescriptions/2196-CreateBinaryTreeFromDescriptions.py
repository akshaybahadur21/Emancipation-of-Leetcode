"""

2196. Create Binary Tree From Descriptions

You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

    If isLefti == 1, then childi is the left child of parenti.
    If isLefti == 0, then childi is the right child of parenti.

Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

Example 1:

Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.

Example 2:

Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.

Constraints:

    1 <= descriptions.length <= 104
    descriptions[i].length == 3
    1 <= parenti, childi <= 105
    0 <= isLefti <= 1
    The binary tree described by descriptions is valid.

"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        _map = {}
        child_set = set()
        parent_set = set()
        for d in descriptions:
            p_val, c_val = d[0], d[1]
            if p_val in _map.keys(): parent_node = _map[p_val]
            else:
                parent_node = TreeNode(p_val)
                _map[p_val] = parent_node
            if c_val in _map.keys(): child_node = _map[c_val]
            else: 
                child_node = TreeNode(c_val)
                _map[c_val] = child_node
            child_set.add(child_node.val)
            parent_set.add(parent_node.val)
            if d[2] == 1: parent_node.left = child_node
            else: parent_node.right = child_node
        
        for p in parent_set:
            if p not in child_set:
                return _map[p]
        return None
        
