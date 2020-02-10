/*

508. Most Frequent Subtree Sum
Medium

Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3

return [2, -3, 4], since all the values happen only once, return all of them in any order.

Examples 2
Input:

  5
 /  \
2   -5

return [2], since 2 happens twice, however -5 only occur once.

Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.

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
    Map<Integer, Integer> lookupMap = new HashMap<>();
    int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res = new ArrayList<>();
        for (int s : lookupMap.keySet()) {
            if (lookupMap.get(s) == maxCount)
                res.add(s);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    private int dfs(TreeNode node){
        if (node == null)
            return 0;
        int sum = dfs(node.left) + dfs(node.right) + node.val;
        lookupMap.put(sum, lookupMap.containsKey(sum) ? lookupMap.get(sum) + 1 : 1 );
        maxCount = Math.max(maxCount , lookupMap.get(sum));
        return sum;
        
    }
}
