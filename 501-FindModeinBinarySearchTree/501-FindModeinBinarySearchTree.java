/*

501. Find Mode in Binary Search Tree
Easy

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than or equal to the node's key.
    The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
    Both the left and right subtrees must also be binary search trees.

 

For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2


return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> lookupMap = new HashMap<>();
        dfs(root, lookupMap);
        List<Integer> resList = new ArrayList<>();
        final Map<Integer, Integer> sorted = lookupMap.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : sorted.entrySet()){
            if (max <= entry.getValue()){
                resList.add(entry.getKey());
                max = entry.getValue();
            }
        }
        return resList.stream().mapToInt(i -> i).toArray();
        
    }
    private void dfs(TreeNode node, Map<Integer, Integer> lookupMap){
        if (node == null)
            return;
        lookupMap.put(node.val, lookupMap.containsKey(node.val) ? lookupMap.get(node.val) + 1 : 1);
        dfs(node.left, lookupMap);
        dfs(node.right, lookupMap);
    }
}
